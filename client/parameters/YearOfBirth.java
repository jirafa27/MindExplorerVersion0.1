package client.parameters;

public class YearOfBirth extends Filter {
    private int year;
    public YearOfBirth(int year) {
        super("year");
        this.year = year;
    }

    public int getYear() {
        return year;
    }
}
