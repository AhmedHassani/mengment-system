package com.ahd;

import javafx.application.Application;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class Main extends Application {
    static ConfigurableApplicationContext context;
    private Parent node;
    @Autowired

    public static void main(String[] args) {
        System.setProperty("javafx.preloader", Load.class.getCanonicalName());
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
         FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("/fxml/main/main.fxml"));
         fxmlLoader.setControllerFactory(context::getBean);
         stage.setScene(new Scene(fxmlLoader.load(),1000,700));
         stage.initStyle(StageStyle.UNDECORATED);
         Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
         stage.setX(primaryScreenBounds.getMinX());
         stage.setY(primaryScreenBounds.getMinY());
         stage.setWidth(primaryScreenBounds.getWidth());
         stage.setHeight(primaryScreenBounds.getHeight());
         stage.show();
    }

    @Override
    public void init() throws Exception {
        context= SpringApplication.run(Main.class);
        notifyPreloader(new Preloader.ProgressNotification(100));
    }

    public static ConfigurableApplicationContext getContext() {
        return context;
    }

    @Override
    public void stop() throws Exception {
        context.close();
    }

}
