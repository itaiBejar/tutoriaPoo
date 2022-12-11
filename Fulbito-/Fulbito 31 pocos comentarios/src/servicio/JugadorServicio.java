package servicio;

import entidad.Jugador;
import java.util.Scanner;

public class JugadorServicio {

    /**
     * Reservamos el espacio en memoria de los atributos globales en esta caso
     * un objeto del tipo Scanner, un Jugador de la clase jugador y tres
     * arreglos de tipo Jugador.
     */
    
    private Scanner leer;
    private Jugador jugador;
    private Jugador[] listaJugadores;
    private Jugador[] equipoRojo;
    private Jugador[] equipoAzul;

    /**
     * En el constructor vacio de nuestra Clase JugadorServicio hago nacer
     * nuestro objeto leer de la clase Scanner, ésto lo hago así ya que se
     * considera una buena prática ya que recién cuando instancie un objeto de
     * la clase empieza a ocupar memoria el objeto leer, y no antes.
     */
    
    public JugadorServicio() {
        this.leer = new Scanner(System.in).useDelimiter("\n");
    }

    /**
     * Creamos el método crearJugador() que sólo tiene por función hacer nacer
     * el objeto jugador (conectando así nuestro clase JugadorServicio con un
     * objeto de la Clase Jugador), luego seteo (asigno los atributos nombre,
     * edad, colorBotines, colorPelo, colorPiel a nuestro jugador, observemos
     * que nuestro método es del tipo Jugador , por ende nos retorna un objeto
     * del tipo Jugador, en este simple ejemplo usamos nuestros setters y
     * tambien nuestros gettees, junto con un constructor sobrecargado con
     * algunos parametros, ya que otros parametros se setean cuando se le asigna
     * el equipo, observa que creamos tres constructores en la Clase Jugador.
     */
    
    private Jugador crearJugador() {
        jugador = new Jugador();
        System.out.print("Ingrese el nombre: ");
        jugador.setNombre(leer.next());
        System.out.print("Ingrese la edad: ");
        jugador.setEdad(leer.nextInt());
        System.out.print("Ingrese el color de botines: ");
        jugador.setColorBotines(leer.next());
        System.out.print("Ingrese el color de pelo: ");
        jugador.setColorPelo(leer.next());
        System.out.print("Ingrese el tono de piel: ");
        jugador.setColorPiel(leer.next());
        return new Jugador(jugador.getNombre(), jugador.getEdad(),
                jugador.getColorBotines(), jugador.getColorPelo(),
                jugador.getColorPiel());
    }

    /**
     * Creamos el método crearlistaJugadores() que tiene por función hacer
     * llenar el arreglo listaJugadores[] con cada uno de los jugadores que
     * definamos al ingresar un valor por teclado en la variable local cant_Jug,
     * que a través de un bucle do - while válida que no saldrá del bucle (osea
     * no la tomará como válida) hasta que no sea par y menor a 11, luego una
     * vez validada define el tamaño de nuestro arreglo listaJugadores, cuando
     * este nace (o se instancia), posteriormente iniciamos un bucle for dónde
     * llenamos el arreglo en cada una de las posiciones llamando nuestro método
     * crearJugador(), al cual definimos como private para que sólo sea accedido
     * desde esta clase.
     */
    
    public void crearlistaJugadores() {

        int cant_Jug;
        do {
            System.out.println("Ingrese cantidad de jugadores (sólo pares y hasta 10)");
            cant_Jug = leer.nextInt();
        } while (cant_Jug % 2 != 0 || cant_Jug > 11);
        listaJugadores = new Jugador[cant_Jug];
        for (int i = 0; i < listaJugadores.length; i++) {
            System.out.println("jugador " + (i + 1) + ": ");
            listaJugadores[i] = crearJugador();
        }
    }

    /**
     * Creamos el método listaPreCreada() con el fin de asignarle a nuestro
     * arreglo una lista de los jugadores para poder saltarnos el paso de
     * crearla manualmente donde creamos un arreglo de tipo Jugador llamado
     * listaJugadoresPre con una lista de 10 jugadores y luego se lo asignamos a
     * nuestro arreglo listaJugadores, notemos que éste método es de tipo
     * arreglo de Jugador por lo que nos retorna un arreglo de esos tipos de
     * datos.
     *
     * @return listaJugadores[]
     */
    
    public Jugador[] listaPreCreada() {
        Jugador j1 = new Jugador("Raúl", 44, "negro", "negro", "morena");
        Jugador j2 = new Jugador("Pablo", 43, "marrón", "castaño", "blanca");
        Jugador j3 = new Jugador("Juan", 25, "negro", "castaño", "blanca");
        Jugador j4 = new Jugador("Marcelo", 33, "gris", "negro", "morena");
        Jugador j5 = new Jugador("Tomás", 24, "blanco", "negro", "blanca");
        Jugador j6 = new Jugador("Stefano", 24, "rojo", "negro", "morena");
        Jugador j7 = new Jugador("Mariano", 36, "blanco", "castaño", "blanca");
        Jugador j8 = new Jugador("Ignacio", 43, "naranja", "negro", "morena");
        Jugador j9 = new Jugador("Franco", 29, "azul", "negro", "morena");
        Jugador j10 = new Jugador("Itai", 23, "celeste", "castaño", "blanca");
        listaJugadores = new Jugador[10];
        Jugador[] listaJugadoresPre = {j1, j2, j3, j4, j5, j6, j7, j8, j9, j10};
        listaJugadores = listaJugadoresPre;
        return listaJugadores;
    }

    /**
     * Creamos el método sortearEquipos() el cual es encargado de asignar los
     * jugadores de la lista completa de jugadores a cada una de los equipos,
     * tanto el equipoAzul[] como el equipoRojo[] que son arreglos de la mitad
     * de elementos que la lista completa de jugadores, este se vale del método
     * indiceValido(int cantidad, int rango), (que explicaremos su
     * funcionamiento cuando lleguemos a el) para llenar el equipoAzul ocupamos
     * un bucle for desde i = 0 hasta i menor que la mitad de los elementos de
     * la lista completa y dentro de este for definimos un switch donde según el
     * valor de i asigna al jugador del equipo azul en la posicion i el valor
     * del jugador de la listaJugadores en la posicion que corresponde al vector
     * valor(con numeros del 0 al 9 distribuidos en forma aleatoria) en la
     * posicion i tambien, luego para el equipoRojo hace algo similar, solo que
     * tiene un contador (cont) que incia desde 0 e incrementa en cada
     * iteracion, con la diferencia que el bucle for empieza desde la numJug -1
     * (porque recordemos que vamos recorriendo desde 0 a 9) aunque en este caso
     * empieza desde 9 y terminará en 5. Así repartimos a todos nuestros
     * juegadores en los dos equipos. Al mismo tiempo que le asigna el equipo a
     * cada jugador le asigna a cada uno su color de remera como de pantalon.
     *
     */
    
    public void sortearEquipos() {
        int cont = 0;
        int numJug = listaJugadores.length;
        equipoAzul = new Jugador[numJug / 2];
        equipoRojo = new Jugador[numJug / 2];
        System.out.println("cantidad de jugadores: " + listaJugadores.length);
        int[] valor = indiceValido(numJug, numJug);

        for (int i = 0; i < numJug / 2; i++) {

                    equipoAzul[i] = listaJugadores[valor[i]];
                    listaJugadores[valor[i]].setColorRemera("Azul");
                    listaJugadores[valor[i]].setColorPantalon("Blanco");
        }
        for (int i = numJug - 1; i > ((numJug / 2) - 1); i--) {
                    equipoRojo[cont] = listaJugadores[valor[i]];
                    listaJugadores[valor[i]].setColorRemera("Roja");
                    listaJugadores[valor[i]].setColorPantalon("Rojo");
                    cont++;
        }

    }

    /**
     * Este método llena un arreglo con numeros aleatorios no repetidos, siempre
     * el rango tiene que ser mayor o igual a la cantidad, por que sino entrará
     * en un bucle infinto ya que no existen numeros que no sean repetidos
     *
     * @param cantidad
     * @param rango
     * @return arreglo de enteros no repetidos
     */
    
    private int[] indiceValido(int cantidad, int rango) {
        int i = 0;
        int arreglo[] = new int[cantidad];
        arreglo[i] = (int) (Math.random() * rango);
        for (i = 1; i < cantidad; i++) {
            arreglo[i] = (int) (Math.random() * rango);
            for (int j = 0; j < i; j++) {
                if (arreglo[i] == arreglo[j]) {
                    i--;
                }
            }
        }

        return arreglo;
    }

    /**
     * Este método calcula la edad promedio de los jugadores de cada equipo el
     * cual lo recibe por parametro
     *
     * @param equipo
     */
    
    private void edadPromedio(Jugador[] equipo) {
        int suma = 0;
        for (Jugador auxJugador : equipo) {
            suma = suma + auxJugador.getEdad();
        }
        double prom = (double) suma / equipo.length;
        System.out.println("\nLa edad promedio del equipo rojo es: " + (double) prom + " Años");
    }

    /**
     * Este método imprime por pantalla una lista de los nombres, edad y
     * promedio de edad de los jugadores de cada equipo
     */
    
    public void mostrarEquipos() {
        System.out.println("*******************Equipo Azul*******************");
        int cont = 1;
        for (Jugador jugadorAzul : equipoAzul) {
            System.out.println(cont + ".- " + jugadorAzul.getNombre() + "\t" + jugadorAzul.getEdad() + " Años");
            cont++;
        }
        edadPromedio(equipoAzul);
        System.out.println("*************************************************");
        System.out.println("");
        System.out.println("*******************Equipo Rojo*******************");
        cont = 1;
        for (Jugador jugadorRojo : equipoRojo) {
            System.out.println(cont + ".- " + jugadorRojo.getNombre() + "\t " + jugadorRojo.getEdad() + " Años");
            cont++;
        }
        edadPromedio(equipoRojo);
        System.out.println("*************************************************");
    }

    /**
     * Este método imprime por pantalla la lista de todos los jugadores por
     * equipo, con todos sus atributos y promedio de edad de los jugadores de
     * cada equipo
     */
    
    public void mostrarEquiposCompletos() {
        System.out.println("*******************Equipo Azul*******************");
        int cont = 1;
        for (Jugador jugadorAzul : equipoAzul) {
            System.out.println(jugadorAzul);
            cont++;
        }
        edadPromedio(equipoAzul);
        System.out.println("*************************************************");
        System.out.println("");
        System.out.println("*******************Equipo Rojo*******************");
        cont = 1;
        for (Jugador jugadorRojo : equipoRojo) {
            System.out.println(jugadorRojo);
            cont++;
        }
        edadPromedio(equipoRojo);
        System.out.println("*************************************************");
    }
}
