import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class RacingCars {
    private final List<Car> cars;

    public RacingCars(String cars) {
        this.cars = createCars(cars.split(","));
    }

    private List<Car> createCars(String[] names) {
        return Arrays.stream(names)
                .map(n -> new Car(n))
                .collect(Collectors.toList());
    }

    public void race() {
        cars.stream().forEach(car -> car.race());
    }

    public String selectWinners() {
        Optional<Integer> max = cars.stream().map(Car::getForward).max(Integer::compare);

        if (max.isPresent()) {
            return cars.stream()
                    .filter(car -> max.equals(Optional.of(car.getForward())))
                    .map(Car::getName)
                    .collect(Collectors.joining(","));
        }

        return null;
    }


    public List<Car> getCars() {
        return cars;
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
