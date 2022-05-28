package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> array_noms = new ArrayList<String>();
        array_noms.add("Luke Skywalker");
        array_noms.add("Leia Organa");
        array_noms.add("Chewbacca");
        array_noms.add("C3P0");
        array_noms.add("R2D2");
        array_noms.add("Darth Vader");
        array_noms.add("Han Solo");
        array_noms.add("Luke Skywalker");
        array_noms.add("Leia Organa");
        array_noms.add("Chewbacca");
        array_noms.add("C3P0");
        array_noms.add("R2D2");
        array_noms.add("Darth Vader");
        array_noms.add("Han Solo");
        array_noms.add("Luke Skywalker");
        array_noms.add("Leia Organa");
        array_noms.add("Chewbacca");
        array_noms.add("C3P0");
        array_noms.add("R2D2");
        array_noms.add("Darth Vader");
        array_noms.add("Han Solo");



        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(array_noms);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager((this)));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }
}