
import java.util.Random;

public class Pocion implements Runnable {

    private String nombre;
    private int fases;
    private int duracion;

    public Pocion(String nombre) {
        this.nombre = nombre;

        // sorteamos las fases y su duracion
        Random random = new Random();
        fases = random.nextInt(5) + 4;
        duracion = random.nextInt(201) + 200;
    }

    @Override
    public void run() {
        for (int i = 1; i <= fases; i++) {
            try {
                Thread.sleep(duracion);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("[" + nombre + "] fase " + i + "/" + fases);
        }

        System.out.println("[" + nombre + "] lista");
    }

    public String getNombre() {
        return nombre;
    }
}