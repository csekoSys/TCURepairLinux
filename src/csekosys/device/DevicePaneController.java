package csekosys.device;

import csekosys.sum.Device;
import csekosys.sum.Logfile;
import csekosys.sum.Receipt;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;

public class DevicePaneController implements Initializable {

    private String adbImsi;
    private final Device device;
    private ArrayList<Integer> logfoldersList;
    private ArrayList<Logfile> logfilesList;
    private ArrayList<Receipt> receiptListFromLogfile;

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
        //               logfilesProcessing();

        logfoldersList = device.getLogfileFoldersList();
        logfilesList = device.getLogfilesList();
        receiptListFromLogfile = device.getReceiptFromLogfile();
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

//        logfilesProcessing();

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
        logFoldersLb.setText(device.getLogfilesFirstLogfolder() + " - " + device.getLogfilesEndLogfolder());
    }

    @FXML
    private void handleLogcatOpen(ActionEvent event) {
        Tab tab = new Tab("logcat");

        deviceTabPane.getTabs().add(tab);
    }

    private void logfilesProcessing() {

        logfileProcessingProgressBar.setProgress(-1);

        Task logfileTask;
        logfileTask = new Task() {
            @Override
            protected Object call() throws Exception {
                //               logfoldersList = device.getLogfileFoldersList();
//                logfilesList = device.getLogfilesList();
                //               receiptListFromLogfile = device.getReceiptFromLogfile();
//                updateProgress(1);
 //               Thread.sleep(100);
                return null;
            }
        };

        logfileProcessingProgressBar.progressProperty().bind(logfileTask.progressProperty());

        new Thread(logfileTask).start();
    }

    @FXML
    private void handleTest(ActionEvent event) {
        System.out.println("csekosys.device.DevicePaneController.handleTest()");

        Tab tab = new Tab("TEST");
        TextArea area = new TextArea();
        area.setMinWidth(deviceTabPane.getPrefWidth());
        area.setMinHeight(deviceTabPane.getPrefHeight());
        area.appendText("Nyugták száma összesen: " + receiptListFromLogfile.size() + "\n");

        for (int i = 0; i < receiptListFromLogfile.size(); i++) {
            area.appendText(receiptListFromLogfile.get(i).getNSZ() + " - " + receiptListFromLogfile.get(i).getSUM() + "\n");
        }

        tab.setContent(area);
        deviceTabPane.getTabs().add(tab);
    }

}
