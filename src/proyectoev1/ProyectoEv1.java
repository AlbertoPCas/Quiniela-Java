/*
 * Proyecto final evaluacion 1 - Alberto Perez Castaneda
 */
package proyectoev1;

/**
 *
 * @author Alberto Perez Castaneda
 */
import java.text.NumberFormat;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import static java.time.temporal.TemporalAdjusters.next;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author percasal
 */
public class ProyectoEv1 {

    /**
     * Solución para que todos los métodos puedan utilizar Scanner
     */
    public Scanner sc = new Scanner(System.in);

    /**
     * Solución para que todos los métodos puedan utilizar Random
     */
    public Random aleatorio = new Random();

    /**
     * Solución para que todos los métodos puedan utilizar LocalDateTime
     */
    public LocalDateTime hoy = LocalDateTime.now();

    /**
     * Solución para que todos los métodos puedan utilizar DateTimeFormatter
     */
    public DateTimeFormatter dtf2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);

    /**
     * Método que utiliza el main para mostrar el menú. Muestra el título del
     * proyecto y todas las ofertas posibles.
     */
    public void menu() {
        System.out.print("-----------------------\n| LOTERÍAS Y APUESTAS |\n-----------------------");
        System.out.print("\n1.- Primitiva\n2.- Quiniela\n3.- Lotería\n0.- Salir");
    }

    /**
     * Método que engloba el primer juego (Primitiva) Usando el LocalDateTime
     * sigJueves selecciona el primer jueves encontrado. Como la primitiva se
     * realiza a las 22:00, se crea un int hora que recoja la hora del día
     * actual. Bucle if: Si hoy es jueves y además la hora es mayor o igual que
     * 22, configura el siguiente jueves y lo muestra. Si no, selecciona el
     * primer jueves (ya configurado anteriormente) Se crea un String
     * cadenaTotalPrim, este string irá recogiendo los variables en caso de que
     * no esté repetido. Para buscar si está repetido se crea una substring
     * cadenaNumPrim, que recoge el valor de un número generado aleatoriamente.
     * Este substring busca dentro de la cadena, si no encuentra el mismo número
     * es que no está repetido: lo imprime por pantalla. Dentro de este bucle
     * también coloco que si i (total de números) está en la sexta posición y no
     * está repetido imprima por pantalla complementario. Se coloca dentro del
     * if porque si se coloca fuera puede dar fallos si el sexto es repetido, se
     * imprimiría complementario dos veces. Tras tener los seis números y el
     * complementario, se genera el reintegro.
     */
    public void primitiva() {
        System.out.print("****************\n* LA PRIMITIVA *\n****************");
        LocalDateTime sigJueves = hoy.with((DayOfWeek.THURSDAY));
        int hora = hoy.getHour();

        if (hoy.getDayOfWeek() == sigJueves.getDayOfWeek() && hora >= 22) {
            sigJueves = hoy.with(next(DayOfWeek.THURSDAY));
            System.out.print("\nLa primitiva se realizará el próximo jueves, día " + dtf2.format(sigJueves) + " a las 22:00");
        } else {
            System.out.print("\nLa primitiva se realizará el próximo jueves, día " + dtf2.format(sigJueves) + " a las 22:00");
        }

        System.out.println();
        System.out.println();
        String cadenaTotalPrim = "";
        int numeroPrim = 0;
        for (int i = 0; i < 7;) {
            numeroPrim = aleatorio.nextInt(49) + 1;
            String cadenaNumPrim = "";
            cadenaNumPrim = cadenaNumPrim + numeroPrim;
            int posicBuscPrim = -1;
            do {
                posicBuscPrim = cadenaTotalPrim.indexOf(cadenaNumPrim, posicBuscPrim + 1);
                if (posicBuscPrim == -1) {
                    if (i == 6) {
                        System.out.print("\nComplementario: ");
                    }
                    System.out.print(numeroPrim + " ");
                    cadenaTotalPrim = cadenaTotalPrim + cadenaNumPrim + " ";
                    i++;
                }
            } while (posicBuscPrim == -1);
        }
        int reintegroPrim = aleatorio.nextInt(8);
        System.out.print("\nReintegro: " + reintegroPrim);
        System.out.println();
    }

    /**
     * Método que engloba el segundo juego (Quiniela) Se configura la fecha y la
     * hora de la misma forma que el anterior método, pero esta vez en domingo.
     * Tras esto comienza un bucle do while anidado. El do while interno utiliza
     * un String para comparar y verificar que el usuario ha introducido un
     * número entre el 2 y el 8. Tras comprobar que es un número natural y entre
     * el 2 y el 8, entra en un doble bucle for El bucle for externo El bucle
     * for interno genera números aleatorios entre 0, 1 y 2. Imprime en pantalla
     * diferentes valores según el número (X, 1, 2) hasta 15 valores. Si el
     * número no es 14 (final), imprime un espacio para separar estos números.
     * El do while externo genera las filas de la quiniela hasta el número que
     * haya introducido el usuario por teclado.
     *
     */
    public void quiniela() {
        System.out.print("***************\n* LA QUINIELA *\n***************");
        LocalDateTime sigDomingo = hoy.with(next(DayOfWeek.SUNDAY));
        int hora = hoy.getHour();

        if (hoy.getDayOfWeek() == sigDomingo.getDayOfWeek() && hora >= 22) {
            sigDomingo = hoy.with(next(DayOfWeek.SUNDAY));
            System.out.print("\nLa quiniela se realizará el próximo domingo, día " + dtf2.format(sigDomingo) + " a las 22:00");
        } else {
            System.out.print("\nLa quiniela se realizará el próximo domingo, día " + dtf2.format(sigDomingo) + " a las 22:00");
        }

        System.out.println();
        int apuestasQuiniela;
        String respuestaQuiniela;
        do {
            do {
                System.out.print("\n¿Cuántas apuestas quieres realizar? (2-8): ");
                respuestaQuiniela = sc.next();
                sc.nextLine();
                if (!respuestaQuiniela.equals("2") && !respuestaQuiniela.equals("3") && !respuestaQuiniela.equals("4") && !respuestaQuiniela.equals("5") && !respuestaQuiniela.equals("6") && !respuestaQuiniela.equals("7") && !respuestaQuiniela.equals("8")) {
                    System.out.print("Has introducido un valor erróneo. Por favor, introduce un número entre el 2 y el 8.");
                }
            } while (!respuestaQuiniela.equals("2") && !respuestaQuiniela.equals("3") && !respuestaQuiniela.equals("4") && !respuestaQuiniela.equals("5") && !respuestaQuiniela.equals("6") && !respuestaQuiniela.equals("7") && !respuestaQuiniela.equals("8"));
            apuestasQuiniela = Integer.parseInt(respuestaQuiniela);

            for (int j = 0; j < apuestasQuiniela; j++) {
                System.out.print("\nApuesta " + (j + 1) + ": ");
                for (int j2 = 0; j2 < 15; j2++) {
                    int numeroQuiniela = aleatorio.nextInt(3);
                    if (numeroQuiniela == 0) {
                        System.out.print("X");
                    } else if (numeroQuiniela == 1) {
                        System.out.print("1");
                    } else {
                        System.out.print("2");
                    }
                    if (j2 != 14) {
                        System.out.print(" ");
                    }
                }
            }
        } while (apuestasQuiniela < 2 || apuestasQuiniela > 8);
        System.out.println();
    }

    /**
     * Método que engloba el tercer juego (Lotería). Se configura la fecha y la
     * hora de la misma forma que el anterior método, pero esta vez en sábado.
     * Comienza un bucle do while de validación de la respuesta, que utiliza la
     * bandera correctoLot. Recoge esa respuesta en un String. Si el string
     * tiene longitud de caracter 0 (está vacío) cambia la bandera a true para
     * que continúe. Ahora se crea otra bandera. El motivo de esta doble bandera
     * es que si solo utilizas una el usuario podría introducir una respuesta
     * como "aa7" y el programa la recibiría, ya que el último caracter es un
     * número aceptado. Se crea un bucle de validación que analiza todos los
     * caracteres introducidos. Se convierten los caracteres a números enteros.
     * Si algún número es inferior a 48 o superior a 57 (entre estos números
     * estarían los números naturales), la segunda bandera (error) cambiaría a
     * true. Esta segunda bandera no puede cambiar a false de ninguna forma
     * (salvo el default), entonces en el momento en el que esta bandera entre a
     * true, la bandera principal pasaría a false: Error. Hay un caracter no
     * deseado. Una vez esté la respuesta correcta, se analiza la longitud (0,
     * 1, 2, 3 valores) y se generan números en función de esos valores. (Si ha
     * introducido 0 valores: genera número de 5 cifras, 1 valor: 4 cifras +
     * terminacion...). Después se genera un número de serie y un número de
     * fracción.
     */
    public void loteria() {
        System.out.print("********************\n* LOTERÍA NACIONAL *\n********************");
        LocalDateTime sigSabado = hoy.with(next(DayOfWeek.SATURDAY));
        int hora = hoy.getHour();

        if (hoy.getDayOfWeek() == sigSabado.getDayOfWeek() && hora >= 22) {
            sigSabado = hoy.with(next(DayOfWeek.SATURDAY));
            System.out.print("\nLa lotería se realizará el próximo sábado, día " + dtf2.format(sigSabado) + " a las 22:00");
        } else {
            System.out.print("\nLa lotería se realizará el próximo sábado, día " + dtf2.format(sigSabado) + " a las 22:00");
        }

        System.out.println();
        String terminacionLoteria;

        int numeroLot;
        int serieLot;
        int fraccionLot;

        int caracterTermLot = 0;
        boolean correctoLot = false;
        do {
            System.out.print("\nElige una terminación numérica de hasta 3 cifras (ENTER si te da igual): ");
            terminacionLoteria = sc.nextLine();

            if (terminacionLoteria.length() == 0) {
                correctoLot = true;
            }

            boolean errorNumLot = false;
            for (int i = 0; i < terminacionLoteria.length(); i++) {
                char letraTermLot = terminacionLoteria.charAt(i);
                caracterTermLot = (int) letraTermLot;

                if (caracterTermLot < 48 || caracterTermLot > 57) {
                    errorNumLot = true;
                }

                if (errorNumLot == true) {
                    correctoLot = false;
                } else {
                    correctoLot = true;
                }
            }

            if (terminacionLoteria.length() > 3) {
                correctoLot = false;
            }

            if (correctoLot == false) {
                System.out.print("Has introducido un valor erróneo. Por favor, introdúcelo de nuevo.");
            }
        } while (correctoLot == false);

        switch (terminacionLoteria.length()) {
            case 0:
                numeroLot = aleatorio.nextInt(90000) + 10000;
                System.out.print("\nNúmero con el que juegas: " + numeroLot);
                break;
            case 1:
                numeroLot = aleatorio.nextInt(9000) + 1000;
                System.out.print("\nNúmero con el que juegas: " + numeroLot + terminacionLoteria);
                break;
            case 2:
                numeroLot = aleatorio.nextInt(900) + 100;
                System.out.print("\nNúmero con el que juegas: " + numeroLot + terminacionLoteria);
                break;
            case 3:
                numeroLot = aleatorio.nextInt(90) + 10;
                System.out.print("\nNúmero con el que juegas: " + numeroLot + terminacionLoteria);
                break;
        }

        serieLot = aleatorio.nextInt(900) + 100;
        System.out.print("\nSerie: " + serieLot);
        fraccionLot = aleatorio.nextInt(90) + 10;
        System.out.print(" / Fracción: " + fraccionLot);

        System.out.println();
    }

    /**
     *
     * @param args Ejecuta el programa principal, con "app" llamamos a los demás
     * métodos. Se llama al método "menú", y depende la respuesta que de llama a
     * un método u otro. Esta respuesta está controlada por un bucle de
     * validación, que controlará que solo se introduzca un número natural entre
     * los pedidos. Además, después de llamar al método va aumentando la
     * variable dinero, recogida en double porque la quiniela cuesta 0.50€. Al
     * final hay un bucle de validación para preguntar si quiere volver a jugar.
     * Este bucle se ejecutará siempre que la respuesta no sea 0 (para que no se
     * ejecute en primera vuelta). Si el usuario vota "no" la respuesta
     * principal se convertirá en 0, con lo cual saldrá del programa. El
     * programa acaba con un formateo de moneda de la variable "dinero", e
     * imprime por pantalla lo que el usuario tiene que pagar.
     *
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProyectoEv1 app = new ProyectoEv1();

        String respuestaPrinc;
        double dinero = 0;
        do {
            app.menu();
            do {
                System.out.print("\nIntroduce el número del juego al que quieres jugar: ");
                respuestaPrinc = sc.next();
                sc.nextLine();
                if (!respuestaPrinc.equals("0") && !respuestaPrinc.equals("1") && !respuestaPrinc.equals("2") && !respuestaPrinc.equals("3")) {
                    System.out.println("Has introducido un valor erróneo. Por favor, introduce uno de estos valores.");
                }
            } while (!respuestaPrinc.equals("0") && !respuestaPrinc.equals("1") && !respuestaPrinc.equals("2") && !respuestaPrinc.equals("3"));

            switch (respuestaPrinc) {
                case "1":
                    app.primitiva();
                    dinero = dinero + 1;
                    break;
                case "2":
                    app.quiniela();
                    dinero = dinero + 0.5;
                    break;
                case "3":
                    app.loteria();
                    dinero = dinero + 12;
                    break;
            }

            String respuestaReset;
            if (!respuestaPrinc.equals("0")) {
                do {
                    System.out.print("\n¿Quieres volver a jugar? (Sí/No): ");
                    respuestaReset = sc.next().toLowerCase();
                    if (respuestaReset.equals("no")) {
                        respuestaPrinc = "0";
                    } else if (!respuestaReset.equals("si") && !respuestaReset.equals("no")) {
                        System.out.print("Por favor, introduce 'Sí' o 'No'.");
                        System.out.println();
                    }
                } while (!respuestaReset.equals("si") && !respuestaReset.equals("no"));
                System.out.println();
            }
        } while (!respuestaPrinc.equals("0"));

        NumberFormat nf = NumberFormat.getInstance();
        nf = NumberFormat.getCurrencyInstance();
        System.out.println("Total a pagar: " + nf.format(dinero));
    }
}
