package com.vakasai.whoslying.roles;

import java.util.Map;
import java.util.ArrayList;

public class Role {
    public int defense = 0;
    public boolean alive = true;
    ArrayList<Role> informed;
    Faction faction;
    String wincon;

    public Role(String wincon, Faction faction) {
        this.wincon = wincon;
        this.faction = faction;
    }

    public Role(String wincon, Faction faction, int defense) {
        this.wincon = wincon;
        this.faction = faction;
        this.defense = defense;
    }
}