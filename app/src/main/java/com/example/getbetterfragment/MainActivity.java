package com.example.getbetterfragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewHabits;
    ArrayList<HabitConstructor> habitConstructors = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerViewHabits = findViewById(R.id.recyclerViewHabits);
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        bottomNav.setOnNavigationItemSelectedListener(navListner);

        habitConstructors.add(new HabitConstructor("Здоровье", "Пить воду", "Каждый день"));
        habitConstructors.add(new HabitConstructor("Сопрт", "Бег", "Каждый день"));
        habitConstructors.add(new HabitConstructor("Учеба", "Android", "Каждый день"));

    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListner =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    Fragment fragment;

                    switch (item.getItemId()) {
                        case R.id.miLessons:
                            selectedFragment = new LessonsFragment();
                            break;
                        case R.id.miShopping:
                            selectedFragment = new ShoppingFragment();
                            break;
                        case R.id.miStatistics:
                            selectedFragment = new StatisticsFragment();
                            break;
                        case R.id.miHome:
                            selectedFragment = new HomeFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, selectedFragment).commit();

                    return true;
                }
            };

    public void showAddButton(View view) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, new AddHabitFragment(), AddHabitFragment.TAG)
                .commit();

    }
}