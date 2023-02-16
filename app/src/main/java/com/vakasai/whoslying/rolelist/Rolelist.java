package com.vakasai.whoslying.rolelist;

import com.vakasai.whoslying.roles.Role;

import java.util.ArrayList;
import java.util.Collections;

public class Rolelist {
    ArrayList<Role> rolelist;

    public void add(Role role) {
        rolelist.add(role);
    }

    public void shuffle() {
        Collections.shuffle(rolelist);
    }
}
