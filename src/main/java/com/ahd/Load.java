package com.ahd;

import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.stereotype.Component;


@Component
public class Load extends Preloader {

    private Parent node;
    private Stage stageloader;


    public Load() {
    }

    @Override
    public void start(Stage stage) throws Exception {
        stageloader=stage;
        stageloader.setScene(new Scene(node));
        stageloader.initStyle(StageStyle.UNDECORATED);
        stageloader.show();
    }

    @Override
    public void init() throws Exception {
        FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("/fxml/main/load.fxml"));
        node=fxmlLoader.load();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    @Override
    public void handleProgressNotification(ProgressNotification info) {

    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification info) {
        switch (info.getType()){
            case BEFORE_START:{
                System.out.println("BEFORE START");
                this.stageloader.hide();
                break;
            }
        }
    }

    @Override
    public void handleApplicationNotification(PreloaderNotification info) {
       System.out.println("Start");
    }

    @Override
    public boolean handleErrorNotification(ErrorNotification info) {
        return super.handleErrorNotification(info);
    }
}
