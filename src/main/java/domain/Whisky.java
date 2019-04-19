package domain;

public class Whisky implements Alcohol {

    private String percentage="42%";
    @Override
    public String percentageOfAlcohol() {
        return percentage;
    }
}
