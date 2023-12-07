import static java.lang.Thread.sleep;

@SuppressWarnings("ALL")
public class Semaphore implements Runnable {

    private final String _name;

    private Integer _timeDelay;
    private Colors _startsWith;

    public Semaphore(String name, Colors startsWith) {
        _name = name;
        _timeDelay = 5000;
        _startsWith = startsWith;
    }

    public void setTimeDelay(Integer timeDelay) {
        _timeDelay = timeDelay;
    }

    private void toSleep(Integer time) {
        try {
            sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void toGreenState() {
        System.out.println("[" + _name + "]" + " Muda pra VERDE");
        toSleep((int) (_timeDelay - (_timeDelay * 0.8)));
        _startsWith = Colors.YELLOW;
    }

    private void toRedState() {
        System.out.println("[" + _name + "]" + " Muda pra VERMELHO");
        toSleep(5000);
        _startsWith = Colors.GREEN;
    }

    private void toYellowState() {
        System.out.println("========" + "[" + _name + " Muda pra AMARELO " + "]" + "========");
        toSleep((int) (_timeDelay * 0.8));
        _startsWith = Colors.RED;
    }

    @Override
    public void run() {
        System.out.println(_name + " Iniciando.." + " Sinal: " + _startsWith);
        toSleep(50);
        while (true) {
            switch (_startsWith) {
                case GREEN -> {
                    toGreenState();
                }
                case YELLOW -> {
                    toYellowState();
                }
                case RED -> {
                    toRedState();
                }
            }
        }
    }
}
