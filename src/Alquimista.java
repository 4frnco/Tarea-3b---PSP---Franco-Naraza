
public class Alquimista
{
     // crea las pociones, arranca sus hilos, espera a que terminen y muestra los tiempos y la pocion más lenta
    public static void main(String[] args) {

        // cuatro pociones
        Pocion p1 = new Pocion("aprobado");
        Pocion p2 = new Pocion("honestidad");
        Pocion p3 = new Pocion("esfuerzo");
        Pocion p4 = new Pocion("trabajo");

        Pocion[] pociones = {p1, p2, p3, p4};

        // un hilo para cada pocion
        Thread h1 = new Thread(p1, "Caldero-aprobado");
        Thread h2 = new Thread(p2, "Caldero-honestidad");
        Thread h3 = new Thread(p3, "Caldero-esfuerzo");
        Thread h4 = new Thread(p4, "Caldero-trabajo");

        Thread[] hilos = {h1, h2, h3, h4};

        long inicio = System.currentTimeMillis();

        // contamos los hilos que siguen activos
        System.out.println("[Alquimista] Calderos al fuego: " + contar(hilos));

        // arrancamos todos los hilos
        for (int i = 0; i < hilos.length; i++) {
            hilos[i].start();
        }

        System.out.println("[Alquimista] Calderos al fuego: " + contar(hilos));

        // esperamos a que terminen todos
        for (int i = 0; i < hilos.length; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("[Alquimista] Calderos al fuego: " + contar(hilos));

        // calculamos el tiempo total y buscamos la pocion mas lenta
        long tiempoReal = System.currentTimeMillis() - inicio;
        long suma = 0;
        Pocion masLenta = pociones[0];

        for (int i = 0; i < pociones.length; i++) {
            suma += pociones[i].getTiempoTotal();

            if (pociones[i].getTiempoTotal() > masLenta.getTiempoTotal()) {
                masLenta = pociones[i];
            }
        }

        // mostramos el informe final
        System.out.println("Todas las pociones están listas.");
        System.out.println("Tiempo real: " + tiempoReal + " ms");
        System.out.println("Una detrás de otra: " + suma + " ms");
        System.out.println("La más lenta: " + masLenta.getNombre()
                + " (" + masLenta.getTiempoTotal() + " ms)");
    }

     // cuenta cuantos hilos del array siguen ejecutandose

    public static int contar(Thread[] hilos) {
        int contador = 0;

        for (int i = 0; i < hilos.length; i++) {
            if (hilos[i].isAlive()) {
                contador++;
            }
        }

        return contador;
    }
}

