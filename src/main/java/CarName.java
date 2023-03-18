public class CarName {
    private String name;

    public CarName(String name) {
        this.name = checkValidName(name);
    }

    private String checkValidName(String name) {
        if(name == null || name.equals("") || name.length() > 5)
            throw new RuntimeException();

        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
