package espol.proyecto;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;

import espol.model.Carta;
import javafx.geometry.Pos;

/**
 *
 * @author Administrador
 */
public class MesaJuegoController {
    
    //cartas del juego 
    private final ArrayList<Carta> arrayCartasJuegos = Carta.loadCartasPoker(); // en este caso se añaden las cartas de poker
    
    @FXML
    private Text textNumeros;
    
    //cartas que pertenecen a la computadora    
    private ArrayList<Carta> arrayCartasComputador; //arrayList
    
    @FXML
    private VBox pilaComputador;

    @FXML
    private HBox cartasComputadoras;
    
    
    //cartas que se encuentran en la mesa

    private ArrayList<Carta> arrayCartasMesa; //arrayList

    @FXML
    private HBox CartasMesa;

    
    
    //cartas que tiene la persona
    private ArrayList<Carta> arrayCartasJugador;
    
    @FXML
    private VBox pilaJugador;
    
    //crear un arrayPilaJugador

    @FXML
    private HBox cartasJugador;
    
    
    
    @FXML
    private void initialize() {
        //inicializa hilo que muestra el contador
        
        Thread hiloCuenta = new Thread(new IncrementaCuenta());
        hiloCuenta.setDaemon(true);
        hiloCuenta.start();
        
        //inicio de las variables
        
        arrayCartasComputador = new ArrayList<>();
        arrayCartasMesa = new ArrayList<>();
        arrayCartasJugador = new ArrayList<>();
        
        
        repartirCartas();
      
    } 
   
    
    @FXML
    void switchToMenu(ActionEvent event) throws IOException{
        App.switchScenes(event, "MenuPrincipal", 600, 400);
    }
    
    
    //metodo que agrega las cartas dentro del juego
    public void repartirCartas(){
        System.out.println(arrayCartasJuegos);
        //repartir las cartas a la computadora
        for (int i = 0; i<3; i++){
            //se crea un VBox para cada imagen
            VBox vbox = new VBox();
            //siempre se agrega el 0 porque se va eliminando el primer elemento de la lista
            //entonces el indice 0 siempre va a ser diferente
            Carta c = arrayCartasJuegos.get(0);
            arrayCartasComputador.add(c); // se agrega las cartas al computador
            
            
            //se crea la imagen de la carta
            try(FileInputStream input = new FileInputStream(c.getImgPath())){
                
                Image image = new Image(input,110 ,150, false, false);
                ImageView imV = new ImageView(image);
                
                
                
                vbox.getChildren().add(imV);
                vbox.setAlignment(Pos.CENTER);
                //System.out.println(c.toString());
                arrayCartasJuegos.remove(c);
            } catch (Exception e){
                System.out.println("File Not Found");
                
            }

            cartasComputadoras.getChildren().add(vbox);
        }
        
        //System.out.println(arrayCartasJuegos);
        
        
        //repartir las cartas a la mesa
        for (int i = 0; i<4; i++){
            //se crea un VBox para cada imagen
            VBox vbox = new VBox();
            Carta c = arrayCartasJuegos.get(0);
            arrayCartasMesa.add(c); // se agrega las cartas a la mesa
            //se crea la imagen de la carta
            try(FileInputStream input = new FileInputStream(c.getImgPath())){
                
                Image image = new Image(input,110 ,150, false, false);
                ImageView imV = new ImageView(image);
                vbox.getChildren().add(imV);
                vbox.setAlignment(Pos.CENTER);
                System.out.println(c.toString());
                arrayCartasJuegos.remove(c);
                
            } catch (Exception e){
                System.out.println("File Not Found");
                
            }
            CartasMesa.getChildren().add(vbox);
        }
        
        
        //repartir las cartas al jugador
        for (int i = 0; i<3; i++){
            //se crea un VBox para cada imagen
            VBox vbox = new VBox();
            
            Carta c = arrayCartasJuegos.get(0);
            arrayCartasJugador.add(c); // se agrega al mazo del jugador
            
            try(FileInputStream input = new FileInputStream(c.getImgPath())){
                
                
                
                //se crea la imagen de la carta
                Image image = new Image(input,110 ,150, false, false);
                ImageView imV = new ImageView(image);
                //evento al hacer clic una imagen que revisa si hay una carta en la mesa para robar
                imV.setOnMouseClicked(e -> {
                    System.out.println(c.toString());
                    
                    
                    //con este metodo se comprueba si es que existe una carta en la mesa que se pueda robar
                    if (comprobarMesa(c)){
                        System.out.println("Existe una carta igual");
                        //implementar un metodo que robe la carta
                        //1. que la quite del array del jugador
                        //2. que la quite del array de la mesa
                        //3. ponga la carta en la pila
                    } else {
                        System.out.println("No existe una carta igual en la mesa");
                        //implementar metodo que ponga la carta sobre la mesa debido a que no hay una igual
                    }
                    
                });
                
                
                //se agrega dentro del vBox
                vbox.getChildren().add(imV);
                vbox.setAlignment(Pos.CENTER);
                
                
                //se tiene que eliminar la carta debido a que no deben ser repetidas
                arrayCartasJuegos.remove(c);
                
            } catch (Exception e){
                
                e.printStackTrace();
                System.out.println("File Not Found jugador");
                
            }
            cartasJugador.getChildren().add(vbox);
            
        }
        
        
    
        
        
    }
    
    public boolean comprobarMesa(Carta c){
        for (Carta cMesa: arrayCartasMesa){
            if (cMesa.getValor() == c.getValor()){
                return true;
            }
        }
        return false;
    }
    
    //tomar carta de la mesa
    
    
    
    //metodo actualizar permite que todas las cartas que se encuentren en la partida se actualicen
    
    
    //robar pilas
    
    
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
