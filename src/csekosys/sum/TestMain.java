package csekosys.sum;

import java.util.List;

public class TestMain {

    static String adbImsi = AdbDevices.getDevices().get(0).getAdbImsi();
    static Device device = new Device(adbImsi);

    public static void main(String[] args) {
        deviceTest();
        //       terminalTest();
//        xmlReaderTest();
    }

    public static void deviceTest() {
        System.err.println("getCashregVersion: " + device.getCashregVersion());
        System.err.println("getCashregImsi: " + device.getCashregImsi());
        System.err.println("getCashregAp: " + device.getCashregAp());
        System.err.println("getVersionVersion: " + device.getVersionVersion());
        System.err.println("getTypeType: " + device.getTypeType());
        System.err.println("repoTcuStatus: " + device.getRepoTcuStatus());
        System.err.println("getRepoImei: " + device.getRepoImei());
        System.err.println("isRepoLearningMode: " + device.isRepoLearningMode());
        System.err.println("getRepoCashregisterOpenCounter: " + device.getRepoCashregisterOpenCounter());
        System.err.println("getRepoReceiptCounter: " + device.getRepoReceiptCounter());
        System.err.println("getRepoCashregisterCloseCounter: " + device.getRepoCashregisterCloseCounter());
        System.err.println("getRepoImsi: " + device.getRepoImsi());
        System.err.println("getRepoAp: " + device.getRepoAp());
        System.err.println("getRepoNumberOfLogfileWihLastClose: " + device.getRepoNumberOfLogfileWihLastClose());
        System.err.println("isRepoNavBlocked: " + device.isRepoNavBlocked());
        System.err.println("isRepoOpened: " + device.isRepoOpened());
        System.err.println("isRepoRegistered: " + device.isRepoRegistered());
    
    }

    public static void terminalTest() {
        List<String> list = Terminal.execSingleStringList(device.getAdbCommand("ls -l /data/tpm"));

        for (int i = 0; i < list.size(); i++) {
            System.err.println("List: " + list.get(i));
        }
    }

    public static void xmlReaderTest() {
        XmlReader xml = new XmlReader(device, Constants.TEKI_PATH, "version.xml");
        System.out.println("találat: " + xml.searchXmlField("DPF"));
    }
}
