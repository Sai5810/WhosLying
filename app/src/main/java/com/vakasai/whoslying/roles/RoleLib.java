package com.vakasai.whoslying.roles;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.vakasai.whoslying.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class RoleLib extends AppCompatActivity {
    ArrayList<TextView> roleViews = new ArrayList<>();
    NewRoleAdapter adapter;
    RecyclerView recView;
    SharedPreferences pref;
    SharedPreferences.Editor pEdit;
    HashMap<String, Role> roles = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.role_lib);
        pref = getSharedPreferences("SharedPref", MODE_PRIVATE);
        pEdit = pref.edit();
        recView = findViewById(R.id.player_list);
        initDefaults();
        adapter = new NewRoleAdapter(this, roleViews);
        recView.setAdapter(adapter);
        recView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void launchAddRole(View view) {
        Intent intent = new Intent(this, AddRole.class);
        RoleLib.this.startActivity(intent);
    }

    public void initDefaults() {
//        TextView tv = new TextView(this);
//        tv.setTextColor(ContextCompat.getColor(this, R.color.white));
//        tv.setText(R.string.innocent);
//        tv.setTag(innocent);
//        roleViews.add(tv);
//        TextView tv2 = new TextView(this);
//        tv2.setTextColor(ContextCompat.getColor(this, R.color.white));
//        tv2.setText(R.string.mafioso);
//        tv2.setTag(mafioso);
//        roleViews.add(tv2);
    }
}
