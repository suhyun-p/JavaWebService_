package com.example.demo.enums;

public enum Sex {
    M("Male"),
    F("Female");
    // Key("Value");

    private String value;

    Sex(String value) {
        this.value = value;
    }

    public String getKey() {
        return name();
    }

    public String getValue() {
        return value;
    }
}
