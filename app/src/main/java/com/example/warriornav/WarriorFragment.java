package com.example.warriornav;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class WarriorFragment extends Fragment {

    private EditText warriorName;
    private EditText warriorHealth;
    private EditText warriorDamage;
    private EditText warriorSuperAbility;
    private Button detailButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_warrior, container, false);

        warriorName = view.findViewById(R.id.warriorName);
        warriorHealth = view.findViewById(R.id.warriorHealth);
        warriorDamage = view.findViewById(R.id.warriorDamage);
        warriorSuperAbility = view.findViewById(R.id.warriorSuperAbility);
        detailButton = view.findViewById(R.id.detailButton);

        detailButton.setOnClickListener(v -> {
            String name = warriorName.getText().toString();
            int health = Integer.parseInt(warriorHealth.getText().toString());
            int damage = Integer.parseInt(warriorDamage.getText().toString());
            String superAbility = warriorSuperAbility.getText().toString();

            Bundle bundle = new Bundle();
            bundle.putString("name", name);
            bundle.putString("superAbility", superAbility);
            bundle.putInt("health", health);
            bundle.putInt("damage", damage);

            NavHostFragment.findNavController(WarriorFragment.this)
                    .navigate(R.id.action_warriorFragment_to_warriorDetailFragment, bundle);
        });
        return view;
    }
}