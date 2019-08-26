package com.learnmore.recyclerviewanimation;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private ArrayList<ExampleItem> mExampleList;
    private Context context;

    OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    static class ExampleViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView mTextView1;
        TextView mTextView2;

        ExampleViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.textView);
            mTextView2 = itemView.findViewById(R.id.textView2);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }

                }
            });

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
                setAnimation(parent);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(context, DetailedActivity.class);
                        context.startActivity(intent);
                    }
                }, 0);
            }
        });

        return new ExampleViewHolder(v, mListener);
    }

    private void setAnimation(View viewToAnimate) {
        // If the bound view wasn't previously displayed on screen, it's animated

        Animation animation = AnimationUtils.loadAnimation(context, R.anim.item_animation_from_bottom);
        viewToAnimate.startAnimation(animation);


    }


    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        ExampleItem currentItem = mExampleList.get(position);

        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());

        if (position == 0) {
            holder.itemView.setBackgroundColor(Color.parseColor("#567845"));
        }
        if (position == 1) {
            holder.itemView.setBackgroundColor(Color.parseColor("#39FF33"));
        }
        if (position == 2) {
            holder.itemView.setBackgroundColor(Color.parseColor("#4633FF"));
        }
        if (position == 3) {
            holder.itemView.setBackgroundColor(Color.parseColor("#AF33FF"));
        }
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }


}