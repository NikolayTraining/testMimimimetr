package db.pojo;

public class TableMimimi {

    private int id;
    private String picture;
    private String name_picture;
    private int counter;


    public TableMimimi() {}

    public TableMimimi(int id) {
        this.id = id;
    }

    public TableMimimi(int id, String picture, String name_picture, int counter) {
        this.id = id;
        this.picture = picture;
        this.name_picture = name_picture;
        this.counter = counter;
    }

    @Override
    public String toString() {
        return "TableMimimi{" +
                "id=" + id +
                ", picture='" + picture + '\'' +
                ", name_picture='" + name_picture + '\'' +
                ", counter=" + counter +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setName_picture(String name_picture) {
        this.name_picture = name_picture;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getId() {
        return id;
    }

    public String getPicture() {
        return picture;
    }

    public String getName_picture() {
        return name_picture;
    }

    public int getCounter() {
        return counter;
    }
}
