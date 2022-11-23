import java.util.concurrent.Semaphore;

public class Ejercicio2 implements Runnable{

    Semaphore carniceria = new Semaphore(4);
    Semaphore charcuteria = new Semaphore(2);

    /**
     * Creacion de los 10 hilos de una clase
     * @param args
     */
    public static void main(String[] args)
    {
        Ejercicio2 mn = new Ejercicio2();
        for(int i=0; i<10; i++) {
            new Thread(mn).start();
        }
    }

    /**
     * metodo que comprueba si es hay disponible hueco en la carniceria y si no va a la charcuteria y lo mismo pero
     * al reves y lo demas es igual que en ejercicio anterior
     */
    @Override
    public void run() {
        try {
            if (carniceria.availablePermits() > 0) {
                carniceria.acquire();
                System.out.println("El " + Thread.currentThread().getName() + " está en la carniceria");
                Thread.sleep((int) (Math.random() * 10000));
                System.out.println("El " + Thread.currentThread().getName() + " ha terminado en la carnicería");
                carniceria.release();
            } else {
                charcuteria.acquire();
                System.out.println("El " + Thread.currentThread().getName() + " está en la charcuteria");
                Thread.sleep((int) (Math.random() * 10000));
                System.out.println("El " + Thread.currentThread().getName() + " ha terminado en la charcuteria");
                charcuteria.release();
            }


            if (charcuteria.availablePermits() > 0) {
                charcuteria.acquire();
                System.out.println("El " + Thread.currentThread().getName() + " está en la charcuteria");
                Thread.sleep((int) (Math.random() * 10000));
                System.out.println("El " + Thread.currentThread().getName() + " ha terminado en la charcuteria");
                charcuteria.release();
            } else {
                carniceria.acquire();
                System.out.println("El " + Thread.currentThread().getName() + " está en la carniceria");
                Thread.sleep((int) (Math.random() * 10000));
                System.out.println("El " + Thread.currentThread().getName() + " ha terminado en la carnicería");
                carniceria.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
