package formula;

public class Main {

    public static void main(String[] args) {

        ThreadCarFactory threadCarFactory = new ThreadCarFactory();

        Thread first_car = threadCarFactory.createTread("Hamilton");
        Thread second_car = threadCarFactory.createTread("Felipe Massa");

        first_car.start();
        second_car.start();
    }
}
