package com.example.lutemonapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView txtHomeCount, txtTrainingCount, txtBattleCount;

    @Override
    protected void onResume() {
        super.onResume();
        updateCounts();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 加载保存的数据
        Storage.getInstance().loadData(getApplicationContext());

        txtHomeCount = findViewById(R.id.txtHomeCount);
        txtTrainingCount = findViewById(R.id.txtTrainingCount);
        txtBattleCount = findViewById(R.id.txtBattleCount);

        Button btnViewHome = findViewById(R.id.btnViewHome);
        Button btnViewTraining = findViewById(R.id.btnViewTraining);
        Button btnViewBattle = findViewById(R.id.btnViewBattle);
        Button btnCreate = findViewById(R.id.btnCreate);
        Button btnViewStatistics = findViewById(R.id.btnViewStatistics);

        // 新增按钮：保存与加载
        Button btnSave = findViewById(R.id.btnSaveData);
        Button btnLoad = findViewById(R.id.btnLoadData);

        btnViewHome.setOnClickListener(v -> startActivity(new Intent(this, LutemonListActivity.class)));
        btnViewTraining.setOnClickListener(v -> startActivity(new Intent(this, TrainingActivity.class)));
        btnViewBattle.setOnClickListener(v -> startActivity(new Intent(this, BattleActivity.class)));
        btnCreate.setOnClickListener(v -> startActivity(new Intent(this, CreateLutemonActivity.class)));
        btnViewStatistics.setOnClickListener(v -> startActivity(new Intent(this, StatisticsActivity.class)));

        // 新增点击事件
        btnSave.setOnClickListener(v -> {
            Storage.getInstance().saveData(getApplicationContext());
            Toast.makeText(this, "Lutemon data saved!", Toast.LENGTH_SHORT).show();
        });

        btnLoad.setOnClickListener(v -> {
            Storage.getInstance().loadData(getApplicationContext());
            updateCounts(); // 刷新显示
            Toast.makeText(this, "Lutemon data loaded!", Toast.LENGTH_SHORT).show();
        });

        updateCounts();
    }

    private void updateCounts() {
        int home = Storage.getInstance().getLutemonsByArea("home").size();
        int training = Storage.getInstance().getLutemonsByArea("training").size();
        int battle = Storage.getInstance().getLutemonsByArea("battle").size();

        txtHomeCount.setText("You have " + home + " Lutemons at home");
        txtTrainingCount.setText("You have " + training + " Lutemon training");
        txtBattleCount.setText("You have " + battle + " Lutemons ready");
    }
}


