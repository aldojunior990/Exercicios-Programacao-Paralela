public class Main {
    public static void main(String[] args) {
        ThreadSemaphoreFactory threadFactory = new ThreadSemaphoreFactory();

        // 0 -> Vermelho
        // 1 -> Verde
        // 2 -> Amarelo

        Thread first_semaphore = threadFactory.createThread("semaforo 1", Colors.GREEN);
        Thread second_semaphore = threadFactory.createThread("semaforo 2", Colors.RED);

        first_semaphore.start();
        second_semaphore.start();

    }
}