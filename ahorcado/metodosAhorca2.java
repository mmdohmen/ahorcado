// METODOS de la Clase Ahorca2()
package ahorcado;

// LIBRERIAS
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;



public class metodosAhorca2 {

    // ATRIBUTOS
    String abecedario[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    ArrayList<String> letrasIngresadas = new ArrayList();

    // METODOS
    public Ahorca2 crearJuego() {
        Ahorca2 a = new Ahorca2();
        String p;   // palabra ingresada por el Jugador 1
        do {        // bucle para Evitar ERRORES
            p = JOptionPane.showInputDialog("JUGADOR 1 \ningrese una PALABRA: ").toLowerCase();
            if (p.length() <= 1) {
                p = "";
            }
        } while (p.equalsIgnoreCase(""));
        // convierto el string en vectores
        String palabra[] = new String[p.length()];
        String aciertos[] = new String[p.length()];
        for (int i = 0; i < p.length(); i++) {
            palabra[i] = p.substring(i, i + 1);
            aciertos[i] = "_";
        }
        // seteo la palabra ingresada
        a.setPalabra(palabra);
        a.setAciertos(aciertos);
        return a;
    }

    
    public void jugar(Ahorca2 a) {
        JOptionPane.showMessageDialog(null, "JUGADOR 2 \ntenes que adivinar una palabra de "
                + a.getPalabra().length + " letras \n" + Arrays.toString(a.getAciertos()));
        JOptionPane.showMessageDialog(null, "EMPEZAMOS a jugar ?...");
        do {
            // INGRESAR una LETRA
            //String letra = ingresarLetra();
            String letra = "";
            do {
                // https://masqueprogramar.wordpress.com/2019/03/06/ejemplos-showinputdialog/
//                letra = JOptionPane.showInputDialog("JUGADOR 2 \ningrese una LETRA: \npalabra: " + 
//                                                     Arrays.toString(a.getAciertos()) +
//                                                    "\nletras ingresadas: " + 
//                                                    Arrays.toString(letrasIngresadas.toArray()));
                letra = JOptionPane.showInputDialog(null, "JUGADOR 2 \ningrese una LETRA: \npalabra: " + 
                                                     Arrays.toString(a.getAciertos()) +
                                                    "\nletras ingresadas: " + 
                                                    Arrays.toString(letrasIngresadas.toArray()),
                                                    "ERRORES disponibles: " + (6 - a.getErrores()),
                                                    JOptionPane.INFORMATION_MESSAGE).toLowerCase();
                if (letra.equals("")) {
                    JOptionPane.showMessageDialog(null, "NO has ingresado nada ...");
                } else {
                    letra = validarLetra(letra);
                }   
            } while (letra.equals(""));

            // VERIFICO si la LETRA ingresada ESTA en la PALABRA
            Boolean esta = false;                  // variable que indica si la letra ingresada esta en la palabra
            String[] aciertos = a.getAciertos();   // vector auxiliar (letras acertadas)
            for (int i = 0; i < a.getPalabra().length; i++) {
                if (letra.equalsIgnoreCase(a.getPalabra()[i])) {
                    esta = true;
                    aciertos[i] = letra;
                }
            }
            System.out.println(Arrays.toString(aciertos));
            //a.setAciertos(aciertos);   // seteo el nuevo vector con la letra acertada
            // opciones segun la letra ingresada este o no este en la palabra a adivinar
            if (esta == true) {
                a.setAciertos(aciertos);   // seteo el nuevo vector con la letra acertada
                // comparo VECTORES palabra[] y aciertos[]
                if (Arrays.equals(a.getPalabra(), a.getAciertos())) {             // comparo los vectores 
                    Toolkit.getDefaultToolkit().beep();                           // sonido
                    ImageIcon icono = new ImageIcon("src/imagenes/winner.jpg");   // icono ganador
                    JOptionPane.showMessageDialog(null, Arrays.toString(a.getAciertos()), ":D   ACERTASTE !!!...",
                            JOptionPane.INFORMATION_MESSAGE, icono);
                    System.exit(0);                                               // FIN del juego
                }
                // muestro la ubicacion de la letra ingresada y acertada
                JOptionPane.showMessageDialog(null, "GOOOOOD !!!... \n" + Arrays.toString(a.getAciertos()),
                        "ERRORES disponibles: " + (6 - a.getErrores()),
                        JOptionPane.INFORMATION_MESSAGE, a.getIcono());
            } else {
                a.setErrores(a.getErrores() + 1);   // aumento el numero de errores cometidos
                // VERIFICO la cantidad de ERRORES
                if (a.getErrores() == 6) {
                    Toolkit.getDefaultToolkit().beep();                           // sonido
                    ImageIcon icono = new ImageIcon("src/imagenes/horca06.jpg");
                    JOptionPane.showMessageDialog(null, Arrays.toString(a.getAciertos()) + "\n "
                            + Arrays.toString(a.getPalabra()),
                            ":(   PERDISTE !!!...",
                            JOptionPane.INFORMATION_MESSAGE, icono);
                    System.exit(0);                                               // FIN del juego
                }
                // muestro que la letra NO se encuentra en la palabra
                String url = "src/imagenes/horca0" + a.getErrores() + ".jpg";
                ImageIcon icono = new ImageIcon(url);
                a.setIcono(icono);
                JOptionPane.showMessageDialog(null, letra + ": NO esta en la palabra \n"
                        + Arrays.toString(a.getAciertos()),
                        "ERRORES disponibles: " + (6 - a.getErrores()),
                        JOptionPane.INFORMATION_MESSAGE, icono);
            }
        } while (a.getErrores() < 6);
    }

      
    public String validarLetra(String l) {
        boolean esLetra = false;
        for (int i = 0; i < abecedario.length; i++) {
            if (l.equalsIgnoreCase(abecedario[i])) {
                esLetra = true;
                break;
            }
        }
        if (esLetra == false) {
            l = "";
        } else {
            letrasIngresadas.add(l);
        }
        return l;
    }

}
