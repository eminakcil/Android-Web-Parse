package com.emin.androidwebparse.Models;

public class RowItem {
  String title;
  String image;

  public RowItem(String title, String image) {
    this.title = title;
    this.image = image;
  }

  public String getTitle() {
    return title;
  }

  public String getImage() {
    return image;
  }
}
