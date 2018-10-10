package csekosys.sum;

public class Opening {

    private String DTS;
    private int DNO;
    private boolean CNC;

    public Opening(String DTS, int DNO, boolean CNC) {
        this.DTS = DTS;
        this.DNO = DNO;
        this.CNC = CNC;
    }

    public String getDTS() {
        return DTS;
    }

    public void setDTS(String DTS) {
        this.DTS = DTS;
    }

    public int getDNO() {
        return DNO;
    }

    public void setDNO(int DNO) {
        this.DNO = DNO;
    }

    public boolean isCNC() {
        return CNC;
    }

    public void setCNC(boolean CNC) {
        this.CNC = CNC;
    }

    
}
