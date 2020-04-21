package com.emin.androidwebparse.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.emin.androidwebparse.Models.RowItem;
import com.emin.androidwebparse.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.PostHolder> {
  private ArrayList<RowItem> itemList;

  public RecyclerAdapter(ArrayList<RowItem> itemList) {
    this.itemList = itemList;
  }

  @NonNull
  @Override
  public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

    LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
    View view = layoutInflater.inflate(R.layout.recycler_row,parent,false);

    return new PostHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull PostHolder holder, int position) {
    RowItem currentItem = itemList.get(position);
    holder.textView.setText(currentItem.getTitle());
    //setBitmap
    Picasso.get().load(currentItem.getImage()).into(holder.imageView);
  }

  @Override
  public int getItemCount() {
    return itemList.size();
  }

  class PostHolder extends RecyclerView.ViewHolder{

    TextView textView;
    ImageView imageView;

    public PostHolder(@NonNull View itemView) {
      super(itemView);

      imageView = itemView.findViewById(R.id.recyclerview_row_imageView);
      textView = itemView.findViewById(R.id.recyclerview_row_textView);

    }
  }
}
