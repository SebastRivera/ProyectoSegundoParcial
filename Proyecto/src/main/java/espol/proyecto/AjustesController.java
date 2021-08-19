/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.proyecto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import java.util.ArrayList;

import java.io.IOException;
import java.util.Arrays;
import javafx.collections.FXCollections;

/**
 *
 * @author Administrador
 */
public class AjustesController {
    @FXML
    private ComboBox<String> ComboAj;
    
    @FXML
    void switchToMenu2(ActionEvent event) throws IOException{
        App.switchScenes(event, "MenuPrincipal", 600, 400);
    }
    
    
    
    @FXML
    private void initialize(){
        ArrayList<String> opciones = new ArrayList<>(Arrays.asList("CARTAS ESPAÑOLAS","CARTAS PÓKER"));
        ComboAj.setItems(FXCollections.observableArrayList(opciones));
        ComboAj.setValue(opciones.get(1));     
        System.out.println("Combobox inicializado");
    }

    
}
