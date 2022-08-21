package com.ahd.main.Controller;


import com.ahd.prodcut.service.ProdecutService;
import com.ahd.main.service.MainService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class MainController  implements Initializable {
    @FXML
    private StackPane stackpane;
    @FXML
    private BorderPane view;
    @FXML
    private Label nameuser;
    @Autowired
    MainService mainService;
    @FXML
    private TabPane tabpane;
    @FXML
    private VBox side;
    @Autowired
    ProdecutService service;

    private static StackPane appstack;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setAppstack(stackpane);
        try {
            mainService.LoadView(tabpane, "القائمة الرئيسة",
                      "/fxml/main/Mnue.fxml", false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Exited(MouseEvent event) {
        mainService.ColseMainView(stackpane);
    }

    @FXML
    void minimize(MouseEvent event) {
        mainService.minimize(view);
    }

    @FXML
    void fullScreen(MouseEvent event) {
        mainService.fullWindow(view);
    }

    @FXML
    void sideList(MouseEvent event) {
        mainService.openSideList(side,39);
    }

    @FXML
    void prodcut(MouseEvent event) {
        try {
            mainService.LoadView(tabpane, "prodcut", "/fxml/prodcut/main_prodcut.fxml", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Opend(MouseEvent event) {
        try {
            mainService.LoadView(tabpane, "prodcut", "/fxml/prodcut/InsertProdcut.fxml", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static StackPane getAppstack() {
        return appstack;
    }

    public static void setAppstack(StackPane appstack) {
        MainController.appstack = appstack;
    }
}
