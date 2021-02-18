package com.skrrtnick.cutnburn.data;

public enum State {
    CHOPPING("Chopping"),
    EQUIPPING("Equipping"),
    BURNING("Burning"),
    WALKING("Walking"),
    BUYING("Buying"),
    COLLECTING("Collecting"),
    BANKING("Banking"),
    STARTING("Starting");

    private String name;
    State(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
