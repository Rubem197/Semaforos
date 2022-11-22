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
     * metodo que le llegan 4 hilos simultaneos y tienen un random entre 0,1 y 10 segundos en ser atendidos
     * tras ser atendidos daran un mensaje y entrara un nuevo hilo hasta que entren 10 hilos
     */
    @Override
    public void run() {
        try {

                carniceria.acquire();
                System.out.println("El " + Thread.currentThread().getName() + " está en la carniceria");
                Thread.sleep((int) (Math.random() * 10000));
                System.out.println("El " + Thread.currentThread().getName() + " ha terminado en la carnicería");
                carniceria.release();



                charcuteria.acquire();
                System.out.println("El " + Thread.currentThread().getName() + " está en la charcuteria");
                Thread.sleep((int) (Math.random() * 10000));
                System.out.println("El " + Thread.currentThread().getName() + " ha terminado en la charcuteria");
                charcuteria.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
