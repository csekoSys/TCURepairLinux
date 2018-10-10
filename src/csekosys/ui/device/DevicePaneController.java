package csekosys.ui.device;

import csekosys.RootLayoutController;
import csekosys.sum.Device;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class DevicePaneController implements Initializable {

    RootLayoutController rlc = new RootLayoutController();
    private String adbImsi;
    private Device device;

    @FXML
    private Label typeLb;
    @FXML
    private Label imsiLb;
    @FXML
    private Label apLb;
    @FXML
    private Label versionLb;
    @FXML
    private Label tcuStatusLb;
    @FXML
    private Label connectLb;
    @FXML
    private Label openedLb;
    @FXML
    private TabPane deviceTabPane;

    public DevicePaneController(String imsi) {
        adbImsi = imsi;
        System.out.println("csekosys.ui.device.DevicePaneController.<init>() IMSI: " + adbImsi);
        device = new Device(adbImsi);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("csekosys.ui.device.DevicePaneController.initialize(): IMSI: " + adbImsi);
        showDeviceBasicDatas();
    }

    private void showDeviceBasicDatas() {
        System.out.println("csekosys.ui.device.DevicePaneController.showDeviceBasicDatas()");

        typeLb.setText(device.getTypeType());
        imsiLb.setText(device.getRepoImsi());
        apLb.setText(device.getRepoAp());
        versionLb.setText(device.getVersionVersion());
        tcuStatusLb.setText(device.getRepoTcuStatus());
        connectLb.setText("még megcsinálni");
        openedLb.setText("" + device.isRepoOpened());
    }

    @FXML
    private void handleLogcatOpen(ActionEvent event) {
        Tab tab = new Tab("logcat");
        deviceTabPane.getTabs().add(tab);
    }


}
