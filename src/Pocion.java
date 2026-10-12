
import java.util.Random;

// representa una pocion que se prepara en varias fases dentro de un hilo
public class Pocion implements Runnable {

    private String nombre;
    private int fases;
    private int duracion;
    private long tiempoTotal;

     // crea una pociñon con un número aleatorio de fases y una duracion aleatoria para cada fase

    public Pocion(String nombre) {
        this.nombre = nombre;

        // sorteamos las fases y su duracion
        Random random = new Random();
        fases = random.nextInt(5) + 4;
        duracion = random.nextInt(201) + 200;
    }

     // ejecuta todas las fases de la poción y mide el tiempo total

    @Override
    public void run() {
        long inicio = System.currentTimeMillis();

        for (int i = 1; i <= fases; i++) {
            try {
                Thread.sleep(duracion);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("[" + nombre + "] fase " + i + "/" + fases);
        }

        tiempoTotal = System.currentTimeMillis() - inicio;

        System.out.println("[" + nombre + "] lista en " + tiempoTotal + " ms");
    }

     // devuelve el nombre de la poción
    public String getNombre() {
        return nombre;
    }

     // devuelve el tiempo total que ha tardado la poción

    public long getTiempoTotal() {
        return tiempoTotal;
    }
}
