package org.mustafakaya.odev8.Core.Entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Product")
@Embeddable
public class ProductEntity extends BaseEntity implements Serializable {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;
    private String photoUrl;
    private String description;

    @Column(nullable = false)
    private Double price;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
