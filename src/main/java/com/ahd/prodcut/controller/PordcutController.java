package com.ahd.prodcut.controller;


import com.ahd.prodcut.model.Citys;
import com.ahd.prodcut.model.Pordcut;
import com.ahd.prodcut.model.Set;
import com.ahd.prodcut.service.PresenterProdect;
import com.ahd.prodcut.service.ProdecutService;
import com.ahd.prodcut.service.Rest;
import com.ahd.prodcut.service.Sender;
import com.ahd.util.Alerts;
import com.ahd.util.ChBox;

import com.ahd.util.WindowType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class PordcutController implements Initializable, PresenterProdect {
    @FXML
    private HBox delete_icon_set,edit_icon1_set,delete_icon,edit_icon;
    @FXML
    private TableView<Set> table_set;
    @FXML
    private TableColumn select_type_set;
    @FXML
    private TableColumn<Set, String> name_set,id_set;
    @FXML
    private TableView<Pordcut> tableProdect;
    @FXML
    private TableColumn select_type_mat;
    @FXML
    private TableColumn<Pordcut,String>   setProdect,priceProdect,nameProdect,idPordect;
    @FXML
    private ComboBox<?> choser_set1;
    @FXML
    private ListView<?> listOther;
    @Autowired
    ProdecutService service;
    private ArrayList<Pordcut> listSelect;
    public static Sender sender;
    @Autowired
    Rest<List<Citys>> rest;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.TableProdect();
        TableProdectSet();
        listSelect=new ArrayList<Pordcut>();
        List<Citys> data = rest.fetch("https://app0989.herokuapp.com/api/v1/citys");
        System.out.println(data.size());
    }
    @FXML
    void AddMaterial(MouseEvent event) {
      service.openDialog("/fxml/prodcut/InsertProdcut.fxml");
      sender.dataSend(null, WindowType.INSERT);
    }
    @FXML
    void CreateSet(MouseEvent event){
    }
    @FXML
    void DeleteItemsSelect(MouseEvent event) {
        int size =listSelect.size();
        if (size==0){
            Alerts.success("note","Select Element We Need Delete it !");
        }else {
            for (Pordcut pordcut : listSelect)
                service.deleteItem(pordcut);
            listSelect.clear();
            TableProdect();
            Alerts.success("تم الحذف "," عنصر من القائمة"+size+" تم حذف ");
        }
    }
    @FXML
    void DeleteSetSelected(MouseEvent event) {
    }

    @FXML
    void UpdateProdecut(MouseEvent event) {
        if (listSelect.size()==0){
            Alerts.success("not Select item","not Select item palce Slecet item !");
        }else if (listSelect.size()>1){
            Alerts.success("Select muilte item"," palce Select one item !");
        }else{
            service.openDialog("/fxml/prodcut/InsertProdcut.fxml");
            Pordcut pordcut=listSelect.get(0);
            sender.dataSend(pordcut, WindowType.UPDATAE);
        }
    }

    @FXML
    void UpdateSet(MouseEvent event) {

    }

    public void TableProdect(){
        tableProdect.getItems().clear();
        nameProdect.setCellValueFactory(new PropertyValueFactory<>("name"));
        idPordect.setCellValueFactory(new PropertyValueFactory<>("id"));
        priceProdect.setCellValueFactory(new PropertyValueFactory<>("price"));
        setProdect.setCellValueFactory(new PropertyValueFactory<>("set"));
        ChBox<Pordcut> chBox =new ChBox<Pordcut>();
        select_type_mat.setCellFactory(chBox.update);
        chBox.setSelectEevent(new ChBox.SelectEevent() {
            @Override
            public void onSelectItem(Object object) {
                Pordcut pordcut =(Pordcut) object;
                if (listSelect.contains(pordcut)) {
                    listSelect.remove(pordcut);
                } else {
                    listSelect.add(pordcut);
                }
            }
        });
        ObservableList data = FXCollections.observableList(service.getAllProdects());
        tableProdect.setItems(data);
    }


    public void TableProdectSet(){
        table_set.getItems().clear();
        this.name_set.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.id_set.setCellValueFactory(new PropertyValueFactory<>("id"));
        ChBox<Pordcut> chBox =new ChBox<Pordcut>();
        select_type_set.setCellFactory(chBox.update);
        //ObservableList data = FXCollections.observableList(service.getAllProdectsSet());
        //this.table_set.setItems(data);
    }

    @Override
    public void OnInsertProdect(Pordcut pordcut) {
        TableProdect();
    }

    public static Sender getSender() {
        return sender;
    }

    public static void setSender(Sender sender) {
        PordcutController.sender = sender;
    }
}
