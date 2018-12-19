package client.parameters;

public abstract class Filter {
    protected String name;
    protected boolean tumbler;

    public Filter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
