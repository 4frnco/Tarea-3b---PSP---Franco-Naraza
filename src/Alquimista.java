
public class Alquimista {

    public static void main(String[] args) {

        // creao una pocion y su hilo
        Pocion p1 = new Pocion("aprobado");
        Thread h1 = new Thread(p1, "Caldero-aprobado");

        h1.start();

        // espero a que termine
        try {
            h1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("pocion preparada.");
    }
}