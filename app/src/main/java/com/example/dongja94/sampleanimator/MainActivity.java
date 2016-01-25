package com.example.dongja94.sampleanimator;

import android.animation.ArgbEvaluator;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView messageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageView = (TextView)findViewById(R.id.text_message);

        Button btn = (Button)findViewById(R.id.btn_change);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValueAnimator anim = ValueAnimator.ofInt(Color.RED, Color.BLUE);
                anim.setEvaluator(new ArgbEvaluator());
                anim.setDuration(1000);
                anim.setRepeatCount(ValueAnimator.INFINITE);
                anim.setRepeatMode(ValueAnimator.REVERSE);
                anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int color = (Integer) animation.getAnimatedValue();
                        messageView.setTextColor(color);
                    }
                });
                anim.start();
            }
        });

        btn = (Button)findViewById(R.id.btn_object_animator);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator anim = ObjectAnimator.ofInt(messageView, "textColor", Color.RED, Color.BLUE);
                anim.setEvaluator(new ArgbEvaluator());
                anim.setDuration(1000);
                anim.setRepeatCount(ValueAnimator.INFINITE);
                anim.setRepeatMode(ValueAnimator.REVERSE);
                anim.start();
            }
        });

        btn = (Button)findViewById(R.id.btn_font_size);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float min = getResources().getDimensionPixelSize(R.dimen.text_font_min);
                float max = getResources().getDimensionPixelSize(R.dimen.text_font_max);
                ObjectAnimator anim = ObjectAnimator.ofFloat(messageView, "textSize", min, max);
                anim.setEvaluator(new FloatEvaluator());
                anim.setDuration(1000);
                anim.setRepeatCount(ValueAnimator.INFINITE);
                anim.setRepeatMode(ValueAnimator.REVERSE);
                anim.start();
            }
        });

    }
}
