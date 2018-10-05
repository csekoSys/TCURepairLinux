package csekosys.sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Terminal {

    public static BufferedReader getBufferedReader(String command) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            return reader;

        } catch (IOException ex) {
            Logger.getLogger(Terminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String execSingle(String command) {
        String result = "";
        BufferedReader reader = getBufferedReader(command);
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                result = line;
            }
        } catch (IOException ex) {
            Logger.getLogger(Terminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static List<String> execSingleStringList(String command) {
        List<String> result = new ArrayList<>();
        BufferedReader reader = getBufferedReader(command);
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(Terminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }


}
