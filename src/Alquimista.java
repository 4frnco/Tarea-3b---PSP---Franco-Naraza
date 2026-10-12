
public class Alquimista {

    public static void main(String[] args) {

        // cuatro pociones
        Pocion p1 = new Pocion("aprobado");
        Pocion p2 = new Pocion("honestidad");
        Pocion p3 = new Pocion("esfuerzo");
        Pocion p4 = new Pocion("trabajo");

        // un hilo para cada pocion
        Thread h1 = new Thread(p1, "Caldero-aprobado");
        Thread h2 = new Thread(p2, "Caldero-honestidad");
        Thread h3 = new Thread(p3, "Caldero-esfuerzo");
        Thread h4 = new Thread(p4, "Caldero-trabajo");

        Thread[] hilos = {h1, h2, h3, h4};

        // arrancamos los hilos
        for (int i = 0; i < hilos.length; i++) {
            hilos[i].start();
        }

        // esperamos a que terminen
        for (int i = 0; i < hilos.length; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Todas las pociones han terminado.");
    }
}