package org.example;

import java.io.Serializable;
import java.util.UUID;

public class Toy  {
    public int id;
    public String name;
    public int quantity;

    public Toy(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
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

    public int getWeight() {
        return quantity;
    }

    public void setWeight(int weight) {
        if (weight >= 0 && weight <= 10) {
            this.quantity = quantity;
        } else throw new RuntimeException("Введено неверное значение вероятности выпадения");
    }

    @Override
    public String toString() {
        return name;
    }
}
