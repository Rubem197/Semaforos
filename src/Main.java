import java.util.concurrent.Semaphore;

public class Main implements Runnable {


   Semaphore semaforo = new Semaphore(4);

	/**
	 * Creacion de los 10 hilos de una clase
	 * @param args
	 */
    public static void main(String[] args)
    {
        Main mn = new Main();
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
			semaforo.acquire();
			System.out.println("El "+ Thread.currentThread().getName()+ " está siendo atendido");
			Thread.sleep((int)(Math.random()*10000));
			System.out.println("El "+ Thread.currentThread().getName()+ " ha terminado en la carnicería");
			semaforo.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}