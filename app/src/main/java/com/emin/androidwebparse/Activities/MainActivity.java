package com.emin.androidwebparse.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.emin.androidwebparse.Adapters.RecyclerAdapter;
import com.emin.androidwebparse.BackgroundTasks.ParseWebPage;
import com.emin.androidwebparse.Models.RowItem;
import com.emin.androidwebparse.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  RecyclerAdapter recyclerAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    RecyclerView recyclerView = findViewById(R.id.recyclerView);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    ArrayList<RowItem> itemList = null;
    try {
      itemList = new ParseWebPage().execute().get();
    } catch (Exception e) {
      e.printStackTrace();
    }

    recyclerAdapter = new RecyclerAdapter(itemList);

    recyclerView.setAdapter(recyclerAdapter);
    recyclerAdapter.notifyDataSetChanged();
  }
}
