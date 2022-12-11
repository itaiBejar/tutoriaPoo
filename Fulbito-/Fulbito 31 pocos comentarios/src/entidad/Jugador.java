package entidad;

public class Jugador {

    /**
     * Definimos los atributos del objeto Jugador
     *
     */
    
    private String nombre;
    private int edad;
    private String colorRemera;
    private String colorPantalon;
    private String colorBotines;
    private String colorPelo;
    private String colorPiel;

    /**
     * Instanciamos el constructor vacio
     *
     */
    
    public Jugador() {
    }

    /**
     * Instanciamos el constructor con todos los parametros
     *
     * @param nombre
     * @param edad
     * @param colorRemera
     * @param colorPantalon
     * @param colorBotines
     * @param colorPelo
     * @param colorPiel
     */
    
    public Jugador(String nombre, int edad, String colorRemera, String colorPantalon, String colorBotines, String colorPelo, String colorPiel) {
        this.nombre = nombre;
        this.edad = edad;
        this.colorRemera = colorRemera;
        this.colorPantalon = colorPantalon;
        this.colorBotines = colorBotines;
        this.colorPelo = colorPelo;
        this.colorPiel = colorPiel;
    }

    /**
     * Instanciamos el constructor con algunos parametros (este se arma por que
     * lo necesitamos en el ejemplo planteado
     *
     * @param nombre
     * @param edad
     * @param colorBotines
     * @param colorPelo
     * @param colorPiel
     */
    
    public Jugador(String nombre, int edad, String colorBotines, String colorPelo, String colorPiel) {
        this.nombre = nombre;
        this.edad = edad;
        this.colorBotines = colorBotines;
        this.colorPelo = colorPelo;
        this.colorPiel = colorPiel;
    }

    /**
     * creamos los getters y setters
     *
     */
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getColorRemera() {
        return colorRemera;
    }

    public void setColorRemera(String colorRemera) {
        this.colorRemera = colorRemera;
    }

    public String getColorPantalon() {
        return colorPantalon;
    }

    public void setColorPantalon(String colorPantalon) {
        this.colorPantalon = colorPantalon;
    }

    public String getColorBotines() {
        return colorBotines;
    }

    public void setColorBotines(String colorBotines) {
        this.colorBotines = colorBotines;
    }

    public String getColorPelo() {
        return colorPelo;
    }

    public void setColorPelo(String colorPelo) {
        this.colorPelo = colorPelo;
    }

    public String getColorPiel() {
        return colorPiel;
    }

    public void setColorPiel(String colorPiel) {
        this.colorPiel = colorPiel;
    }

    /**
     * Sobreescribimos el método toString() y lo modificamos de tal manera que
     * nos muestre los datos como nosotros queremos
     *
     * nota: la \t tabula un espacido y \n hace un salto de línea
     *
     * @return un String
     */
    
    @Override
    public String toString() {
        return "Nombre: " + nombre.toUpperCase()
                + "\nColor Piel: " + colorPiel + "\tEdad: " + edad + " años"
                + "\nColor Pelo: " + colorPelo + "\tColor remera: " + colorRemera
                + "\nColor botines: " + colorBotines + "\tColor pantalon: " + colorPantalon + "\n";
    }

}
