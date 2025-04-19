package com.example.lutemonapp;

import android.content.Context;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class Storage implements Serializable {
    private static final long serialVersionUID = 1L;

    private static Storage instance = null;

    private HashMap<Integer, Lutemon> home = new HashMap<>();
    private HashMap<Integer, Lutemon> training = new HashMap<>();
    private HashMap<Integer, Lutemon> battle = new HashMap<>();

    private Storage() {}

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    public void addLutemonToHome(Lutemon lutemon) {
        home.put(lutemon.getId(), lutemon);
        StatisticsManager.getInstance().incrementCreated();
    }

    public void moveLutemon(int id, String from, String to) {
        Lutemon l = null;
        if (from.equals("home")) {
            l = home.remove(id);
        } else if (from.equals("training")) {
            l = training.remove(id);
        } else if (from.equals("battle")) {
            l = battle.remove(id);
        }

        if (l != null) {
            if (to.equals("home")) {
                home.put(id, l);
            } else if (to.equals("training")) {
                training.put(id, l);
            } else if (to.equals("battle")) {
                battle.put(id, l);
            }
        }
    }

    public HashMap<Integer, Lutemon> getHome() {
        return home;
    }

    public HashMap<Integer, Lutemon> getTraining() {
        return training;
    }

    public HashMap<Integer, Lutemon> getBattle() {
        return battle;
    }

    public void saveData(Context context) {
        try {
            FileOutputStream fos = context.openFileOutput("lutemon_data.dat", Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(instance);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadData(Context context) {
        try {
            FileInputStream fis = context.openFileInput("lutemon_data.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            instance = (Storage) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public HashMap<Integer, Lutemon> getLutemonsByArea(String area) {
        switch (area) {
            case "home":
                return home;
            case "training":
                return training;
            case "battle":
                return battle;
            default:
                return new HashMap<>();
        }
    }
    public List<Lutemon> getAllLutemons() {
        List<Lutemon> all = new ArrayList<>();
        all.addAll(home.values());
        all.addAll(training.values());
        all.addAll(battle.values());
        return all;
    }


}



