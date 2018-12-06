package csekosys.sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Backup {

    /**
     * SD kártya másolása a localis gépre
     * @param d
     * @throws java.lang.InterruptedException
     */
    public static void sdBackup(Device d) {
        System.out.println("csekosys.sum.Backup.sdBackup() START");
        try {
            String cmd = d.getAdbCommand(" pull data/tpm" /*Backup/" + d.getAdbImsi() + "/data/tpm"*/);
//			String cmd = "adb -s " + adbImsi + " ls data/tpm";
            Runtime runtime = Runtime.getRuntime();
            Process proc = runtime.exec(cmd);
            BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            proc.waitFor();

            System.out.println("DATA adatok mentve");

        } catch (IOException e) {

            System.out.println("Fájl, vagy könyvtár nem létezik " + e);
        } catch (InterruptedException e) {
        }
    }


    
}
