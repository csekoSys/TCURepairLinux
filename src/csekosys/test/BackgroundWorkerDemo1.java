package csekosys.test;

import csekosys.sum.Closing;
import csekosys.sum.Device;
import csekosys.sum.Logfile;
import csekosys.sum.Receipt;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class BackgroundWorkerDemo1 extends Application {

    private final String adbImsi;
    private final Device device;
    private ArrayList<Integer> logfoldersList;
    private ArrayList<Logfile> logfilesList;
    private ArrayList<Receipt> receiptListFromLogfile;
    private ArrayList<Closing> closingListFromLogfile;

    Button taskButton;

    public BackgroundWorkerDemo1() {
        adbImsi = "232031900448687";
        device = new Device(adbImsi);
    }

    @Override
    public void start(Stage primaryStage) {
        runTask();

        taskButton = new Button("Long Running Task");
        taskButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                runTask();
            }
        });

        VBox mainPane = new VBox();
        mainPane.setPadding(new Insets(10));
        mainPane.setSpacing(5.0d);
        mainPane.getChildren().addAll(taskButton);
        primaryStage.setScene(new Scene(mainPane));
        primaryStage.show();
    }

    private void runTask() {

        final double wndwWidth = 500.0d;
        ProgressIndicator progress = new ProgressIndicator();

        progress.setPrefWidth(wndwWidth);

        VBox updatePane = new VBox();
        updatePane.setPadding(new Insets(10));
        updatePane.setSpacing(5.0d);
        updatePane.getChildren().addAll(progress);

        Stage taskUpdateStage = new Stage(StageStyle.UTILITY);
        taskUpdateStage.setScene(new Scene(updatePane));
        taskUpdateStage.show();

        Task longTask;
        longTask = new Task<Void>() {
            @Override
            protected Void call() throws Exception {

                //               updateProgress();
//                logfoldersList = device.getLogfileFoldersList();
//                updateProgress(10, 100);
//                logfilesList = device.getLogfilesList();
//                updateProgress(20, 100);
                receiptListFromLogfile = device.getReceiptFromLogfile();
//                updateProgress(70, 100);
//               closingListFromLogfile = device.getClosingsFromLogfiles();
//                updateProgress(100, 100);
//                Thread.sleep(1000);
                progress.setProgress(1.0);
                return null;
            }
        };

        progress.progressProperty().bind(longTask.progressProperty());

        taskUpdateStage.show();

        new Thread(longTask).start();
        //       progress.setProgress(1);

    }

    public static void main(String[] args) {
        launch(args);
    }

}
