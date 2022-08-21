package com.ahd.prodcut.service;
import com.ahd.Main;
import com.ahd.prodcut.model.Pordcut;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProdecutService {



    public Pordcut Save( Pordcut pordcut) {
       return new Pordcut();
    }

    public List<Pordcut> getAllProdects(){
        List<Pordcut> pordcutList = new ArrayList<>();
        return pordcutList;
    }




    public void openDialog(String path){
        try {
            FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource(path));
            fxmlLoader.setControllerFactory(Main.getContext()::getBean);
            Stage stage =new Stage();
            stage.setScene(new Scene(fxmlLoader.load()));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] Search(String filed, String q){
        String []name ={};
        return name;
    }


    public void deleteItem(Pordcut pordcut) {
    }

    public Pordcut update(String id, Pordcut pordcut_new) {

        return new Pordcut();
    }

}
