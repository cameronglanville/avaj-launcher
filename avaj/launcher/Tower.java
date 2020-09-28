package avaj.launcher;

import java.util.ArrayList;

public abstract class Tower {

    //private List<Flyable> observers = new ArrayList<Flyable>(); if I need to initialize
    private ArrayList<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable) {
        observers.add(flyable); // may need more
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable); // may need more
    }

    protected void conditionsChanged() {
        for (int i = observers.size() - 1; i >= 0; i--) {
            observers.get(i).updateConditions();
        }
    }

}
