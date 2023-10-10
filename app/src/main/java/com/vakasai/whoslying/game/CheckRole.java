package com.vakasai.whoslying.game;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.vakasai.whoslying.R;
import com.vakasai.whoslying.roles.Role;

public class CheckRole extends Fragment {
    Bundle arguments;

    public static CheckRole newInstance(Bundle args) {
        CheckRole fragment = new CheckRole();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        arguments = getArguments();
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.check_role, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        String name = arguments.getString("name");
//        String roleJSON = arguments.getString("role");
//        Gson gson = new Gson();
//        Role role = gson.fromJson(roleJSON, Role.class);
        TextView player_name = view.findViewById(R.id.player_name);
        player_name.setText(name);
        super.onViewCreated(view, savedInstanceState);
    }

}