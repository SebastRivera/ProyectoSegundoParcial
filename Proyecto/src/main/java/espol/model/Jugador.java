package espol.model;
import java.util.ArrayList;
public class Jugador {
    String nombre;
    ArrayList<Carta> cartasJugador;
    int puntos;
    int pilasRobadas;
    
    
    //constructor Jugador Real
    public Jugador(String nombre,ArrayList<Carta> cartasJugador,int puntos,  
                   int pilasRobadas){
        this.nombre = nombre;
        this.cartasJugador = cartasJugador;
        this.puntos = puntos;
        this.pilasRobadas = pilasRobadas;
    }
    
    //constructor de Jugador Computadora
    public Jugador(ArrayList<Carta> cartasJugador, int puntos, int pilasRobadas){
        this.nombre = "Computadora";
        this.cartasJugador = cartasJugador;
        this.puntos = puntos;
        this.pilasRobadas = pilasRobadas;
    }
    
            
    //coloca la carta a la mesa
    public void colocarCarta(Carta c){}
    //roba la carta y lo coloca en la pila del jugador
    public void robarCarta(Carta c){}
    //roba la pila del contricante y las añade a la pila del jugador que roba
    public void robarPila(ArrayList<Carta> pila){}
    
    
    //getters
    public String getNombre(){return nombre;}
    public int getPuntos(){return puntos;}
    public int getCantidadPilas(){return pilasRobadas;}
    
    
}
