import java.util.Scanner;

public class GameUI {

    Scanner scanner = new Scanner(System.in);

    private final static GameUI instance = new GameUI();

    private GameUI() {}

    public static GameUI getInstance() {
        return instance;
    }

    public String gameStartUI() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return getUserInput();
    }

    public int roundUI() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(getUserInput());
    }

    public void racingUI(RacingCars racingCars) {
        System.out.println("실행 결과");

        for(var car : racingCars.getCars()) {
           car.printPosition();
        }
    }


    public void raceEndUI(RacingCars racingCars) {
        String winners = racingCars.selectWinners();

        if(winners == null) {
            System.out.println("승자가 없습니다.");
            return;
        }

        System.out.println(winners + "가 최종 우승 했습니다.");
    }

    public String getUserInput() {
        return scanner.next();
    }
    /**
     * 프로그램 종료 시에만 호출
     */
    public void close() {
        scanner.close();
    }

}
