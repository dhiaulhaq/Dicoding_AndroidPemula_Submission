package com.example.dicoding_androidpemula_submission;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvServants;
    private ArrayList<Servant> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Home");

        rvServants = findViewById(R.id.rv_servants);
        rvServants.setHasFixedSize(true);

        list.addAll(ServantsData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvServants.setLayoutManager(new LinearLayoutManager(this));
        ListServantAdapter listServantAdapter = new ListServantAdapter(list);
        rvServants.setAdapter(listServantAdapter);

        listServantAdapter.setOnItemClickCallback(new ListServantAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Servant data) {
                showSelectedServant(data);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }
    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_about:
                break;
        }
    } */

    private void showSelectedServant(Servant servant) {
        Toast.makeText(this, "Kamu memilih " + servant.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_about) {
            startActivity(new Intent(getApplicationContext(),AboutActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
