
public class Alquimista {

    public static void main(String[] args) {

        // creamos una pocion y su hilo
        Pocion p1 = new Pocion("aprobado");
        Thread h1 = new Thread(p1, "Caldero-aprobado");

        h1.start();

        // esperamos a que termine
        try {
            h1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Pocion preparada.");
    }
}