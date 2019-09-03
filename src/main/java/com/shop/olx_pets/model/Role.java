package com.shop.olx_pets.model;

public enum Role{

    ADMIN("A"),
    MANAGER("M"),
    USER("U"),
    GUEST("G");

    private String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
