package org.jcmgb.veganizer.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "substitutions")
@Access(AccessType.FIELD)
public class Substitution {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "ingredient1")
    private String ingredient1;

    public void setIngredient1(String ingredient1) {
        this.ingredient1 = ingredient1;
    }

    public String getIngredient1() {
        return this.ingredient1;
    }

    @Column(name = "ingredient2")
    private String ingredient2;

    public void setIngredient2(String ingredient2) {
        this.ingredient2 = ingredient2;
    }

    public String getIngredient2() {
        return this.ingredient2;
    }

    @Column(name = "vegansub")
    private String vegansub;

    public void setVeganSub(String vegansub) {
        this.vegansub = vegansub;
    }

    public String getVeganSub() {
        return this.vegansub;
    }

    @Column(name = "notes")
    private String notes;

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNotes() {
        return this.notes;
    }

    @Column(name = "category")
    private String category;

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return this.category;
    }
}
