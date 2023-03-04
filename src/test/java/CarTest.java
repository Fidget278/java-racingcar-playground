import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @Test
    public void 이름_규칙() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(RuntimeException.class);

        assertThatThrownBy(() -> new Car(null))
                .isInstanceOf(RuntimeException.class);

        assertThatThrownBy(() -> new Car("asdfeg"))
                .isInstanceOf(RuntimeException.class);

        Car car5 = new Car("asdfe");
        assertThat(car5.getName()).isEqualTo("asdfe");

        Car car1 = new Car("a");
        assertThat(car1.getName()).isEqualTo("a");
    }

    @Test
    public void 전진_규칙() {
        Car car = new Car("TestCar");

        car.goForward(3);
        assertThat(car.getForward()).isEqualTo(0);
        car.goForward(4);
        assertThat(car.getForward()).isEqualTo(1);
    }
}
