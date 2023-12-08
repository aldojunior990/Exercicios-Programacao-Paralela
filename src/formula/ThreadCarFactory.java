package formula;

public class ThreadCarFactory {

    public Thread createTread(String pilotName) {
        return new Thread(new Car(pilotName));
    }
}
