package com.emin.androidwebparse.BackgroundTasks;

import android.os.AsyncTask;

import com.emin.androidwebparse.Models.RowItem;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class ParseWebPage extends AsyncTask<Void, Void, ArrayList<RowItem>> {
  @Override
  protected void onPreExecute() {
    //İşlemler başlamadan önce
    super.onPreExecute();

  }

  @Override
  protected ArrayList<RowItem> doInBackground(Void... voids) {
    ArrayList<RowItem> itemList = new ArrayList<>();

    String link = "https://www.ntv.com.tr/son-dakika";
    try {
      Document doc = Jsoup.connect(link).get();
      Elements news = doc.select(".gallery-page-video-list-item");

      for (Element item : news) {
        String title = item.select(".card-text a").attr("data-news-title");
        String imagePath = item.select("picture source").attr("srcset");

        itemList.add(new RowItem(title,imagePath));
      }
    } catch (Exception e) {
      e.printStackTrace();

    }
    return itemList;

  }

  @Override
  protected void onPostExecute(ArrayList<RowItem> itemList) {
    //doInBacground return değeri döndürdüğünde
    /* Arka plandaki işlemden gelen bir veri ön yüzde gösterilmek isteniyorsa
     * bu metod içinde gösterim işlemi yapılabilir.*/
    super.onPostExecute(itemList);
  }

  @Override
  protected void onCancelled() {
    super.onCancelled();
    System.out.println("İptal Edildi");

  }
}
