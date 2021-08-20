package espol.proyecto;

import espol.model.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import java.util.ArrayList;
import javafx.scene.control.TableColumn;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.util.Arrays;

public class ReportesPartidasController {
    @FXML
    private TableView TvReportes;
    
    @FXML
    private TableColumn<PartidaJugada, String> colFecha;

    @FXML
    private TableColumn<PartidaJugada, String> colNombre;

    @FXML
    private TableColumn<PartidaJugada, String> colPuntos;

    @FXML
    private TableColumn<PartidaJugada, String> colPuntosOponentes;

    @FXML
    private TableColumn<PartidaJugada, String> colDiffPuntos;

    @FXML
    private TableColumn<PartidaJugada, String> colTiempo;

    @FXML
    private TableColumn<PartidaJugada, String> colPilas;
    
    @FXML
    private ComboBox<String> cmbFilter;

    @FXML
    void switchToMenu(ActionEvent event) throws IOException{
        App.switchScenes(event, "MenuPrincipal", 600, 400);
    }

    @FXML
    private void initialize(){
        /*
        ArrayList<String> opciones = new ArrayList<>(Arrays.asList("FECHA","PUNTAJE","NOMBRE"));
        cmbFilter.setItems(FXCollections.observableArrayList(opciones));
        cmbFilter.setValue(opciones.get(0));     
        System.out.println("Combobox inicializado");
        */
       
        
        //agregar los datos en las columnas
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPuntos.setCellValueFactory(new PropertyValueFactory<>("puntos"));
        colPuntosOponentes.setCellValueFactory(new PropertyValueFactory<>("puntosOponente"));
        colDiffPuntos.setCellValueFactory(new PropertyValueFactory<>("diffPuntos"));
        colTiempo.setCellValueFactory(new PropertyValueFactory<>("tiempo"));
        colPilas.setCellValueFactory(new PropertyValueFactory<>("pilasRobadas"));
        
        TvReportes.getItems().setAll(PartidaJugada.cargarPartidas("src/main/resources/files/reportes.txt"));
    }
    
}