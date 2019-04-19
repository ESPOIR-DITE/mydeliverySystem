package domain;

public class wine implements Alcohol {
    String percentage="+-15%";
    @Override
    public String percentageOfAlcohol() {
        return percentage;
    }
}
