// programa para Jugar al AHORCADO Version 2
package ahorcado;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class juegoAhorca2 {

    public static void main(String[] args) {
        
        // PRESENTACION
        // https://masqueprogramar.wordpress.com/2019/03/04/ejemplos-showmessagedialog/
        ImageIcon icono = new ImageIcon("src/imagenes/horca00.jpg");
        JOptionPane.showMessageDialog(null, "jugamos ?...", "AHORCADO v2.0", JOptionPane.INFORMATION_MESSAGE, icono);
        
        // JUGADOR 1 - ingresa una palabra
        // INSTANCIO un Objeto de tipo metodosAhorca2() y Ahorca2()
        metodosAhorca2 ma = new metodosAhorca2();
        Ahorca2 a = ma.crearJuego();
//        System.out.println(a.toString());
//        System.out.println(Arrays.toString(a.getPalabra()));
//        System.out.println(Arrays.toString(a.getAciertos()));
        
        // JUGADOR 2 - trata de adivinar la palabra
        ma.jugar(a);
        
    }
    
}
