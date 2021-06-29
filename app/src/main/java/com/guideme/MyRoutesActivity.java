package com.guideme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ProgressBar;

import com.guideme.Model.DatabaseController;
import com.guideme.Model.FitData;

import java.util.ArrayList;

public class MyRoutesActivity extends AppCompatActivity {

    private DatabaseController database;
    private RecyclerView listView;
    private ArrayList<FitData> userRoutes;
    private ProgressBar progressBar;
    private View legend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_routes);

        String currentUserId = getIntent().getStringExtra("userId");
        legend = findViewById(R.id.legend);
        database = DatabaseController.getInstance(currentUserId);
        listView = findViewById(R.id.routeView);
        progressBar = findViewById(R.id.progressBar);
    }

    public void onClickAdd(View view) {
        startActivity(new Intent(this, ImportFileActivity.class));
    }

    public void onClickInfo(View view) {
        if(legend.getVisibility() == View.VISIBLE) {
            legend.setVisibility(View.INVISIBLE);
        } else {
            legend.setVisibility(View.VISIBLE);
        }

    }

    private void showData() {
        listView.setLayoutManager(new LinearLayoutManager(this));
        listView.setAdapter(new RouteListAdapter(userRoutes, this));
    }

    //load uploaded routes async in the Layoutmanager
    private void loadData() {
        userRoutes = new ArrayList<>();
        new Thread(() -> {
            while (userRoutes.isEmpty()) {
                userRoutes = database.getFitData();
            }

            new Handler(Looper.getMainLooper()).post(() -> {
                progressBar.setVisibility(View.INVISIBLE);
                showData();
            });
        }).start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}