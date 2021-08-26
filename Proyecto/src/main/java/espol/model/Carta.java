package espol.model;

import java.util.ArrayList;

public class Carta {
    private String tipo; // española, poker
    private String imgPath; //ubicacion de la img de la carta
    private String denominacion; //trebol, diamante, picas, corazon
    private int valor; //valor de la carta
    
    public Carta(String path, String deno, int valor){
        imgPath = path;
        denominacion = deno;
        this.valor = valor;
    }
    
    public Carta(String deno, int valor){
        denominacion = deno;
        this.valor = valor;
    }
    
    //setters
    public void setValor(int valor){this.valor = valor;}
    public void setImgPath(String imgPath){this.imgPath = imgPath;}
    public void setDenominacion(String denominacion){this.denominacion = denominacion;}
    
    //getter
    public String getImgPath(){return imgPath;}
    public String getDenominacion(){return denominacion;}
    public int getValor(){return valor;}
    
    
    //toString
    @Override
    public String toString(){
        return imgPath+"|"+denominacion+"|"+valor;
    }
    
    
    //metodo que carga las cartas con una denominacion y valor determinado
    public static ArrayList<Carta> loadCartasPoker(){
        ArrayList<Carta> cartasPoker = new ArrayList<>();
        //Carta back = ("src/main/resources/images/Cartas/"++".png") agregar la carta que tiene la parte posterior
        for (int i=1; i<=52; i++){
           
            String path = "src/main/resources/images/Cartas/"+i+".png";
            
            if ( i>=1 && i<=13 ){
                Carta c = new Carta(path, "trebol", i);
                cartasPoker.add(c);
            } else if (i>=14 && i<=26){
                int valor = i - 13;
                Carta c = new Carta(path, "pica", valor);
                cartasPoker.add(c);
            } else if (i>=27 && i<=39){
                int valor = i - 26;
                Carta c = new Carta(path, "corazon", valor);
                cartasPoker.add(c);
            } else if (i>=40 && i<=52){
                int valor = i - 39;
                Carta c = new Carta(path, "diamante", valor);
                cartasPoker.add(c);
            }
        }
        return cartasPoker;
    }
    
    //metodo para cargar las cartas españolas
    public static ArrayList<Carta> loadCartasEspanolas(){
        ArrayList <Carta> cartasEspanolas = new ArrayList<>();
        for (int i = 1; i<=13; i++){
            String path = "src/main/resources/images/Española/"+i+"c.png";
            int valor = i;
            Carta c = new Carta(path, "c", valor);
            cartasEspanolas.add(c);
        }
        for (int i = 1; i<=13; i++){
            String path = "src/main/resources/images/Española/"+i+"d.png";
            int valor = i;
            Carta c = new Carta(path, "d", valor);
            cartasEspanolas.add(c);
        }
        
        for (int i = 1; i<=13; i++){
            String path = "src/main/resources/images/Española/"+i+"e.png";
            int valor = i;
            Carta c = new Carta(path, "d", valor);
            cartasEspanolas.add(c);
        }
        
        for (int i = 1; i<=13; i++){
            String path = "src/main/resources/images/Española/"+i+"t.png";
            int valor = i;
            Carta c = new Carta(path, "t", valor);
            cartasEspanolas.add(c);
        }
        return cartasEspanolas;
    }
    
    //metodo que carga las cartas españolas dos y valor determinado
    public static ArrayList<Carta> loadCartasEspanolasV2(){
        ArrayList<Carta> cartasPoker = new ArrayList<>();
        //Carta back = ("src/main/resources/images/Cartas/"++".png") agregar la carta que tiene la parte posterior
        for (int i=53; i<=100; i++){
            String path = "src/main/resources/images/Españolas/"+i+".png";
            if ( i>=53 && i<=64 ){
                int valor = i - 52;
                Carta c = new Carta(path, "a", valor);
                cartasPoker.add(c);
            } else if (i>=65 && i<=76){
                int valor = i - 64;
                Carta c = new Carta(path, "b", valor);
                cartasPoker.add(c);
            } else if (i>=77 && i<=88){
                int valor = i - 76;
                Carta c = new Carta(path, "c", valor);
                cartasPoker.add(c);
            } else if (i>=89 && i<=100){
                int valor = i - 88;
                Carta c = new Carta(path, "d", valor);
                cartasPoker.add(c);
            }
        }
        return cartasPoker;
    }
    
}
