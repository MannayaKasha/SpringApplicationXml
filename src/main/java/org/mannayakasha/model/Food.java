package org.mannayakasha.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "food")
public class Food {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "fats")
    private Double fats;

    @Column(name = "proteins")
    private Double proteins;

    @Column(name = "carbohydrates")
    private Double carbohydrates;

    @Column(name = "calories")
    private Integer calories;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id  = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getFats() {
        return fats;
    }

    public void setFats(Double fats) {
        this.fats = fats;
    }

    public Double getProteins() {
        return proteins;
    }

    public void setProteins(Double proteins) {
        this.proteins = proteins;
    }

    public Double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fats=" + fats +
                ", proteins=" + proteins +
                ", carbohydrates=" + carbohydrates +
                ", calories=" + calories +
                '}';
    }
}
