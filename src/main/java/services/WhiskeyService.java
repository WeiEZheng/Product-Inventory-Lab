package services;

import models.Sneaker;
import models.Whiskey;

import java.util.ArrayList;
import java.util.List;

public class WhiskeyService {
    private int nextId = 1;

    private List<Whiskey> inventory = new ArrayList<>();

    public Whiskey create(String name, String brand, double alcConcentration, double size, double price, int qty) {
        Whiskey createdWhiskey = new Whiskey(nextId++, name, brand, alcConcentration, size, price, qty);
        inventory.add(createdWhiskey);
        return createdWhiskey;
    }

    public Whiskey findWhiskey(int id) {
        for (Whiskey s : inventory) {
            if (s.getId() == id)
                return s;
        }
        return null;
    }

    public Whiskey[] findAll() {
        return inventory.toArray(new Whiskey[inventory.size()]);
    }

    public boolean delete(int id) {
        for (Whiskey s : inventory) {
            if (s.getId() == id) {
                inventory.remove(s);
                return true;
            }
        }
        return false;
    }
}

