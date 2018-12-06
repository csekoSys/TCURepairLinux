package csekosys.device;

import csekosys.sum.Backup;
import csekosys.sum.Closing;
import csekosys.sum.Device;
import csekosys.sum.Logfile;
import csekosys.sum.Receipt;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;

public class DevicePaneController implements Initializable {

    private String adbImsi;
    private final Device device;
    private ArrayList<Integer> logfoldersList;
    private ArrayList<Logfile> logfilesList;
    private ArrayList<Receipt> receiptListFromLogfile;
    private ArrayList<Closing> closingListFromLogfile;

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
    private Label logFoldersLb;
    @FXML
    private TabPane deviceTabPane;
    @FXML
    private ProgressBar logfileProcessingProgressBar;

    public DevicePaneController(String imsi) {
        adbImsi = imsi;
        System.out.println("csekosys.ui.device.DevicePaneController.<init>() IMSI: " + adbImsi);
        device = new Device(adbImsi);
 //       logfoldersList = device.getLogfileFoldersList();
 //       logfilesList = device.getLogfilesList();
 //       receiptListFromLogfile = device.getReceiptFromLogfile();
//        closingListFromLogfile = device.getClosingsFromLogfiles();
    }

    public String getAdbImsi() {
        return adbImsi;
    }

    public void setAdbImsi(String imsi) {
        this.adbImsi = imsi;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("csekosys.ui.device.DevicePaneController.initialize(): IMSI: " + adbImsi);

        showDeviceBasicDatas();

 //       logfilesProcessing();
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
        //        logFoldersLb.setText(device.getLogfilesFirstLogfolder() + " - " + device.getLogfilesEndLogfolder());
        Backup.sdBackup(device);
    }

    @FXML
    private void handleLogcatOpen(ActionEvent event) {
        Tab tab = new Tab("logcat");

        deviceTabPane.getTabs().add(tab);
    }


    @FXML
    private void handleTest(ActionEvent event) {
        System.out.println("csekosys.device.DevicePaneController.handleTest()");

        Tab tab = new Tab("TEST");
        TextArea area = new TextArea();
        area.setMinWidth(deviceTabPane.getPrefWidth());
        area.setMinHeight(deviceTabPane.getPrefHeight());

        tab.setContent(area);
        deviceTabPane.getTabs().add(tab);
    }

}
