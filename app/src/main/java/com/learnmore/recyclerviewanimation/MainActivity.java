package com.learnmore.recyclerviewanimation;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ExampleItem> exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem(R.drawable.ic_android, "Line 1", "Line 2"));
        exampleList.add(new ExampleItem(R.drawable.ic_audio, "Line 3", "Line 4"));
        exampleList.add(new ExampleItem(R.drawable.ic_sun, "Line 5", "Line 6"));
        exampleList.add(new ExampleItem(R.drawable.ic_android, "Line 7", "Line 8"));
        exampleList.add(new ExampleItem(R.drawable.ic_audio, "Line 9", "Line 10"));
        exampleList.add(new ExampleItem(R.drawable.ic_sun, "Line 11", "Line 12"));
        exampleList.add(new ExampleItem(R.drawable.ic_android, "Line 13", "Line 14"));
        exampleList.add(new ExampleItem(R.drawable.ic_audio, "Line 15", "Line 16"));
        exampleList.add(new ExampleItem(R.drawable.ic_sun, "Line 17", "Line 18"));
        exampleList.add(new ExampleItem(R.drawable.ic_android, "Line 19", "Line 20"));
        exampleList.add(new ExampleItem(R.drawable.ic_audio, "Line 21", "Line 22"));
        exampleList.add(new ExampleItem(R.drawable.ic_sun, "Line 23", "Line 24"));
        exampleList.add(new ExampleItem(R.drawable.ic_android, "Line 25", "Line 26"));
        exampleList.add(new ExampleItem(R.drawable.ic_audio, "Line 27", "Line 28"));
        exampleList.add(new ExampleItem(R.drawable.ic_sun, "Line 29", "Line 30"));

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(exampleList, this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        String s = getIntent().getStringExtra("input");
        if (s != null) {
            if (s.equals("2")) {
                runLayoutAnimationFallDown();
            }
        }
    }
    public RecyclerView getmRecyclerView(){
        return this.mRecyclerView;
    }

    private void runLayoutAnimationFallDown() {

        Context context = mRecyclerView.getContext();
        LayoutAnimationController layoutAnimationController = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down);
        mRecyclerView.setLayoutAnimation(layoutAnimationController);
        mRecyclerView.getAdapter().notifyDataSetChanged();
        mRecyclerView.scheduleLayoutAnimation();
    }

   /* void runLayoutAnimationFromBottom(RecyclerView recyclerView) {
        Context context = recyclerView.getContext();
        LayoutAnimationController layoutAnimationController = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_from_bottom);
        recyclerView.setLayoutAnimation(layoutAnimationController);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }*/


}
