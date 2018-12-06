package csekosys.sum;

import java.util.ArrayList;

public class Device {

    private String adbImsi;
    private XmlReader xmlRepo;
    private XmlReader xmlCasgreg;
    private XmlReader xmlVersion;
    private XmlReader xmlType;
    private ArrayList<Integer> logfileFoldersList;
    private ArrayList<Logfile> logfilesList;
    private ArrayList<Receipt> receiptListFromLogfile;
    private ArrayList<Closing> closingListFromLogfile;

    Device() {
    }

    public Device(String adbImsi) {
        this.adbImsi = adbImsi;
        this.xmlRepo = new XmlReader(this, Constants.AEEAPP_SHARED_PREFS_PATH, "repository.xml");
        this.xmlCasgreg = new XmlReader(this, Constants.CASHREG_SHARED_PREFS_PATH, "com.tekinvest.novatek.cashregister_preferences.xml");
        this.xmlVersion = new XmlReader(this, Constants.TEKI_PATH, "version.xml");
        this.xmlType = new XmlReader(this, Constants.TEKI_PATH, "type.xml");
    }

    public String getAdbImsi() {
        return adbImsi;
    }

    public String getAdbCommand(String command) {
        String cmd = "adb -s " + adbImsi + " shell " + command;
        return cmd;
    }

    public String getCashregVersion() {
        String result;
        result = xmlCasgreg.searchXmlAttributum("SOFTWARE_VERSION_STRING");

        if (result == "") {
            result = "Nincs adat";
        }
        return result;
    }

    public String getCashregImsi() {
        String result;
        result = xmlCasgreg.searchXmlAttributum("Imsi");
        if (result == "") {
            result = "Nincs adat";
        }
        return result;
    }

    public String getCashregAp() {
        String result;
        result = xmlCasgreg.searchXmlAttributum("AP_STRING");
        if (result == "") {
            result = "Nincs adat";
        }
        return result;
    }

    public String getVersionVersion() {
        String result;
        result = xmlVersion.searchXmlField("DPF");
        if (result == "") {
            result = "Nincs adat";
        }
        return result;
    }

    public String getTypeType() {
        String result;
        result = xmlType.searchXmlField("cashRegisterType");
        if (result == "") {
            result = "Nincs adat";
        }
        return result;
    }

    public String getRepoTcuStatus() {
        String result;
        result = xmlRepo.searchXmlAttributum("TCUStatus");
        return result;
    }

    public String getRepoImei() {
        String result;
        result = xmlRepo.searchXmlAttributum("Imei");
        if (result == "") {
            result = "Nincs adat";
        }
        return result;
    }

    public boolean isRepoLearningMode() {
        boolean result;
        String result_tmp;
        result_tmp = xmlRepo.searchXmlAttributum("LearningMode1");
        result = Boolean.parseBoolean(result_tmp);
        return result;
    }

    public String getRepoLearningMode() {
        String result;
        result = xmlRepo.searchXmlAttributum("LearningMode1");
        if (result == "") {
            result = "Nincs adat";
        }
        return result;
    }

    public int getRepoCashregisterOpenCounter() {
        int result;
        String result_tmp = null;
        result = Integer.parseInt(result_tmp);
        return result;
    }

    public int getRepoReceiptCounter() {
        int result;
        String result_tmp;
        result_tmp = xmlRepo.searchXmlAttributum("ReceiptCounter");
        result = Integer.parseInt(result_tmp);
        return result;
    }

    public int getRepoCashregisterCloseCounter() {
        int result;
        String result_tmp;
        result_tmp = xmlRepo.searchXmlAttributum("CashregisterCloseCounter");
        result = Integer.parseInt(result_tmp);
        return result;
    }

    public String getRepoImsi() {
        String result;
        result = xmlRepo.searchXmlAttributum("Imsi");
        Status.setDeviceBasicDatas("IMSI", result);
        return result;
    }

    public String getRepoAp() {
        String result;
        result = xmlRepo.searchXmlAttributum("Ap");
        if (result == "") {
            result = "Nincs adat";
        }
        Status.setDeviceBasicDatas("AP", result);
        return result;
    }

    public int getRepoNumberOfLogfileWihLastClose() {
        int result;
        String result_tmp;
        result_tmp = xmlRepo.searchXmlAttributum("NumberOfLogfileWithLastClose");
        result = Integer.parseInt(result_tmp);
        return result;
    }

    public boolean isRepoNavBlocked() {
        boolean result;
        String result_tmp;
        result_tmp = xmlRepo.searchXmlAttributum("NavBlocked");
        result = Boolean.parseBoolean(result_tmp);
        return result;
    }

    public boolean isRepoOpened() {
        boolean result;
        String result_tmp;
        result_tmp = xmlRepo.searchXmlAttributum("Opened");
        result = Boolean.parseBoolean(result_tmp);
        Status.setDeviceBasicDatas("Nap", result_tmp);
        return result;
    }

    public boolean isRepoRegistered() {
        boolean result;
        String result_tmp;
        result_tmp = xmlRepo.searchXmlAttributum("Registered");
        result = Boolean.parseBoolean(result_tmp);
        return result;
    }

    public int getDbFirstClosing() {
        int result = 0;
        return result;
    }

    public int getDbEndClosing() {
        int result = 0;
        return result;
    }

    public int getLogfilesFirstLogfolder() {
        int result = logfileFoldersList.get(0);
        return result;
    }

    public int getLogfilesEndLogfolder() {
        int result = logfileFoldersList.get(logfileFoldersList.size() - 1);
        return result;
    }

    public ArrayList<Integer> getLogfileFoldersList() {
        logfileFoldersList = (ArrayList<Integer>) LogfilesProcessing.getLogFoldersList(this);
        return logfileFoldersList;
    }

    public void setLogfileFoldersList(ArrayList<Integer> logfileFoldersList) {
        this.logfileFoldersList = logfileFoldersList;
    }

    public ArrayList<Logfile> getLogfilesList() {
        logfilesList = (ArrayList<Logfile>) LogfilesProcessing.getLogfilesList(this);
        return logfilesList;
    }

    public void setLogfileList(ArrayList<Logfile> logfileList) {
        this.logfilesList = logfileList;
    }

    public ArrayList<Receipt> getReceiptFromLogfile() {
        receiptListFromLogfile = (ArrayList<Receipt>) LogfilesProcessing.getReceiptsFromLogfilesList(this);
        return receiptListFromLogfile;
    }

    public ArrayList<Closing> getClosingsFromLogfiles() {
        closingListFromLogfile = (ArrayList<Closing>) LogfilesProcessing.getClosingFromLogfilesList(this);
        return closingListFromLogfile;
    }

    public int getLogfilesEndLogfile() {
        int result = 0;
        return result;
    }

    public int getLogfilesEndClosing() {
        int result = 0;
        return result;
    }

}
