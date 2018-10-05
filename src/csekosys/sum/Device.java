package csekosys.sum;

public class Device {

    private String adbImsi;
    private XmlReader xmlRepo;
    private XmlReader xmlCasgreg;
    private XmlReader xmlVersion;
    private XmlReader xmlType;

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
            Status.setInfoStatus("SOFTWARE_VERSION_STRING - Field nem létezik");
            result = "Nincs adat";
        }
        return result;
    }

    public String getCashregImsi() {
        String result;
        result = xmlCasgreg.searchXmlAttributum("Imsi");
        if (result == "") {
            Status.setInfoStatus("CashregImsi - Field nem létezik");
            result = "Nincs adat";
        }
        return result;
    }

    public String getCashregAp() {
        String result;
        result = xmlCasgreg.searchXmlAttributum("AP_STRING");
        if (result == "") {
            Status.setInfoStatus("Cashreg AP_STRING - Field nem létezik");
            result = "Nincs adat";
        }
        return result;
    }

    public String getVersionVersion() {
        String result;
        result = xmlVersion.searchXmlField("DPF");
        if (result == "") {
            Status.setInfoStatus("Version DPF - Field nem létezik");
            result = "Nincs adat";
        }
        return result;
    }

    public String getTypeType() {
        String result;
        result = xmlType.searchXmlField("cashRegisterType");
        if (result == "") {
            Status.setInfoStatus("Type cashRegisterType - Field nem létezik");
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
            Status.setInfoStatus("Repo Imei - Field nem létezik");
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
            Status.setInfoStatus("Repo LearningMode - Field nem létezik");
            result = "Nincs adat";
        }
        return result;
    }

    public int getRepoCashregisterOpenCounter() {
        int result;
        String result_tmp;
        result_tmp = xmlRepo.searchXmlAttributum("CashRegisterOpenCounter");
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
        return result;
    }

    public String getRepoAp() {
        String result;
        result = xmlRepo.searchXmlAttributum("Ap");
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
        int result = 0;
        return result;
    }

    public int getLogfilesEndLogfolder() {
        int result = 0;
        return result;
    }

    public int getLogfilesFirstLogfile() {
        int result = 0;
        return result;
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
