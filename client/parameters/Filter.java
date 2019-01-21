package client.parameters;

public abstract class Filter {

    private String filterId;
    private boolean tumbler;

    public Filter(String filterId) {
        this.filterId = filterId;
    }

    public String getFilterId() {
        return filterId;
    }
}
