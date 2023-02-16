package com.vakasai.whoslying.roles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vakasai.whoslying.R;

import java.util.ArrayList;

public class NewRoleAdapter extends RecyclerView.Adapter<NewRoleAdapter.ViewHolder> {
    Context context;
    ArrayList<TextView> roles;


    public NewRoleAdapter(Context context, ArrayList<TextView> roles) {
        this.context = context;
        this.roles = roles;
    }

    @NonNull
    @Override
    public NewRoleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inf = LayoutInflater.from(context);
        View v = inf.inflate(R.layout.new_player_item, parent, false);
        return new NewRoleAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NewRoleAdapter.ViewHolder holder, int position) {
        holder.tv.setText(roles.get(position).getText());
        holder.button.setTag(roles.get(position).getTag());
    }

    @Override
    public int getItemCount() {
        return roles.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        ImageButton button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.textView);
            button = itemView.findViewById(R.id.settings);
        }
    }
}
