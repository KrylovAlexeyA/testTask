package com.testTask;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@javax.persistence.Entity
@Table(name = "ENTITIES")
public class Entity implements Serializable {

    @Id
    private String id;
    private String name;
    private String value;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
