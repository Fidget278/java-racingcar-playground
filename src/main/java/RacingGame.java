public class RacingGame {
    public void start() {
        GameUI gameUI = GameUI.getInstance();

        RacingCars racingCars = new RacingCars(gameUI.gameStartUI());
        Round round = new Round(gameUI.roundUI());

        while(round.isRoundExecutable()) {
            racingCars.race();
            gameUI.racingUI(racingCars);
        }

        gameUI.raceEndUI(racingCars);
    }

    public void end() {
        GameUI.getInstance().close();
    }
}
