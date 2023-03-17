package org.jcmgb.veganizer.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "recipes")
@Access(AccessType.FIELD)
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    @Column(name = "ingredients")
    private String ingredients;

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getIngredients() {
        return this.ingredients;
    }

    @Column(name = "steps")
    private String steps;

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public String getSteps() {
        return this.steps;
    }

    @Column(name = "veganized")
    private String veganized;

    public void setVeganized(String veganized) {
        this.veganized = veganized;
    }

    public String getVeganized() {
        return this.veganized;
    }

    @Column(name = "count")
    private int count;

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }
}
