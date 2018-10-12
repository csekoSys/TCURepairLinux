package csekosys.sum;

public class Receipt implements Comparable<Receipt> {

    private String NSZ; 
    private int ZSZ;
    private int NYS;
    private int SUM;
    private boolean CNC;
    private String CTS;

    /**
     * 
     * @param NSZ bizonylatszám
     * @param ZSZ
     * @param NYS
     * @param SUM
     * @param CNC
     * @param CTS 
     */
    public Receipt(String NSZ, int ZSZ, int NYS, int SUM, boolean CNC, String CTS) {
        this.NSZ = NSZ;
        this.ZSZ = ZSZ;
        this.NYS = NYS;
        this.SUM = SUM;
        this.CNC = CNC;
        this.CTS = CTS;
    }

    public String getNSZ() {
        return NSZ;
    }

    public void setNSZ(String NSZ) {
        this.NSZ = NSZ;
    }

    public int getZSZ() {
        return ZSZ;
    }

    public void setZSZ(int ZSZ) {
        this.ZSZ = ZSZ;
    }

    public int getNYS() {
        return NYS;
    }

    public void setNYS(int NYS) {
        this.NYS = NYS;
    }

    public int getSUM() {
        return SUM;
    }

    public void setSUM(int SUM) {
        this.SUM = SUM;
    }

    public boolean isCNC() {
        return CNC;
    }

    public void setCNC(boolean CNC) {
        this.CNC = CNC;
    }

    public String getCTS() {
        return CTS;
    }

    public void setCTS(String CTS) {
        this.CTS = CTS;
    }

    @Override
    public int compareTo(Receipt o) {
        int compareage=((Receipt)o).getZSZ();
        return this.ZSZ-compareage;        
    }
    
    
}
