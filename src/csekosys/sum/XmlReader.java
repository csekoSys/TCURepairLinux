package csekosys.sum;

public class XmlReader {

    private String path;
    private String filename;
    private Device device;

    public XmlReader(Device device, String path, String filename) {
        this.device = device;
        this.path = path;
        this.filename = filename;
    }

    /**
     * Megkeresi az adott documentumban az a sort ahol megtalálhat az adott
     * szöveg
     *
     * @param searchText
     * @return
     */
    public String searchXmlAttributum(String searchText) {
        String result = "";

        result = Terminal.execSingle(device.getAdbCommand(" cat " + path + filename + " |grep -i \\\"" + searchText + "\\\""));

        if (result != "") {
            String temp = result.substring(result.length() - 2, result.length());

            if (!temp.equals("/>")) {
                String[] parts1 = result.split("<");
                result = parts1[1];
                String[] parts2 = result.split(">");
                result = parts2[1];
            } else {
                String[] parts3 = result.split("value");
                result = parts3[1];
                result = result.substring(2, result.length() - 4);
            }

            return result;
        } else {
            return result = "Nincs adat";
        }
    }

    /**
     * Megkeresi az adott documentumban az a sort ahol megtalálhat az adott
     * szöveg
     *
     * @param searchText
     * @return
     */
    public String searchXmlField(String searchField) {
        String result = "";

        result = Terminal.execSingle(device.getAdbCommand(" cat " + path + filename + " |grep -i " + searchField));

        if (result != "") {
            String[] parts1 = result.split(">");
            result = parts1[1];
            String[] parts2 = result.split("<");
            result = parts2[0];
            return result;
        } else {
            return result = "Nincs adat";
        }
    }

}
