package espol.proyecto;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

/**
 *
 * @author Administrador
 */
public class MesaJuegoController {
    
    @FXML
    private Text textNumeros;
    
    
    
    @FXML
    private void initialize() {
        //inicializa hilo que muestra el contador
        
        Thread hiloCuenta = new Thread(new IncrementaCuenta());
        hiloCuenta.setDaemon(true);
        hiloCuenta.start();
      
    } 
   
    
    @FXML
    void switchToMenu(ActionEvent event) throws IOException{
        App.switchScenes(event, "MenuPrincipal", 600, 400);
    }
    
    
    class IncrementaCuenta implements Runnable {

        private int count = 0;

        private void incrementCount() {
            count++;
            textNumeros.setText(Integer.toString(count));
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }

                incrementCount();
            }
        }

    }


}
