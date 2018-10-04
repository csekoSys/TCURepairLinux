package csekosys.sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AdbDevices {

    public static List<Device> getDevices() {
        ArrayList<Device> devices = new ArrayList<Device>();
        try {
            String command = "adb devices";
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line = "";
            int lineNum = 0;
            while ((line = reader.readLine()) != null) {
                if (lineNum > 0) {
                    String[] parts = line.split("\t");
                    if (parts.length == 2) {
                        devices.add(new Device(parts[0]));
                    }
                }
                lineNum++;
            }

            process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return devices;
    }
}
