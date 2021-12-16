package com.example.cookieclicker;

import android.widget.TextView;

public class Upgrade {
  public final int id;
  public final String name;
  public int price;
  public final double bonus;
  public final double bonusPerSec;
  public boolean unlocked;

  public Upgrade(int id, String name, int price, double bonus, double bonusPerSec) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.bonus = bonus;
    this.bonusPerSec = bonusPerSec;
    unlocked = false;
  }

  public String toString() {
    if (unlocked)
      return (name + " unlocked");
    return (name + " for " + price + " providing " + bonus + "/" + bonusPerSec);
  }

  public void buyUpgrade(Player player) {
    if (!unlocked && player.cookies > price) {
      player.cookies -= price;
      unlocked = true;
      player.cookiesPerClick += bonus;
      player.cookiesPerSec += bonusPerSec;
    }
  }
}
