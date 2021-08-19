package espol.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PartidaJugada {
        String fecha;
        String nombre;
        int puntos;
        int puntosOponente;
        int diffPuntos;
        int tiempo;
        int pilasRobadas;
        
        /*
        //constructor que sirve para ingresar Jugadores como parametros
        public PartidaJugada (String nombre, Jugador persona, Jugador computadora, int tiempo){
            this.nombre = persona.getNombre();
            this.puntos = persona.getPuntos();
            this.puntosOponente = computadora.getPuntos();
            
            //revisar por quien se toma la referencia para el puntaje
            //o si es que hay que convertirlo en valor absoluto
            this.diffPuntos = persona.getPuntos() - computadora.getPuntos();
            
            //preguntar si el tiempo va a ir como entero
            this.tiempo = tiempo;
            
            //de quien son las pilas robadas o si es en total
            this.pilasRobadas = persona.getCantidadPilas() + computadora.getCantidadPilas();
        }
        */
        
        //segundo constructor para facilitar la lectura del archivo y no estar creando objetos aparte
        public PartidaJugada (String fecha, String nombre, int puntos, int puntosOponente,int diffPuntos, int tiempo, int pilasRobadas){
            this.fecha = fecha;
            this.nombre = nombre;
            this.puntos = puntos;
            this.puntosOponente = puntosOponente;
            this.diffPuntos = diffPuntos;
            this.tiempo = tiempo;
            this.pilasRobadas = pilasRobadas;
        }
        
        //hay que setear la fecha y tratar de no meter tantos parametros dentro del constructor
        public void setFecha(String fecha){this.fecha = fecha;}
        
        //getters para el tableview
        public String getFecha(){return fecha;}
        public String getNombre(){return nombre;}
        public int getPuntos(){return puntos;}
        public int getPuntosOponente(){return puntosOponente;}
        public int getDiffPuntos(){return diffPuntos;}
        public int getTiempo(){return tiempo;}
        public int getPilasRobadas(){return pilasRobadas;}
        
        
        
        //lectura del archivo
        public static ArrayList<PartidaJugada> cargarPartidas(String path) {
            ArrayList<PartidaJugada> partidas = new ArrayList<>();
            try (BufferedReader file = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = file.readLine()) != null) {
                String[] data = line.split(",");
                
                //se utiliza el segundo constructor para mas conveniencia
                PartidaJugada partida = new PartidaJugada
                        (data[0], data[1], Integer.parseInt(data[2]),
                        Integer.parseInt(data[3]), Integer.parseInt(data[4]), 
                        Integer.parseInt(data[5]), Integer.parseInt(data[6]));
                
                partidas.add(partida);

            }
        } catch (IOException ioe) {
            System.out.println("File not found");
        }
            return partidas;
    }
        
        
        
}
