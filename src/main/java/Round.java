import java.util.Optional;

public class Round {
    private int round;

    public Round(int round) {
        this.round = validateRound(round);
    }

    /**
     * excuete Round and Decrement Round num
     * @return true when round is Executable, false when is not
     */
    public boolean isRoundExecutable() {
        return round-- > 0;
    }

    private int validateRound(int round) {
        return Optional.of(round)
                .filter(r -> r > 0)
                .orElseThrow(() -> new IllegalArgumentException("양수를 입력해주세요."));
    }

    public int getRound() {
        return round;
    }
}
