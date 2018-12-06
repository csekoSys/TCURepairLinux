package csekosys.sum;

public class Closing implements Comparable<Closing> {

    private int ZSZ;
    private int NSF;
    private int NSG;
    private boolean CNC;
    private String DTS;

    public Closing(int ZSZ, int NSF, int NSG, boolean CNC, String DTS) {
        this.ZSZ = ZSZ;
        this.NSF = NSF;
        this.NSG = NSG;
        this.CNC = CNC;
        this.DTS = DTS;
    }

    public int getZSZ() {
        return ZSZ;
    }

    public void setZSZ(int ZSZ) {
        this.ZSZ = ZSZ;
    }

    public int getNSF() {
        return NSF;
    }

    public void setNSF(int NSF) {
        this.NSF = NSF;
    }

    public int getNSG() {
        return NSG;
    }

    public void setNSG(int NSG) {
        this.NSG = NSG;
    }

    public boolean isCNC() {
        return CNC;
    }

    public void setCNC(boolean CNC) {
        this.CNC = CNC;
    }

    public String getDTS() {
        return DTS;
    }

    public void setDTS(String DTS) {
        this.DTS = DTS;
    }

    @Override
    public int compareTo(Closing o) {
        int compareage = ((Closing) o).getZSZ();
        return this.ZSZ - compareage;
    }

}
