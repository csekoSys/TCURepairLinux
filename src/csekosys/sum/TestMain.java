package csekosys.sum;

import java.util.ArrayList;
import java.util.List;

public class TestMain {

    static String adbImsi = AdbDevices.getDevices().get(0).getAdbImsi();
    static Device device = new Device(adbImsi);
    

    public static void main(String[] args) {
        deviceTest();
        //       terminalTest();
        //       xmlReaderTest();
        statusTest();
    }

    public static void deviceTest() {
        System.out.println("getCashregVersion: " + device.getCashregVersion());
        System.out.println("getCashregImsi: " + device.getCashregImsi());
        System.out.println("getCashregAp: " + device.getCashregAp());
        System.out.println("getVersionVersion: " + device.getVersionVersion());
        System.out.println("getTypeType: " + device.getTypeType());
        System.out.println("repoTcuStatus: " + device.getRepoTcuStatus());
        System.out.println("getRepoImei: " + device.getRepoImei());
        System.out.println("getRepoLearningMode: " + device.getRepoLearningMode());
        System.out.println("getRepoCashregisterOpenCounter: " + device.getRepoCashregisterOpenCounter());
        System.out.println("getRepoReceiptCounter: " + device.getRepoReceiptCounter());
        System.out.println("getRepoCashregisterCloseCounter: " + device.getRepoCashregisterCloseCounter());
        System.out.println("getRepoImsi: " + device.getRepoImsi());
        System.out.println("getRepoAp: " + device.getRepoAp());
        System.out.println("getRepoNumberOfLogfileWihLastClose: " + device.getRepoNumberOfLogfileWihLastClose());
        System.out.println("isRepoNavBlocked: " + device.isRepoNavBlocked());
        System.out.println("isRepoOpened: " + device.isRepoOpened());
        System.out.println("isRepoRegistered: " + device.isRepoRegistered());

    }

    public static void terminalTest() {
        List<String> list = Terminal.execSingleStringList(device.getAdbCommand("ls -l /data/tpm"));

        for (int i = 0; i < list.size(); i++) {
            System.err.println("List: " + list.get(i));
        }
    }

    public static void xmlReaderTest() {
        XmlReader xml = new XmlReader(device, Constants.AEEAPP_SHARED_PREFS_PATH, "repository.xml");
        System.out.println("találat: " + xml.searchXmlAttributum("NumberOfLogfileWithLastClose"));
    }

    public static void statusTest() {
        ArrayList<String> infoStatusList = (ArrayList<String>) Status.getInfoStatus();
        ArrayList<String> deviceBasicDataList = (ArrayList<String>) Status.getDeviceBasicDatas();

        System.out.println("InfoStatus");
        for (String string : infoStatusList) {
            System.out.println(string);
        }
        System.out.println("Device basec info");
        for (String string : deviceBasicDataList) {
            System.out.println(string);
        }
    }

}
