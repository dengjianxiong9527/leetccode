package com.example.mydemo.anima;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mydemo.R;

/**
 * @author jianxiong.deng
 * @date 2021/1/29
 * @des
 */
class AnimationActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mButton;
    public static final String TAG = "AnimationTest";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_layout);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        ValueAnimator valueAnimator = ObjectAnimator.ofFloat(mButton, "alpha", 1.0f, 0f);
        valueAnimator.setDuration(100);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.d(TAG, "onAnimationUpdate: " + animation.getAnimatedValue());
            }
        });
        valueAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.d(TAG, "onAnimationStart: ");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d(TAG, "onAnimationEnd: ");
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.d(TAG, "onAnimationCancel: ");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.d(TAG, "onAnimationRepeat: ");
            }
        });
        valueAnimator.start();
    }
}
