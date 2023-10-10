package com.vakasai.whoslying;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.vakasai.whoslying.game.InGameRole;
import com.vakasai.whoslying.rolelist.Rolelist;
import com.vakasai.whoslying.rolelist.RolelistLib;
import com.vakasai.whoslying.roles.Faction;
import com.vakasai.whoslying.roles.Role;
import com.vakasai.whoslying.roles.RoleLib;
import com.vakasai.whoslying.setup.Setup;

import java.lang.reflect.Type;
import java.util.HashMap;

public class MainMenu extends AppCompatActivity {
    SharedPreferences pref;
    SharedPreferences.Editor pEdit;
    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDefaultRoles();
        initDefaultRolelist();
    }

    public void launchSetup(View view) {
        Intent intent = new Intent(this, Setup.class);
        MainMenu.this.startActivity(intent);
    }

    public void launchRolelistLib(View view) {
        Intent intent = new Intent(this, RolelistLib.class);
        MainMenu.this.startActivity(intent);
    }

    public void launchRoleLib(View view) {
        Intent intent = new Intent(this, RoleLib.class);
        MainMenu.this.startActivity(intent);
    }

    public void initDefaultRoles() {
        pref = getSharedPreferences("SharedPref", MODE_PRIVATE);
        pEdit = pref.edit();
        HashMap<String, Role> roles = new HashMap<>();
        Faction inno = new Faction(false);
        Role innocent = new Role("Last Faction", inno);
        roles.put("Innocent", innocent);
        Faction mafia = new Faction(true);
        Role mafioso = new Role("Last Faction", mafia);
        roles.put("Mafioso", mafioso);
        String json = gson.toJson(roles);
        pEdit.putString("roles", json);
        pEdit.apply();
    }

    public void initDefaultRolelist() {
        Rolelist classicMafia = new Rolelist();
        String json = pref.getString("roles", "");
        Type type = new TypeToken<HashMap<String, Role>>() {
        }.getType();
        HashMap<String, Role> roles = gson.fromJson(json, type);
        for (int i = 0; i < 2; ++i) {
            classicMafia.add(roles.get("Innocent"));
        }
        classicMafia.add(roles.get("Mafioso"));
        String json2 = gson.toJson(classicMafia);
        pEdit.putString("selectedRolelist", json2);
        pEdit.commit();
    }


}