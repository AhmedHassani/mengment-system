package com.ahd.util;

import com.jfoenix.controls.JFXTextField;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;


public class Validator {
    private Validator emailValidator;
    private JFXTextField textField;

    public boolean emailVild(JFXTextField textField1){
        return true;
    }

    private void doEmailValidate(){
        emailValidator = new Validator();
        textField.focusedProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                    boolean val = textField.validate();
            }
        });
    }

}
