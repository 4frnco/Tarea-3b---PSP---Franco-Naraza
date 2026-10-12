
public class Pocion implements Runnable {

    private String nombre;

    public Pocion(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        // mostrar qu empieza la pocion
        System.out.println("preparando la pocion " + nombre);
    }

    public String getNombre() {
        return nombre;
    }
}