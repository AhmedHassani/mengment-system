package com.ahd.prodcut.controller;


import com.ahd.Main;
import com.ahd.prodcut.model.Pordcut;
import com.ahd.prodcut.model.Set;
import com.ahd.prodcut.service.PresenterProdect;
import com.ahd.prodcut.service.ProdecutService;
import com.ahd.prodcut.service.Sender;
import com.ahd.util.Validator;
import com.ahd.util.WindowType;
import com.jfoenix.controls.JFXTextField;
import impl.org.controlsfx.skin.AutoCompletePopup;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

@Component
public class InsertProdcut  implements Initializable , Sender {
    @FXML
    private AnchorPane main_layou_program;
    AutoCompletePopup autoComplete=null;
    @Autowired
    ProdecutService service;
    @FXML
    private BorderPane main;
    @FXML
    private Label id_mat;
    @FXML
    private JFXTextField name,price;
    @FXML
    private JFXTextField set;
    @FXML
    private Button but_save;
    public static  PresenterProdect presenterProdect;
    private Pordcut update_pordcut;
    private WindowType windowType;

    @FXML
    void Close(MouseEvent event) {
        Stage window = (Stage) main_layou_program.getScene().getWindow();
        window.close();
    }

    @FXML
    void InsertProdecut(MouseEvent event) {

    }

    @FXML
    void LaodPrices(MouseEvent event) {
        LoadView("all.fxml");
    }

    @FXML
    void LoadAll(MouseEvent event) {
          LoadView("all.fxml");
    }

    @FXML
    void LoadOther(MouseEvent event) {
        LoadView("all.fxml");
    }

    @FXML
    void LoadStor(MouseEvent event) {
        LoadView("all.fxml");
    }

    @FXML
    void LoadUint(MouseEvent event) {
        LoadView("coloes.fxml");
    }

    @FXML
    void Loadsetting(MouseEvent event) {
        LoadView("all.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
             PordcutController.setSender(this);
             autoComplete =new AutoCompletePopup();
             autoComplete.setStyle("-fx-control-inner-background:WHITE;"
                + "-fx-accent: #5fba7d;"
                + "-fx-selection-bar-non-focused:dedede;"
                + "-fx-font:14px 'Arial'");
             LoadView("all.fxml");

    }
    @FXML
    void getSets(KeyEvent event) {
            autoComplete.getSuggestions().clear();
            autoComplete.hide();
            String [] suggestions=service.Search("name",set.getText().toLowerCase());
            autoComplete.getSuggestions().addAll(suggestions);
            autoComplete.setOnSuggestion(new EventHandler<AutoCompletePopup.SuggestionEvent>() {
                @Override
                public void handle(AutoCompletePopup.SuggestionEvent suggestionEvent) {
                    set.setText(suggestionEvent.getSuggestion().toString());
                }
            });
            autoComplete.show(set);
    }

    public static PresenterProdect getPresenterProdect() {
        return presenterProdect;
    }

    public static void setPresenterProdect(PresenterProdect presenterProdect) {
        InsertProdcut.presenterProdect = presenterProdect;
    }

    @Override
    public void dataSend(Pordcut pordcut, WindowType Type) {
       windowType=Type;
       if(!(pordcut==null) || (WindowType.UPDATAE==windowType)){
           name.setText(pordcut.getName());
           price.setText(pordcut.getPrice());
           set.setText(pordcut.getSet());
           update_pordcut=pordcut;
           but_save.setText("تحديث المادة");
       }else {
           System.out.println("new Inseert");
       }
    }

    public void LoadView(String name){
        Parent root=null;
        try {
            FXMLLoader loader = new FXMLLoader();
            URL xmlUrl = getClass().getResource("/fxml/prodcut/"+name);
            loader.setLocation(xmlUrl);
            loader.setControllerFactory(Main.getContext()::getBean);
            main.setCenter(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

