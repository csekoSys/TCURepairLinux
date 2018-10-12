package csekosys.sum;

public class Logfile implements Comparable<Logfile> {

    private int fileSize;
    private String fileDate;
    private String fileExtencion;
    private int logfileNumber;
    private String logfileName;
    private String ap;
    private String shortTaxNumber;
    private String timestamp;

    public Logfile(int fileSize, String fileDate, String fileExtencion, int logfileNumber, String logfileName, String ap, String shortTaxNumber, String timestamp) {
        this.fileSize = fileSize;
        this.fileDate = fileDate;
        this.fileExtencion = fileExtencion;
        this.logfileNumber = logfileNumber;
        this.logfileName = logfileName;
        this.ap = ap;
        this.shortTaxNumber = shortTaxNumber;
        this.timestamp = timestamp;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileDate() {
        return fileDate;
    }

    public void setFileDate(String fileDate) {
        this.fileDate = fileDate;
    }

    public String getFileExtencion() {
        return fileExtencion;
    }

    public void setFileExtencion(String fileExtencion) {
        this.fileExtencion = fileExtencion;
    }

    public int getLogfileNumber() {
        return logfileNumber;
    }

    public void setLogfileNumber(int logfileNumber) {
        this.logfileNumber = logfileNumber;
    }

    public String getLogfileName() {
        return logfileName;
    }

    public void setLogfileName(String logfileName) {
        this.logfileName = logfileName;
    }

    public String getAp() {
        return ap;
    }

    public void setAp(String ap) {
        this.ap = ap;
    }

    public String getShortTaxNumber() {
        return shortTaxNumber;
    }

    public void setShortTaxNumber(String shortTaxNumber) {
        this.shortTaxNumber = shortTaxNumber;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public int compareTo(Logfile o) {
        int compareage = ((Logfile)o).getLogfileNumber();
        return this.logfileNumber - compareage;
    }

}
