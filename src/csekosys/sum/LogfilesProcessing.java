package csekosys.sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LogfilesProcessing {

    /**
     * Logmappák listája Sorba rendezve
     *
     * @return
     */
    public static List<Integer> getLogFoldersList(Device d) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        String cmd = d.getAdbCommand(" ls " + Constants.LOGS_PATH);

        try {
            Process proc = Runtime.getRuntime().exec(cmd);
            BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));

            String line = "";
            int lineNum = 0;
            while ((line = reader.readLine()) != null) {
                int lineInt = Integer.parseInt(line);
                if (lineNum >= 0) {
                    list.add(lineInt);
                }
                lineNum++;
            }

            proc.waitFor();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Tartalmaz számtól különböző karaktert is: " + e);
        }

        Collections.sort(list);

        return list;
    }

    /**
     * logfájl listája
     *
     * @param d
     * @return
     */
    public static List<Logfile> getLogfilesList(Device d) {
        String size;
        String date;
        String extension;
        String logNumber = null;
        String logFileName;
        String ap = null;
        String shortTaxNumber = null;
        String timestamp = null;

        ArrayList<Logfile> list = new ArrayList<>();
        String cmd = d.getAdbCommand(" ls -l " + Constants.LOGS_PATH + "*/*");

        try {
            Process proc = Runtime.getRuntime().exec(cmd);
            BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));

            String line = "";
            int lineNum = 0;

            while ((line = reader.readLine()) != null) {
                if (lineNum >= 0) {

                    String[] parts = line.split(" ");

                    logFileName = parts[parts.length - 1];
                    date = parts[parts.length - 3] + " " + parts[parts.length - 2];
                    size = parts[parts.length - 4];

                    String[] partsExtension = logFileName.split("\\.");
                    extension = partsExtension[1];

                    String[] partsLogFileName = partsExtension[0].split("_");

                    if (partsLogFileName.length == 3) {
                        ap = partsLogFileName[0];
                        shortTaxNumber = partsLogFileName[1];
                        timestamp = "";
                        logNumber = partsLogFileName[2];
                    } else if (partsLogFileName.length == 4) {
                        ap = partsLogFileName[0];
                        shortTaxNumber = partsLogFileName[1];
                        timestamp = partsLogFileName[2];
                        logNumber = partsLogFileName[3];

                    } else {
                        System.out.println("Hiba a logFileName feldarabolásakor! - " + logFileName);
                    }

                    list.add(new Logfile(Integer.parseInt(size), date, extension, Integer.parseInt(logNumber),
                            logFileName, ap, shortTaxNumber, timestamp));
                }
                lineNum++;
            }

            proc.waitFor();

        } catch (IOException | InterruptedException e) {
        }
        Collections.sort(list);

        return list;
    }

    /**
     * Logfájlokból kinyeri a nyugtákat
     *
     * @param d
     * @return
     */
    public static List<Receipt> getReceiptsFromLogfilesList(Device d) {
        String NSZ;
        String ZSZ;
        String NYS;
        String SUM;
        String CNC;
        String CTS;

        ArrayList<Receipt> list = new ArrayList<>();
        String cmd = d.getAdbCommand(" cat " + Constants.LOGS_PATH + "*/* |grep -a --text \\<NYN\\>");

        try {
            Process proc = Runtime.getRuntime().exec(cmd);
            BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));

            String line;
            int lineNum = 0;
            while ((line = reader.readLine()) != null) {
                System.out.println("\ncsekosys.sum.LogfilesProcessing.getReceiptsFromLogfilesList()" + line);
                if (lineNum >= 0) {
                    int startNSZ = line.indexOf("<NSZ>");
                    int endNSZ = line.indexOf("</NSZ>");
                    NSZ = line.substring(startNSZ + 5, endNSZ);
                    System.out.println("csekosys.sum.LogfilesProcessing.getReceiptsFromLogfilesList() NSZ - start - end: " + NSZ + " - " + startNSZ + " - " + endNSZ);
                    String[] parts = NSZ.split("/");
                    ZSZ = parts[0];
                    NYS = parts[1];
                    System.out.println("csekosys.sum.LogfilesProcessing.getReceiptsFromLogfilesList() ZSZ - NYS: " + ZSZ + " - " + NYS);

                    int startSUM = line.indexOf("<SUM>");
                    int endSUM = line.indexOf("</SUM>");
                    SUM = line.substring(startSUM + 5, endSUM);

                    int startCNC = line.indexOf("<CNC>");
                    int endCNC = line.indexOf("</CNC>");
                    CNC = line.substring(startCNC + 5, endCNC);

                    int startCTS = line.indexOf("<CTS>");
                    int endCTS = line.indexOf("</CTS>");
                    CTS = line.substring(startCTS + 5, endCTS);

                    System.out.println("csekosys.sum.LogfilesProcessing.getReceiptsFromLogfilesList()" + line);

                    list.add(new Receipt(NSZ, Integer.parseInt(ZSZ), Integer.parseInt(NYS), Integer.parseInt(SUM), Boolean.parseBoolean(CNC), CTS));

                }
                lineNum++;
            }
            proc.waitFor();

        } catch (IOException e) {
        } catch (InterruptedException e) {
        } catch (NumberFormatException e) {
        }

        Collections.sort(list);

        return list;
    }

    /**
     * Logfájlból kinyeri a napizárások adatait
     *
     * @return
     */
    public static List<Closing> getClosingFromLogfilesList(Device d) {
        String DTS = ""; // Időbélyeg, a bizonylat kiadásának pontos ideje az AEE órája szerint
        String ZSZ = ""; // a zárás sorszáma négy karakteren, szükség esetén vezető nullákkal feltöltve
        String NNS = ""; // a napi nyugták számalva
        String NSF = ""; // a napi forgalom összesen, bruttó összegben, egész forintban számolva
        String NSG = ""; // a göngyölített forgalom
        String CNC = ""; // Bizonylat megszakítása esetén a megszakítás tényének jelzése

        ArrayList<Closing> list = new ArrayList<>();
        String cmd = d.getAdbCommand(" cat " + Constants.LOGS_PATH + "*/* |grep -a --text \\<NFN\\>");

        try {
            Process proc = Runtime.getRuntime().exec(cmd);
            BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));

            String line = "";
            int lineNum = 0;
            while ((line = reader.readLine()) != null) {
                if (lineNum >= 0) {

                    int startDTS = line.indexOf("<DTS>");
                    int endDTS = line.indexOf("</DTS>");

                    int startZSZ = line.indexOf("<ZSZ>");
                    int endZSZ = line.indexOf("</ZSZ>");

                    int startNSF = line.indexOf("<NSF>");
                    int endNSF = line.indexOf("</NSF>");

                    int startNDB = line.indexOf("<NDB>");
                    int endNDB = line.indexOf("</NDB>");

                    int startNSG = line.indexOf("<NSG>");
                    int endNSG = line.indexOf("</NSG>");

                    int startCNC = line.indexOf("<CNC>");
                    int endCNC = line.indexOf("</CNC>");

                    DTS = line.substring(startDTS + 5, endDTS);
                    ZSZ = line.substring(startZSZ + 5, endZSZ);
                    NSF = line.substring(startNSF + 5, endNSF);
                    NSG = line.substring(startNSG + 5, endNSG);
                    CNC = line.substring(startCNC + 5, endCNC);

                    list.add(new Closing(Integer.parseInt(ZSZ), Integer.parseInt(NSF), Integer.parseInt(NSG), Boolean.parseBoolean(CNC), DTS));

                }
                lineNum++;
            }

            proc.waitFor();

        } catch (IOException e) {
        } catch (InterruptedException e) {
        } catch (NumberFormatException e) {
        }

        Collections.sort(list);

        return list;
    }

}
