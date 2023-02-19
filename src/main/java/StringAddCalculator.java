import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {
    private final static String delimiters = ",|:";

    public static int splitAndSum(String nums) {
        if(nums == null || nums.isEmpty())
            return 0;

        return sumNums(splitNums(nums));
    }

    private static String[] splitNums(String nums) {
        Matcher m = Pattern.compile("//(.+)\n(.*)").matcher(nums);

        if (m.find())
            return m.group(2).split(delimiters + "|" + customDelimiters(m.group(1)));

        return nums.split(delimiters);
    }

    private static String customDelimiters(String customDelimiters) {
        return Arrays.stream(customDelimiters.split(""))
                .collect(Collectors.joining("|"));
    }

    private static int checkNum(String num) {
        return Optional.of(Integer.parseInt(num))
                .filter(item -> item > 0)
                .orElseThrow(() -> new IllegalArgumentException("음수 넣지 마세요"));
    }

    private static int sumNums(String[] nums) {
        return Arrays.stream(nums)
                .mapToInt(num -> StringAddCalculator.checkNum(num))
                .sum();
    }
}
