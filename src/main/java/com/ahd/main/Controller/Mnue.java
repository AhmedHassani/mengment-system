package com.ahd.main.Controller;

import com.ahd.main.service.MainService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class Mnue implements Initializable {

    @FXML
    private VBox vbox;
    @Autowired
    MainService mainService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FileInputStream input = null;
        try {
            input = new FileInputStream("/Users/ahd/Desktop/Sales Mengment/src/main/resources/icon/bg.jpg");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image = new Image(input);
        BackgroundImage backgroundimage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);

        Background background = new Background(backgroundimage);

        vbox.setBackground(background);

    }
}
