public class ThreadSemaphoreFactory {
    public Thread createThread(String name, Colors startsWith) {
        try {
            if (startsWith != Colors.RED && startsWith != Colors.GREEN) {
                throw new Exception("[startsWith] Valor Inválido: Insira 0 ou 1!!");
            }
            return new Thread(new Semaphore(name, startsWith));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
