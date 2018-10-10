package csekosys.sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LogfilesProcessing {

    /**
     * Logmappák listája
     * Sorba rendezve 
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

}
