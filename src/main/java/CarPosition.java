public class CarPosition {
    private int position;
    private StringBuffer positionBar = new StringBuffer();

    public CarPosition(int position) {
        this.position = position;
    }

    public void move() {
        ++position;
        positionBar.append("=");
    }

    public void printCarPosition() {
        System.out.print(positionBar);
    }

    public int getPosition() {
        return position;
    }
}
