package formula;

import java.util.Random;

import static java.lang.Thread.sleep;

public class Car implements Runnable {

    private final String _pilotName;

    private Integer _currentRound;

    private Integer _totalTime;

    public Car(String pilotName) {
        _pilotName = pilotName;
        _currentRound = 0;
        _totalTime = 0;
    }

    private void toSleep(Integer time) {
        try {
            sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void onNewRound() {
        System.out.println(_pilotName + " Iniciou a " + (_currentRound + 1) + "º Volta");
        _currentRound++;
        Random random = new Random();
        int time = random.nextInt(10000 - 5000) + 5000;
        _totalTime += (time / 1000);
        toSleep(time);
    }


    @Override
    public void run() {
        while (_currentRound < 5) {
            onNewRound();
        }

        System.out.println(_pilotName + " Finalizou a corrida com " + _totalTime + " segundos");
    }
}
