package domain;


import org.springframework.context.annotation.Bean;

public class Cashier {
    private String name;
    private String surName;
    private int id;

    public Cashier() {
    }

    public Cashier(String name, String surName, int id) {
        this.name = name;
        this.surName = surName;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName() {
        this.surName = surName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cashier{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", id=" + id +
                '}';
    }
    public @Bean Cashier getCashier()
    {
        return new Cashier();
    }
}
