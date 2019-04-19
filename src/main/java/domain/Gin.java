package domain;

public class Gin implements Alcohol {
    private String percentage="+-40%";
    @Override
    public String percentageOfAlcohol() {
        return percentage;
    }
}
