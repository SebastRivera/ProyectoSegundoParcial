/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.proyecto;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

/**
 *
 * @author Administrador
 */
public class MesaJuegoController {@FXML
    Text textNumeros;
    
    @FXML
    private void initialize() {
        //inicializa hilo que muestra el contador
        Thread hiloCuenta = new Thread(new IncrementaCuenta());
        hiloCuenta.setDaemon(true);
        hiloCuenta.start();
    }
    
    
    //
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
