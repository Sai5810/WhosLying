package com.vakasai.whoslying.setup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.vakasai.whoslying.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NewPlayerAdapter extends RecyclerView.Adapter<NewPlayerAdapter.ViewHolder> {
    Context context;
    ArrayList<TextView> players;


    public NewPlayerAdapter(Context context, ArrayList<TextView> players) {
        this.context = context;
        this.players = players;
    }

    @NonNull
    @Override
    public NewPlayerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inf = LayoutInflater.from(context);
        View v = inf.inflate(R.layout.new_player_item, parent, false);
        return new NewPlayerAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NewPlayerAdapter.ViewHolder holder, int position) {
        holder.tv.setText(players.get(position).getText());
        holder.button.setTag(players.get(position).getTag());
    }

    @Override
    public int getItemCount() {
        return players.size();
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
