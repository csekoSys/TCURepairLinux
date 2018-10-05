package csekosys;

import csekosys.sum.AdbDevices;
import csekosys.sum.Device;
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
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class RootLayoutController implements Initializable {

    private List<Device> devices;
    private String adbImsi;
    private Button deviceButton;
    private Tab deviceTab;
    private int cableNumber;
    BorderPane devicePane;

    @FXML
    private Button searchDevicesButton;
    @FXML
    private TabPane rootTabPane;
    @FXML
    private VBox devicesVBox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void handleSearchDevices(ActionEvent event) {
        devicesVBox.getChildren().clear();
        devicesVBox.setSpacing(5);
        devices = AdbDevices.getDevices();

        for (int i = 0; i < devices.size(); i++) {
            adbImsi = devices.get(i).getAdbImsi();

            deviceButton = new Button();
            deviceButton.setText(adbImsi);
            deviceButton.setMinWidth(devicesVBox.getPrefWidth());
            deviceButton.setMinHeight(30);

            devicesVBox.getChildren().add(deviceButton);

            //FIGYELMEZTETNI, HA MÁR NINCS CSATLAKOZTATVA AZ ESZKÖZ
            deviceButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        devicePane = FXMLLoader.load(getClass().getResource("ui/device/DevicePane.fxml"));
                    } catch (IOException ex) {
                        Logger.getLogger(RootLayoutController.class.getName()).log(Level.SEVERE, null, ex);
                    }
  //                  devicePane.setMinWidth(rootTabPane.getPrefWidth());
 //                   devicePane.setMinHeight(rootTabPane.getPrefHeight());

                    deviceTab = new Tab(adbImsi);
                    deviceTab.setContent(devicePane);
                    rootTabPane.getTabs().add(deviceTab);
                }
            });

        }
    }

}
