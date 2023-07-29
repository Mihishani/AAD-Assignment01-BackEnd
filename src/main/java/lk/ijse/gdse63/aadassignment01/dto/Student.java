package lk.ijse.gdse63.aadassignment01.dto;

public class Student {
    private String id;
    private String name;
    private String city;
    private String email;
    private Integer level;

    public Student() {
    }

    public Student(String id, String name, String city, String email, Integer level) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.email = email;
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                ", level=" + level +
                '}';
    }
}
