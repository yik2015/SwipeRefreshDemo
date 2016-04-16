package com.hema.www.superswiperefreshdemo;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SuperSwipeRefreshLayout swipeRefreshLayout;

    TextView text;
    ImageView img;

//    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = (SuperSwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);

        View head = LayoutInflater.from(this).inflate(R.layout.layout_head, null);

        text = (TextView) head.findViewById(R.id.refresh_text);
        img = (ImageView) head.findViewById(R.id.refresh_img);

        text.setText("下拉刷新");
//        img.setImageResource(R.drawable.pull_header1);

//        img.setBackgroundResource(R.drawable.pullrefanim);
        img.setImageResource(R.drawable.pullrefanim);
//        final AnimationDrawable animationDrawable = (AnimationDrawable) img.getBackground();
        final AnimationDrawable animationDrawable = (AnimationDrawable) img.getDrawable();

        swipeRefreshLayout.setHeaderView(head);

        final Handler imgSwitchHandler = new Handler();

        final Runnable imgswitchtask = new Runnable() {
            @Override
            public void run() {
//                if (count >= 3) count = count % 3;
//                switch (count) {
//                    case 0:
//                        img.setImageResource(R.drawable.pull_header1);
//                        break;
//                    case 1:
//                        img.setImageResource(R.drawable.pull_header2);
//                        break;
//                    case 2:
//                        img.setImageResource(R.drawable.pull_header3);
//                        break;
//                }
                animationDrawable.start();

                // each anim costs 600 ms, total 3 brings 1800.
                imgSwitchHandler.postDelayed(this, 1800);
//                count++;
            }
        };

        swipeRefreshLayout.setOnPullRefreshListener(new SuperSwipeRefreshLayout.OnPullRefreshListener() {
            @Override
            public void onRefresh() {
                text.setText("疯狂加载中...");
                imgSwitchHandler.postDelayed(imgswitchtask, 0);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                        imgSwitchHandler.removeCallbacks(imgswitchtask);
                        animationDrawable.stop();
                    }
                }, 6000);
            }

            @Override
            public void onPullDistance(int distance) {

            }

            @Override
            public void onPullEnable(boolean enable) {
                text.setText(enable ? "松开刷新" : "下拉刷新");
            }
        });
    }
}
