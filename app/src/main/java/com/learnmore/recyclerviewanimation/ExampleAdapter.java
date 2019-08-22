package com.learnmore.recyclerviewanimation;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private ArrayList<ExampleItem> mExampleList;
    private Context context;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.textView);
            mTextView2 = itemView.findViewById(R.id.textView2);
        }
    }

    public ExampleAdapter(ArrayList<ExampleItem> exampleList, Context context) {
        mExampleList = exampleList;
        this.context = context;
      }

    @Override
    public ExampleViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        final View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);


        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*try {
                    Thread.sleep(590);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                Intent intent = new Intent(context, DetailedActivity.class);
                context.startActivity(intent);
            }
        });

        return new ExampleViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        ExampleItem currentItem = mExampleList.get(position);

        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}