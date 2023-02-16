package com.vakasai.whoslying.rolelist;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.vakasai.whoslying.R;

import java.util.ArrayList;

//GSON!
public class NewRolelistAdapter extends RecyclerView.Adapter<NewRolelistAdapter.ViewHolder> {
    Context context;
    ArrayList<TextView> rolelists;
    SharedPreferences pref;
    SharedPreferences.Editor pEdit;

    public NewRolelistAdapter(Context context, ArrayList<TextView> rolelists) {
        this.context = context;
        this.rolelists = rolelists;
        pref = context.getSharedPreferences("SharedPref", MODE_PRIVATE);
        pEdit = pref.edit();
    }

    @NonNull
    @Override
    public NewRolelistAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inf = LayoutInflater.from(context);
        View v = inf.inflate(R.layout.new_rolelist_item, parent, false);
        return new NewRolelistAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NewRolelistAdapter.ViewHolder holder, int position) {
        holder.tv.setText(rolelists.get(position).getText());
        holder.itemView.setOnClickListener((View v) -> {
            holder.itemView.setBackgroundColor(Color.parseColor("#424040"));
            Gson gson = new Gson();
            String json = gson.toJson(holder.tv.getTag());
            pEdit.putString("selectedRolelist", json);
            pEdit.commit();
        });
    }


    @Override
    public int getItemCount() {
        return rolelists.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.textView);
        }

    }
}
