package com.mazor.galaxia;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.Nullable;

public class BottomFragment extends Fragment {

    private Button btnExplore, btnAsteroids, btnConstellations;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom, container, false);

        btnExplore = view.findViewById(R.id.btnExplore);
        btnAsteroids = view.findViewById(R.id.btnAsteroids);
        btnConstellations = view.findViewById(R.id.btnConstellations);

        btnExplore.setOnClickListener(v -> openActivity(spaceexploration_main.class));
        btnAsteroids.setOnClickListener(v -> openActivity(AsteroidActivity.class));
        btnConstellations.setOnClickListener(v -> openActivity(ConstellationActivity.class));

        return view;
    }

    private void openActivity(Class<?> activityClass) {
        Intent intent = new Intent(getActivity(), activityClass);
        startActivity(intent);
    }
}
