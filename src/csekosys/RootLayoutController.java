package csekosys;

import csekosys.sum.AdbDevices;
import csekosys.sum.Device;
import csekosys.device.DevicePaneController;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class RootLayoutController implements Initializable {

    public List<Device> devices;
    public String adbImsi = "";

    public Tab deviceTab;
    private int cableNumber;
//   public BorderPane devicePane;
    public Button deviceButton;
    public Button[] buttons;

    @FXML
    private Button searchDevicesButton;
    @FXML
    private TabPane rootTabPane;
    @FXML
    public VBox devicesVBox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("csekosys.RootLayoutController.initialize()");
        initLayout();
    }

    @FXML
    public void handleSearchDevices(ActionEvent event) {
        System.out.println("csekosys.RootLayoutController.handleSearchDevices()");
        devicesVBox.getChildren().clear();

        devices = AdbDevices.getDevices(); //eszközök listája
        for (Device d : devices) {
            System.out.println(" Device: " + d.getAdbImsi());
        }
        buttons = new Button[devices.size()];

        for (int i = 0; i < devices.size(); i++) {
            adbImsi = devices.get(i).getAdbImsi();
            deviceButton = new Button(adbImsi);
            buttons[i] = deviceButton;
            devicesVBox.getChildren().add(buttons[i]);
            deviceButton.setMinWidth(devicesVBox.getPrefWidth());
            deviceButton.setMinHeight(30);

        }

        //FIGYELMEZTETNI, HA MÁR NINCS CSATLAKOZTATVA AZ ESZKÖZ
        for (Button button : buttons) {
            button.setOnAction(new EventHandler<ActionEvent>() {

                String imsi = button.getText();

                @Override
                public void handle(ActionEvent event1) {
                    System.out.println("\n.handle() DEVICE BOTTON press: " + imsi);

                    try {
                        DevicePaneController controller = new DevicePaneController(imsi);
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("device/DevicePane.fxml"));
                        loader.setController(controller);
                         BorderPane devicePane = loader.load();

                        deviceTab = new Tab(imsi);
                        deviceTab.setContent(devicePane);
                        rootTabPane.getTabs().add(deviceTab);

                    } catch (IOException ex) {
                        System.out.println("DevicePane.fxml megnyitása nem sikerül: " + ex);
                        Logger.getLogger(RootLayoutController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
            );
        }
    }

    private void initLayout() {
        devicesVBox.setSpacing(5);

    }

}
