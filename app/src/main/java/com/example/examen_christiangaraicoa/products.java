package com.example.examen_christiangaraicoa;

import java.util.Objects;

public class products {
    private int id;
    private String name;
    private String price;
    private String avatar;
    private String created_at;
    private String updated_at;

    public products(int id, String name, String price, String avatar, String created_at, String updated_at) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.avatar = avatar;
        this.created_at = created_at;
        this.updated_at = updated_at;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        products products = (products) o;
        return getId() == products.getId() && Objects.equals(getName(), products.getName()) && Objects.equals(getPrice(), products.getPrice()) && Objects.equals(getAvatar(), products.getAvatar()) && Objects.equals(getCreated_at(), products.getCreated_at()) && Objects.equals(getUpdated_at(), products.getUpdated_at());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPrice(), getAvatar(), getCreated_at(), getUpdated_at());
    }
}
