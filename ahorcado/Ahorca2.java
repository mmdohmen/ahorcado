// Clase con las Condiciones Iniciales del Juego AHORCADO
package ahorcado;

// LIBRERIAS
import javax.swing.ImageIcon;


public class Ahorca2 {
    
    // ATRIBUTOS
    private String[] palabra;    // palabra a adivinar
    private String[] aciertos;   // letras adivinadas
    private int errores = 0;     // intentos fallidos (letras q no pertenecen a la palabra a adivinar
    private ImageIcon icono = new ImageIcon("src/imagenes/horca00.jpg");;
    
    // CONSTRUCTORES
    public Ahorca2() {}
    public Ahorca2(String[] palabra, String[] aciertos, int errores, ImageIcon icono) {
        this.palabra = palabra;
        this.aciertos = aciertos;
        this.errores = errores;
        this.icono = icono;
    }
    
    // GETTER & SETTER
    public String[] getPalabra() {
        return palabra;
    }
    public void setPalabra(String[] palabra) {
        this.palabra = palabra;
    }

    public String[] getAciertos() {
        return aciertos;
    }
    public void setAciertos(String[] aciertos) {
        this.aciertos = aciertos;
    }

    public int getErrores() {
        return errores;
    }
    public void setErrores(int errores) {
        this.errores = errores;
    }

    public ImageIcon getIcono() {
        return icono;
    }
    public void setIcono(ImageIcon icono) {
        this.icono = icono;
    }
    
    // METODO para MOSTRAR los ATRIBUTOS de un OBJETO
    @Override
    public String toString() {
        return "Ahorca2{" + "palabra=" + palabra + ", aciertos=" + aciertos + ", errores=" + errores + ", icono=" + icono + '}';
    }
    
    
}
