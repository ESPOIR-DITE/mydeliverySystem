package domain;

public class Beer implements Alcohol {
    private String percentage="+-12%";

    @Override
    public String percentageOfAlcohol() {
        return percentage;
    }
}
