package espol.proyecto;

import espol.model.Carta;
//JavaFX
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.StageStyle;

//Exceptions
import java.io.IOException;


/**
 * JavaFX App
 */
public class App extends Application {
    
    private static Stage stage;
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Steal the Pile");
        scene = new Scene(loadFXML("MenuPrincipal"),600,400);
        stage.setScene(scene);
        //stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.show();
        stage.sizeToScene();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    
    /*metodo que permite cambiar de escenas cambiando
    el tamaño de la ventana y la fija en el centro de la pantalla*/
    
    static void switchScenes(ActionEvent event, String fxml, int SizeX, int SizeY){
        try {
            Parent root = App.loadFXML(fxml);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root, SizeX, SizeY);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e){
            System.out.println("File not found, Error al cargar pantalla");
        }
        
    }
    public static void main(String[] args) {
        launch();
        System.out.println(Carta.loadCartasPoker());
        System.out.println(Carta.loadCartasEspanolas());
        System.out.println(Carta.loadCartasEspanolasV2());
        
    }
}