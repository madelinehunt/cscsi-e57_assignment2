package cscie57.assignment2_1.domain;

import java.io.Serializable;

public class Category implements Serializable {

    private Long id;
    private String name;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Category - Id: " + id + ", Name: " + name;
    }
}
