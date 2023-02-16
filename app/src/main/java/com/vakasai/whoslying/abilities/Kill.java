package com.vakasai.whoslying.abilities;

import com.vakasai.whoslying.roles.Role;

public class Kill extends Ability {
    int uses;
    int attack = 1;

    public Kill(int uses) {
        super(uses);
        this.uses = super.uses;
    }

    public Kill(int uses, int attack) {
        super(uses);
        this.uses = super.uses;
        this.attack = attack;
    }

    public void use(Role target) {
        if (target.defense < attack) {
            target.alive = false;
        }
    }
}