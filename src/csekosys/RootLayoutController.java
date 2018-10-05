package csekosys;

import csekosys.sum.AdbDevices;
import csekosys.sum.Device;
import csekosys.sum.Status;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class RootLayoutController implements Initializable {

    private Device device;
    private String adbImsi;
    
    @FXML
    private TextArea deviceBacicDatasArea;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        adbImsi = AdbDevices.getDevices().get(0).getAdbImsi();
        device = new Device(adbImsi);


        for (int i = 0; i < Status.getDeviceBasicDatas().size(); i++) {
            deviceBacicDatasArea.appendText(Status.getDeviceBasicDatas().get(i) + "\n");

        }

    }

}
