package domain;


public class Item {
    private int id;
    private String name;
    private String expireingDate;
    private char size;
    private String description;

    public Item() {
    }

    public Item(int id, String name, String expireingDate, char size, String description) {
        this.id = id;
        this.name = name;
        this.expireingDate = expireingDate;
        this.size = size;
        this.description = description;
    }

   public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpireingDate() {
        return expireingDate;
    }

    public void setExpireingDate(String expireingDate) {
        this.expireingDate = expireingDate;
    }

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", expireingDate='" + expireingDate + '\'' +
                ", size=" + size +
                ", description='" + description + '\'' +
                '}';
    }

}
