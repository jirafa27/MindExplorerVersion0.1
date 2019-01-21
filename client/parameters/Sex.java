package client.parameters;

public class Sex extends Filter {
    /*Может лучше заменить на String? Так проще в будущем будет разобраться где Male, а где Female
    и не будет непонятных true и false.
     */
    private String sex;

    public Sex(String filterId, String sex) {
        super(filterId);
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }
}
