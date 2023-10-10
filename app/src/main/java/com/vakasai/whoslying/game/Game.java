package com.vakasai.whoslying.game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.google.gson.Gson;
import com.vakasai.whoslying.R;
import com.vakasai.whoslying.rolelist.Rolelist;

import java.util.ArrayList;

public class Game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Gson gson = new Gson();
            String selectedRolelistJSON = extras.getString("selectedRolelist");
            Rolelist selectedRolelist = gson.fromJson(selectedRolelistJSON, Rolelist.class);
            ArrayList<String> names = extras.getStringArrayList("names");
            selectedRolelist.shuffle();
            if (savedInstanceState == null) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.setReorderingAllowed(true);
                Bundle args = new Bundle();
//                String roleJSON = gson.toJson(selectedRolelist.get(0));
//                args.putString("role", roleJSON);
                args.putString("name", names.get(0));
                CheckRole frag = CheckRole.newInstance(args);
                transaction.add(R.id.container, frag);
                transaction.commit();
            }
        }
    }
    public void stopFragment(View view) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, new InGameRole());
        fragmentTransaction.commit();
    }
}

