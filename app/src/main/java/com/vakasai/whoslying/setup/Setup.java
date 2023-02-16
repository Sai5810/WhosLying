package com.vakasai.whoslying.setup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vakasai.whoslying.R;

import java.util.ArrayList;

public class Setup extends AppCompatActivity {
    ArrayList<TextView> names = new ArrayList<>();
    NewPlayerAdapter adapter;
    RecyclerView recView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setup);
        recView = findViewById(R.id.player_list);
        adapter = new NewPlayerAdapter(this, names);
        recView.setAdapter(adapter);
        recView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void launchSettings(View v) {
        Intent intent = new Intent(this, Settings.class);
        Setup.this.startActivity(intent);
    }

    public void addPlayer(View view) {
        EditText et = findViewById(R.id.addplayeret);
        TextView tv = new TextView(this);
        tv.setTextColor(ContextCompat.getColor(this, R.color.white));
        tv.setText(et.getText());
        tv.setTag("" + (names.size()));
        names.add(tv);
        adapter.notifyItemInserted(names.size());
    }

    public void delPlayer(View view) {
        int idx = Integer.parseInt(view.getTag().toString());
        names.remove(idx);
        adapter.notifyItemRemoved(names.size());
        for (int i = idx; i < names.size(); i++) {
            names.get(i).setTag("" + (i));
        }
    }

//    public void startGame() {
//
//    }
}
