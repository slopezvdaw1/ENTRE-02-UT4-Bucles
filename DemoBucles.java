import java.util.Random;
/**
 *    @author - Sara López Vicente
 */
public class DemoBucles
{
    private final char ASTERISCO = '*';
    private final char ESPACIO = ' ';
    private Random generador;
    
    /**
     * Constructor  
     */
    public DemoBucles()
    {
       generador = new Random();
    }

    /**
     * Calcular la mayor potencia de 2 que es menor o igual a numero
     * Asumimos numero > 0
     * 
     * Si numero = 7 devuelve 4             numero = 8 devuelve 8
     *    numero = 19 devuelve 16           numero = 32 devuelve 32
     *    numero = 74 devuelve 64           numero = 1 devuelve 1
     *    numero = 190 devuelve 128
     *    
     *  Usa bucles while
     */
    public int mayorPotencia2(int numero) {
        int potencia = 1;
        while (potencia * 2 <= numero) {
            potencia *= 2;            
        }
        return potencia;
    }

    /**
     * Escribir numero como suma de potencias de 2 
     * tal como indica el enunciado (Se asume numero > 0)
     * 
     * Todos los valores se muestran en pantalla fomateados a 6 posiciones 
     * y ajustados a la derecha
     * 
     * Hay que usar el método anterior - 
     * Utiliza bucles while
     * 
     *  77 =    64     8     4     1
     * 215 =   128    64    16     4     2     1
     *  18 =    16     2
     *  64 =    64
     */
    public void escribirSumaPotencias(int numero) {
        int n = mayorPotencia2(numero);
        System.out.printf("%6d =", numero);
        int acumulador = 0;
        while (numero - acumulador != 0) {            
            n = mayorPotencia2(numero - acumulador);
            acumulador += n;
            System.out.printf("%6d", n);        
        }        
    }

    /**
     * Generar aleatorios entre 0 y 255
     * y escribir cada aleatorio como suma de potencias de 2
     * Parar al salir el 255 o despues de generar n aleatorios
     * (ver enunciado)
     * 
     * Hay que usar el método anterior
     * 
     * Utiliza bucles while
     * 
     */
    public void generarAleatorios(int n) {
        int i = 1;
        int aleatorio = generador.nextInt(256);
        escribirSumaPotencias(aleatorio);
        while (i <= n && aleatorio != 255) {
            aleatorio = generador.nextInt(256);
            escribirSumaPotencias(aleatorio);
            System.out.println();
            i++;
        }      
    }

    /**
     *  Escribe en pantalla caracter n veces en la misma línes
     *  
     *  Usa bucles for
     */
    public void escribirCaracter(int n, char caracter)
    {
         for (int i = 1; i <= n; i++) {
             System.out.printf("%c", caracter);
            }
    }

    /**
     *  Genera la figura tal como muestra el enunciado 
     *  con ayuda del método anterior
     *  
     *   Usa bucles for
     */
    public  void mostrarEscalera(int escalones, int alto, int ancho) {
        System.out.println();
        //i = contador escalones; j = contador filas
        for (int i = 0; i < escalones; i++) {
            for (int j = 1; j <= alto; j++) {
                escribirCaracter(ancho * i, ESPACIO);
                escribirCaracter(ancho, ASTERISCO);
                System.out.println();
            }
        }
    }

}
