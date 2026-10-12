
import java.util.Random;

public class Pocion implements Runnable {

    private String nombre;
    private int fases;

    public Pocion(String nombre) {
        this.nombre = nombre;

        // sorteamos entre 4 y 8 fases
        Random random = new Random();
        fases = random.nextInt(5) + 4;
    }

    @Override
    public void run() {
        for (int i = 1; i <= fases; i++) {
            System.out.println("[" + nombre + "] fase " + i + "/" + fases);
        }
    }

    public String getNombre() {
        return nombre;
    }
}