package com.ahd.util;


import com.ahd.prodcut.model.Pordcut;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class ChBox<T> {
   private  static SelectEevent selectEevent;
   public Callback<TableColumn<T, String>, TableCell<T, String>> update = (e) -> {
        final TableCell<T, String> cell = new TableCell<T, String>() {
            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                    setText(null);
                } else {
                    CheckBox  checkBox= new CheckBox();
                    T t= getTableView().getItems().get(getIndex());
                    checkBox.setOnMouseClicked(e->{
                        selectEevent.onSelectItem(t);
                    });
                    checkBox.getStylesheets().add("/fxml/css/checkbox.css");
                    setText(null);
                    setGraphic(checkBox);
                    setText(null);
                }
            }
        };
        return cell;
    };

    public interface SelectEevent<T>{
        void onSelectItem(T t);
    }

    public static void setSelectEevent(SelectEevent selectEevent) {
        ChBox.selectEevent = selectEevent;
    }
}
