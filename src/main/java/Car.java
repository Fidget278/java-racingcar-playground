public class Car {

    final private CarName name;
    private final CarPosition carPosition;

    private final static int ACC_STANDARD = 4;

    public Car(String name) {

        this.name = new CarName(name);
        this.carPosition = new CarPosition(0);
    }

    public void race() {
        goForward(NumberUtil.getRandomNumToN(9));
    }

    void goForward(int acc) {
        if(acc >= ACC_STANDARD) {
            carPosition.move();
        }
    }

    public String getName() {
        return name.toString();
    }

    public void printPosition() {
        System.out.print(name + " : ");
        carPosition.printCarPosition();
    }

    public CarPosition getCarPosition() {
        return carPosition;
    }
}
