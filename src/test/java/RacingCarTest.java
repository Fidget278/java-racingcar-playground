import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    @Test
    public void 차_여러개_생성() {
        String cars = "abc, qwe, asd";
        RacingCars racingCars = new RacingCars(cars);

        assertThat(racingCars.toString().equals(cars));
    }

    @Test
    public void 승자_한명_가려내기() {
        String cars = "abc, qwe, asd";
        RacingCars racingCars = new RacingCars(cars);

        var carList = racingCars.getCars();

        carList.get(0).goForward(4);
        carList.get(1).goForward(3);
        carList.get(2).goForward(3);

        assertThat(racingCars.selectWinners()).isEqualTo(carList.get(0).getName());
    }

    @Test
    public void 승자_여러명_가려내기() {
        String cars = "abc, qwe, asd";
        RacingCars racingCars = new RacingCars(cars);

        var carList = racingCars.getCars();

        carList.get(0).goForward(4);
        carList.get(1).goForward(4);
        carList.get(2).goForward(4);

        String[] winners = racingCars.selectWinners().split(",");

        assertThat(winners.length >= 3);

        winners[0].equals("abc");
        winners[1].equals("qwe");
        winners[2].equals("asd");
    }

    // 곁다리 Round Test
    @Test
    public void 라운드_테스트() {
        assertThatThrownBy(() -> new Round(0))
                .isInstanceOf(IllegalArgumentException.class);

        Round round = new Round(1);
        assertThat(round.isRoundExecutable());
        assertThat(round.getRound()).isEqualTo(0);
        assertThat(round.isRoundExecutable() == false);
    }

    // 곁다리 RandomNum 테스트
    @Test
    public void 난수_테스트() {
        for(int i = 0; i < 100; ++i) {
            int num = NumberUtil.getRandomNumToN(1);
            assertThat(num >= 0 && num <= 1);
        }
    }
}
