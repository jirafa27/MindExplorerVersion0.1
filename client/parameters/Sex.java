package client.parameters;

public class Sex extends Filter {
    private boolean sex;

    public Sex (boolean sex) {
        super("sex");
        this.sex = sex;
    }

    public boolean getSex() {
        return sex;
    }
}
