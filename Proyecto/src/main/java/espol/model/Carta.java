package espol.model;
public class Carta {
    private String imgPath; //ubicacion de la img de la carta
    private String denominacion; //trebol, diamante, picas, corazon
    private int valor; //valor de la carta 
    
    public Carta(String path, String deno, int valor){
        imgPath = path;
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
}
