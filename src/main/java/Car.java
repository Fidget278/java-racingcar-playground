import java.util.Optional;
import java.util.stream.Stream;

public class Car {
    private String name;
    private int forward;
    private StringBuffer forwardBar = new StringBuffer();
    private final static int accStandard = 4;

    public Car(String name) {
        this.name = checkValidName(name);
    }

    public void race() {
        goForward(NumberUtil.getRandomNumToN(9));
    }

    void goForward(int acc) {
        if(acc >= accStandard) {
            ++forward;
            forwardBar.append("-");
        }
    }

    private String checkValidName(String name) {
        if(name == null || name.equals("") || name.length() > 5)
            throw new RuntimeException();

        return name;
    }

    public String getName() {
        return name;
    }
    public int getForward() {
        return forward;
    }
    public String getForwardBar() {
        return forwardBar.toString();
    }
}
