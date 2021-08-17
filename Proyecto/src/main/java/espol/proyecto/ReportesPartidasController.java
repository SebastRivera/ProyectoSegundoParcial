package espol.proyecto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import java.util.ArrayList;

import java.io.IOException;
import java.util.Arrays;
import javafx.collections.FXCollections;

public class ReportesPartidasController {
    @FXML
    private ComboBox<String> cmbFilter;

    @FXML
    void switchToMenu(ActionEvent event) throws IOException{
        App.switchScenes(event, "MenuPrincipal", 600, 400);
    }

    @FXML
    private void initialize(){
        ArrayList<String> opciones = new ArrayList<>(Arrays.asList("FECHA","PUNTAJE","NOMBRE"));
        cmbFilter.setItems(FXCollections.observableArrayList(opciones));
        cmbFilter.setValue(opciones.get(0));     
        System.out.println("Combobox inicializado");
    }

}