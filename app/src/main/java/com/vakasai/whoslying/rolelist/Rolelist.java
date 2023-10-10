package com.vakasai.whoslying.rolelist;

import com.vakasai.whoslying.roles.Role;

import java.util.ArrayList;
import java.util.Collections;

public class Rolelist {
    ArrayList<Role> rolelist;
    public Rolelist() {
        rolelist = new ArrayList<>();
    }
    public void add(Role role) {
        rolelist.add(role);
    }

    public void shuffle() {
        Collections.shuffle(rolelist);
    }

    public Role get(int index) {
        if (index < rolelist.size()) {
            return rolelist.get(index);
        }
        return null;
    }

    public int size() {
        return rolelist.size();
    }
}
