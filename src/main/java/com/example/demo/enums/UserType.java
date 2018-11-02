package com.example.demo.enums;

public enum UserType {
    Normal("Normal"),
    Tutor("Tutor");
    // Key("Value");

    private String value;

    UserType(String value) {
        this.value = value;
    }

    public String getKey() {
        return name();
    }

    public String getValue() {
        return value;
    }
}
