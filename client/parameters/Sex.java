package client.parameters;

public class Sex extends Filter {

    private String sex;

    public Sex(String filterId, String sex) {
        super(filterId);
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }
}
