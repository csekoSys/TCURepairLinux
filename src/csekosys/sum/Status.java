package csekosys.sum;

import java.util.ArrayList;
import java.util.List;

public class Status {

    private static List<String> deviceBasicDataList = new ArrayList<>();
    private static List<String> errorStatusList = new ArrayList<>();
    private static List<String> infoStatusList = new ArrayList<>();

//    public Status() {
//     deviceBasicDataList = new ArrayList<>();
//    errorStatusList = new ArrayList<>();
//    infoStatusList = new ArrayList<>();       
//    }
    
    
    public static void setDeviceBasicDatas(String text) {
        deviceBasicDataList.add(text);
    }

    public static void setErrorStatus(String text) {
        errorStatusList.add(text);
    }

    public static void setInfoStatus(String text) {
        infoStatusList.add(text);
    }

    public static List<String> getInfoStatus() {
        return infoStatusList;
    }

}
