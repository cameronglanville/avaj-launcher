package avaj.launcher;

import java.util.*;

public abstract class Tower {

    //private List<Flyable> observers = new ArrayList<Flyable>(); if I need to initialize
    private List<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable) {
        observers.add(flyable); // may need more
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable); // may need more
    }

    protected void conditionsChanged() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).updateConditions();
        }
    }

}
