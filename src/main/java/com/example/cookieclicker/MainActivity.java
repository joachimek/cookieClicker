package com.example.cookieclicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  ImageView Cookie;
  TextView Stats;
  ListView Upgrades;
  Upgrade[] upgrades = {
          new Upgrade(0, "Upgrade0", 1, 0.5, 0),
          new Upgrade(1, "Upgrade1", 1, 0, 0.5),
          new Upgrade(2, "Upgrade2", 10, 100, 0),
          new Upgrade(3, "Upgrade3", 10, 0, 1),
          new Upgrade(4, "Upgrade4", 100, 0, 0),
          new Upgrade(5, "Upgrade5", 100, 0, 100),
          new Upgrade(6, "Upgrade6", 1000, 0, 1000),
          new Upgrade(7, "Upgrade7", 10000, 10, 10),
          new Upgrade(8, "Upgrade8", 100000, 10000, 10),
          new Upgrade(9, "Upgrade9", 1000000, 0, 10000),
          new Upgrade(10, "Upgrade10", 10000000, 0, 0),
  };

  private void generateUpgradeList(Upgrade[] list) {
    ArrayList<String> upgradesAL = new ArrayList<>();
    for (Upgrade upgrade : list) {
      upgradesAL.add(upgrade.toString());
    }
    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, upgradesAL);
    Upgrades.setAdapter(arrayAdapter);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Player player = new Player();

    Cookie = findViewById(R.id.Cookie);
    Stats = findViewById(R.id.Stats);
    Upgrades = findViewById(R.id.Upgrades);

    Stats.setText(player.cookies + " cookies!");

    generateUpgradeList(upgrades);

    Cookie.setOnClickListener(v -> {
      player.addCookies();
      Stats.setText(player.cookies + " cookies!");
    });

    Upgrades.setOnItemClickListener((parent, view, position, id) -> {
      upgrades[(int) id].buyUpgrade(player);
      Stats.setText(player.cookies + " cookies!");
      generateUpgradeList(upgrades);
    });

    new CountDownTimer(Long.MAX_VALUE, 1000) {
      @Override
      public void onTick(long millisUntilFinished) {
        player.addCookiesPerSec();
        Stats.setText(player.cookies + " cookies!");
      }

      @Override
      public void onFinish() {
      }
    }.start();
  }
}