package com.ahd.main.service;



import com.ahd.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;

@Component
public class MainService {

    ConfigurableApplicationContext context;

    public void minimize(Pane pane){
       Stage stage = (Stage) pane.getScene().getWindow();
       stage.setIconified(true);
    }

    public void fullWindow(Pane pane){
        Stage stage = (Stage) pane.getScene().getWindow();
        if(stage.isFullScreen()) {
            stage.setFullScreen(false);
        }else {
            stage.setFullScreen(true);
        }
    }

    public void ColseMainView(Pane pane){
        ButtonType yes = new ButtonType("نعم", ButtonBar.ButtonData.OK_DONE);
        ButtonType no = new ButtonType("رجوع", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.NONE, "هل تريد اغلاق البرنامج ؟",
                yes,
                no);
        alert.initStyle(StageStyle.UNDECORATED);
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setPrefHeight(130);
        dialogPane.getStylesheets().add(
                getClass().getResource("/fxml/css/dialog.css").toExternalForm());
        alert.setTitle("اغلاق البرنامج");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.orElse(no) == yes) {
            Stage window = (Stage) pane.getScene().getWindow();
            System.exit(0);
            window.close();
        }
    }

    public void LoadView(TabPane tabpane, String title, String path, boolean closable) throws IOException {
        Parent root=null;
        try {
            FXMLLoader loader = new FXMLLoader();
            URL xmlUrl = getClass().getResource(path);
            loader.setLocation(xmlUrl);
            loader.setControllerFactory(Main.getContext()::getBean);
            root= loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Tab tab =new Tab(title,root);
        tab.setClosable(closable);
        tabpane.getTabs().add(tab);
    }

    public void ImageBackground (String url,Pane pane) {
        try {
            FileInputStream input = new FileInputStream(url);
            Image image = new Image(input);
            BackgroundImage backgroundimage = new BackgroundImage(image,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT);
            Background background = new Background(backgroundimage);
            pane.setBackground(background);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void openSideList(Pane side,int max) {
        if (side.getPrefWidth()>0){
            side.setPrefWidth(0);
            side.setVisible(false);
        }else {
            side.setPrefWidth(max);
            side.setVisible(true);
        }

    }


}
