package com.example.dicoding_androidpemula_submission;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    private RecyclerView rvServants;
    private ArrayList<Servant> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Detail");

        rvServants = findViewById(R.id.rv_servants_detail);
        rvServants.setHasFixedSize(true);

        list.addAll(ServantsData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvServants.setLayoutManager(new LinearLayoutManager(this));
        ListServantAdapter listServantAdapter = new ListServantAdapter(list);
        rvServants.setAdapter(listServantAdapter);
    }
}
