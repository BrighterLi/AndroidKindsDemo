package com.widget.animation.textview;

import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.widget.R;


public class TextViewActivity extends AppCompatActivity {
    private TextView tvShow; //使用代码做代码
    private TextView tvShow2; //使用xml做动画

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        tvShow = findViewById(R.id.tv_show);

        combinnationToLeftRight(tvShow);
        //showRotateToRight(tvShow);
        //showBlowUpAnimation();
        //showUpDownShake();
        //showLeftRightSway(tvShow);
        /*showRotateShake11(tvShow);
        tvShow.postDelayed(new Runnable() {
            @Override
            public void run() {
                showRotateShake12(tvShow);
            }
        }, 1000);*/
        //showRotateShake2(tvShow);
        //showShake2();
        //showShake3();
        //showShake4();

        //showBlowUpAnimation();
        /*showBlowUpAnimation2();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showShake3();
            }
        }, 1000);*/

        //multiAnimation();
        //showShake3();
        //showShake4();
    }

    //补间动画从小变大
    private void showBlowUpAnimation() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.textview_blow_up);
        animation.setFillAfter(true); //结束后保存状态
        tvShow.startAnimation(animation);
    }

    //补间动画上下抖动
    private void showUpDownShake() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.textview_shake);
        tvShow.startAnimation(animation);
    }

    //补间动画
    private void combinnationToLeftRight(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.combination_to_left_righht);
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.combination_to_right_left);
        //view.startAnimation(animation);
        view.startAnimation(animation2);
    }

    //补间动画左右摆动
    private void showLeftRightSway(View view) {
        TranslateAnimation animation = new TranslateAnimation(0, -5, 0, 0);
        animation.setInterpolator(new OvershootInterpolator());
        animation.setDuration(100);
        animation.setRepeatCount(-1);
        animation.setRepeatMode(Animation.REVERSE);
        view.startAnimation(animation);
    }

    //补间动画，角度旋转,往左
    private void showRotateToLeft(View view) {
        Animation anim =new RotateAnimation(0f, -45f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        //anim.setDuration(1000); // 设置动画时间
        anim.setInterpolator(new LinearInterpolator()); // 设置插入器，控制速度
        anim.setRepeatMode(0); //重复的次数，默认为0，必须是int，可以为-1表示不停止
        //animationSet.addAnimation(anim2);
        anim.setDuration(500);
        view.startAnimation(anim);
    }

    //补间动画，角度旋转,往右
    private void showRotateToRight(View view) {
        Animation anim =new RotateAnimation(0f, 45f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        //anim.setDuration(1000); // 设置动画时间
        anim.setInterpolator(new LinearInterpolator()); // 设置插入器，控制速度
        anim.setRepeatMode(0); //重复的次数，默认为0，必须是int，可以为-1表示不停止
        //animationSet.addAnimation(anim2);
        anim.setDuration(500);
        view.startAnimation(anim);
    }

    //补间动画，角度旋转,先往左再往右
    private void showRotateShake11(View view) {
        AnimationSet animationSet = new AnimationSet(true);
        Animation anim =new RotateAnimation(0f, -45f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        Animation anim2 =new RotateAnimation(0f, 45f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        //anim.setFillAfter(true); // 设置保持动画最后的状态
        //anim.setDuration(1000); // 设置动画时间
        anim.setInterpolator(new LinearInterpolator()); // 设置插入器，控制速度
        animationSet.addAnimation(anim);
        animationSet.setRepeatMode(0); //重复的次数，默认为0，必须是int，可以为-1表示不停止
        //animationSet.addAnimation(anim2);
        animationSet.setDuration(1000);
        view.startAnimation(animationSet);
    }

    //补间动画，角度旋转,先往左再往右
    private void showRotateShake12(View view) {
        AnimationSet animationSet = new AnimationSet(true);
        Animation anim =new RotateAnimation(0f, -45f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        Animation anim2 =new RotateAnimation(0f, 45f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        //anim.setFillAfter(true); // 设置保持动画最后的状态
        //anim.setDuration(1000); // 设置动画时间
        anim.setInterpolator(new LinearInterpolator()); // 设置插入器，控制速度
        animationSet.addAnimation(anim2);
        animationSet.setRepeatMode(0); //重复的次数，默认为0，必须是int，可以为-1表示不停止
        //animationSet.addAnimation(anim2);
        animationSet.setDuration(1000);
        view.startAnimation(animationSet);
    }



    //属性动画，角度旋转
    private void showRotateShake2(View view) {
        AnimatorSet set=new AnimatorSet();
        set.playTogether(
                //ObjectAnimator.ofFloat(view,"rotationX",0,60),//绕X轴翻转
                //ObjectAnimator.ofFloat(view,"rotationY",0,60),//绕Y轴旋转
                //ObjectAnimator.ofFloat(view,"rotationY",0,-60)//绕Y轴旋转
                ObjectAnimator.ofFloat(view,"rotation",0,45),
                ObjectAnimator.ofFloat(view,"rotation",45,0),
                ObjectAnimator.ofFloat(view,"rotation",0,-45),
                ObjectAnimator.ofFloat(view,"rotation",-45,0)//绕中心点逆时针旋转
                //ObjectAnimator.ofFloat(view,"translationX",0,90),//X轴平移
                //ObjectAnimator.ofFloat(view,"translationY",0,90),//y轴平移
                //ObjectAnimator.ofFloat(view,"scaleX",1,1.5f),//X轴拉伸
                //ObjectAnimator.ofFloat(view,"scaleY",0,0.5f),//Y轴从零拉伸
                //ObjectAnimator.ofFloat(view,"alpha",1,0.25f,1)//透明度
        );
        set.setDuration(2*1000).start();//时间
    }

    //Java代码实现左右摇摆/上下摇摆动画
    private void showShake2() {
        /*TranslateAnimation animation = new TranslateAnimation(0, 0, -20, 20);
        animation.setInterpolator(new OvershootInterpolator());
        animation.setDuration(500);
        animation.setRepeatCount(1);
        animation.setRepeatMode(Animation.REVERSE);
        tvShow.startAnimation(animation);*/

        //补间动画，左右不停摇摆
        TranslateAnimation alphaAnimation2 = new TranslateAnimation(150f, 350f, 50, 50);
        alphaAnimation2.setDuration(1000); //动画持续时间
        alphaAnimation2.setRepeatCount(Animation.INFINITE);
        alphaAnimation2.setRepeatMode(Animation.REVERSE);
        tvShow.setAnimation(alphaAnimation2); //设置给控件
        alphaAnimation2.start();
    }

    private void showRotate() {

    }

    //属性动画 上下颤抖
    //https://blog.csdn.net/zhangcanyan/article/details/54896456?utm_source=blogxgwz4
    //https://github.com/lzyzsd/AndroidSeekAttention
    private void showShake3() {
        ObjectAnimator animator = tada(tvShow);
        //animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatCount(0);
        animator.start();
    }

    //属性动画 左右颤抖
    private void showShake4() {
        ObjectAnimator nopeAnimator = nope(tvShow);
        nopeAnimator.setRepeatCount(ValueAnimator.INFINITE);
        nopeAnimator.start();
    }

    public static ObjectAnimator tada(View view) {
        return tada(view, 5f);
    }

    public static ObjectAnimator tada(View view, float shakeFactor) {

        PropertyValuesHolder pvhScaleX = PropertyValuesHolder.ofKeyframe(View.SCALE_X,
                Keyframe.ofFloat(0f, 1f),
                Keyframe.ofFloat(.1f, .9f),
                Keyframe.ofFloat(.2f, .9f),
                Keyframe.ofFloat(.3f, 1.1f),
                Keyframe.ofFloat(.4f, 1.1f),
                Keyframe.ofFloat(.5f, 1.1f),
                Keyframe.ofFloat(.6f, 1.1f),
                Keyframe.ofFloat(.7f, 1.1f),
                Keyframe.ofFloat(.8f, 1.1f),
                Keyframe.ofFloat(.9f, 1.1f),
                Keyframe.ofFloat(1f, 1f)
        );

        PropertyValuesHolder pvhScaleY = PropertyValuesHolder.ofKeyframe(View.SCALE_Y,
                Keyframe.ofFloat(0f, 1f),
                Keyframe.ofFloat(.1f, .9f),
                Keyframe.ofFloat(.2f, .9f),
                Keyframe.ofFloat(.3f, 1.1f),
                Keyframe.ofFloat(.4f, 1.1f),
                Keyframe.ofFloat(.5f, 1.1f),
                Keyframe.ofFloat(.6f, 1.1f),
                Keyframe.ofFloat(.7f, 1.1f),
                Keyframe.ofFloat(.8f, 1.1f),
                Keyframe.ofFloat(.9f, 1.1f),
                Keyframe.ofFloat(1f, 1f)
        );

        PropertyValuesHolder pvhRotate = PropertyValuesHolder.ofKeyframe(View.ROTATION,
                Keyframe.ofFloat(0f, 0f),
                Keyframe.ofFloat(.1f, -3f * shakeFactor),
                Keyframe.ofFloat(.2f, -3f * shakeFactor),
                Keyframe.ofFloat(.3f, 3f * shakeFactor),
                Keyframe.ofFloat(.4f, -3f * shakeFactor),
                Keyframe.ofFloat(.5f, 3f * shakeFactor),
                Keyframe.ofFloat(.6f, -3f * shakeFactor),
                Keyframe.ofFloat(.7f, 3f * shakeFactor),
                Keyframe.ofFloat(.8f, -3f * shakeFactor),
                Keyframe.ofFloat(.9f, 3f * shakeFactor),
                Keyframe.ofFloat(1f, 0)
        );

        return ObjectAnimator.ofPropertyValuesHolder(view, pvhScaleX, pvhScaleY, pvhRotate).
                setDuration(1000);
    }

    public static ObjectAnimator nope(View view) {
        int delta = view.getResources().getDimensionPixelOffset(R.dimen.spacing_medium);

        PropertyValuesHolder pvhTranslateX = PropertyValuesHolder.ofKeyframe(View.TRANSLATION_X,
                Keyframe.ofFloat(0f, 0),
                Keyframe.ofFloat(.10f, -delta),
                Keyframe.ofFloat(.26f, delta),
                Keyframe.ofFloat(.42f, -delta),
                Keyframe.ofFloat(.58f, delta),
                Keyframe.ofFloat(.74f, -delta),
                Keyframe.ofFloat(.90f, delta),
                Keyframe.ofFloat(1f, 0f)
        );

        return ObjectAnimator.ofPropertyValuesHolder(view, pvhTranslateX).
                setDuration(500);
    }

    //属性动画 缩放
    //https://blog.csdn.net/gruhgd/article/details/84101543
    public void showBlowUpAnimation2() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(tvShow, "scaleX", 0, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(tvShow, "scaleY", 0, 1f);
        animatorSet.setDuration(1000);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.play(scaleX).with(scaleY);//两个动画同时开始
        animatorSet.start();
    }

    //多个属性动画顺序播放
    public void multiAnimation() {
        AnimatorSet animatorSet = new AnimatorSet();
        //第一个动画 放大动画
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(tvShow, "scaleX", 0, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(tvShow, "scaleY", 0, 1f);
        animatorSet.setDuration(1000);
        animatorSet.setInterpolator(new DecelerateInterpolator());

        //第二个动画，上下颤抖动画
        ObjectAnimator animator = tada(tvShow);
        animator.setRepeatCount(0);

        animatorSet.play(scaleX).with(scaleY).before(animator);//两个动画同时开始
        animatorSet.start();
    }
}

//动画执行监听
//https://blog.csdn.net/weixin_43808025/article/details/86552222