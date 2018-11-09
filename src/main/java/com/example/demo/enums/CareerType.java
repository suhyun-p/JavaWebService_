package com.example.demo.enums;

public enum CareerType {
    Profile("Profile"),
    Awards("Awards"),
    Workshop("Workshop"),
    Performance("Performance"),
    Class("Class");
    // Key("Value");

    private String value;

    CareerType(String value) {
        this.value = value;
    }

    public String getKey() {
        return name();
    }

    public String getValue() {
        return value;
    }
}
