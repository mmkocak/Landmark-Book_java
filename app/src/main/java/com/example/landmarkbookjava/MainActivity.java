package com.example.landmarkbookjava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.example.landmarkbookjava.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    ArrayList<Landmark> landmarkArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        landmarkArrayList = new ArrayList<>();
        Landmark akdamar = new Landmark("Akdamar", "Türkiye", R.drawable.akdamar);
        Landmark carpanak= new Landmark("Çarpanak", "Türkiye", R.drawable.carpanak);
        Landmark collesium = new Landmark("Collesium", "Italy", R.drawable.collesium);
        Landmark ysskopru = new Landmark("Yavuz Sultan Selim Köprüsü", "Türkiye", R.drawable.yavuz_sultan_selim_koprusu);
        landmarkArrayList.add(akdamar);
        landmarkArrayList.add(carpanak);
        landmarkArrayList.add(collesium);
        landmarkArrayList.add(ysskopru);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LendmarkAdapter lendmarkAdapter = new LendmarkAdapter(landmarkArrayList);
        binding.recyclerView.setAdapter(lendmarkAdapter);
        /*
        //Adapter
         //Listview

        //Mapping
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                landmarkArrayList.stream().filter(landmark -> landmark.name != null)    .map(landmark -> landmark.name).collect(Collectors.toList())
                );
        binding.listview.setAdapter(arrayAdapter);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("landmark", landmarkArrayList.get(position));
                startActivity(intent);
            }
        });

         */


    }
}