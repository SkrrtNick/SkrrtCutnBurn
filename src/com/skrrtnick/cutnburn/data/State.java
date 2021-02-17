package com.skrrtnick.cutnburn.data;

public enum State {
    CHOPPING("Chopping"),
    BURNING("Burning"),
    WALKING("Walking"),
    STARTING("Starting");

    private String name;
    State(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
