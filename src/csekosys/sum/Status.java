package csekosys.sum;

import java.util.ArrayList;
import java.util.List;

public class Status {

    private static List<String> deviceBasicDataList = new ArrayList<>();
    private static List<String> errorStatusList = new ArrayList<>();
    private static List<String> infoStatusList = new ArrayList<>();

    public Status() {

    }

    public static void setDeviceBasicDatas(String name, String value) {
        deviceBasicDataList.add(name + ": " + value);
    }

    public static List<String> getDeviceBasicDatas() {
        return deviceBasicDataList;
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
