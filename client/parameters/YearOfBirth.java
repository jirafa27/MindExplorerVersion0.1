package client.parameters;

public class YearOfBirth extends Filter {
    private int year;

    public YearOfBirth(String filterId, int year) {
        super(filterId);
        this.year = year;
    }

    public int getYear() {
        return year;
    }
}
