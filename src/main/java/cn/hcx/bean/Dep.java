package cn.hcx.bean;

public class Dep {
    private int id;
    private String depName;
    private String description;

    public Dep() {
    }

    public Dep(int id, String depName, String description) {
        this.id = id;
        this.depName = depName;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Dep{" +
                "id=" + id +
                ", depName='" + depName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
