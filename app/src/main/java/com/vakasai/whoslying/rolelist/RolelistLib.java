package com.vakasai.whoslying.rolelist;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.vakasai.whoslying.R;
import com.vakasai.whoslying.roles.Role;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

public class RolelistLib extends AppCompatActivity {

    ArrayList<TextView> rolelists = new ArrayList<>();
    NewRolelistAdapter adapter;
    RecyclerView recView;
    SharedPreferences pref;
    SharedPreferences.Editor pEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rolelist_lib);
        pref = getSharedPreferences("SharedPref", MODE_PRIVATE);
        pEdit = pref.edit();
        recView = findViewById(R.id.list);
        initDefaults();
        adapter = new NewRolelistAdapter(this, rolelists);
        recView.setAdapter(adapter);
        recView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void launchAddRolelist(View view) {
        Intent intent = new Intent(this, AddRolelist.class);
        RolelistLib.this.startActivity(intent);
    }

    public void initDefaults() {
        Rolelist classicMafia = new Rolelist();
        String json = pref.getString("roles", "");
        Type type = new TypeToken<HashMap<String, Role>>() {
        }.getType();
        Gson gson = new Gson();
        HashMap<String, Role> roles = gson.fromJson(json, type);
        for (int i = 0; i < 2; ++i) {
            classicMafia.add(roles.get("Innocent"));
        }
        classicMafia.add(roles.get("Mafioso"));
        TextView tv = new TextView(this);
        tv.setTextColor(ContextCompat.getColor(this, R.color.white));
        tv.setText(R.string.classicmafia);
        tv.setTag(classicMafia);
        rolelists.add(tv);
    }

}
