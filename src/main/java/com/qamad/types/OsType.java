package com.qamad.types;

public enum OsType {
    WIN("windows"),
    MAC("mac");

    public final String name;

    OsType(String name) {
        this.name = name;
    }
}
