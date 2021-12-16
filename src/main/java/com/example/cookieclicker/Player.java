package com.example.cookieclicker;

public class Player {
  public int cookies = 0;
  public double cookiesDouble = 0;
  public double cookiesPerSec = 0;
  public double cookiesPerClick = 1;

  public void addCookies() {
    cookiesDouble += cookiesPerClick;
    cookies = (int) cookiesDouble;
  }

  public void addCookiesPerSec() {
    cookiesDouble += cookiesPerSec;
    cookies = (int) cookiesDouble;
  }
}
