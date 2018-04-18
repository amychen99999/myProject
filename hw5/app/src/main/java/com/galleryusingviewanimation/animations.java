package com.galleryusingviewanimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.AlphaAnimation;

public class animations {
    AnimationSet alphaIn()
    {
        Animation amAlpha = new AlphaAnimation(0.0f, 1.0f);
        amAlpha.setDuration(2000);
        amAlpha.setRepeatCount(0);
        AnimationSet amSet = new AnimationSet(false);
        amSet.addAnimation(amAlpha);
        return amSet;
    }

    AnimationSet alphaOut()
    {
        Animation amAlpha = new AlphaAnimation(1.0f, 0.0f);
        amAlpha.setDuration(2000);
        amAlpha.setRepeatCount(0);
        AnimationSet amSet = new AnimationSet(false);
        amSet.addAnimation(amAlpha);
        return amSet;
    }

    AnimationSet scaleRotateIn()
    {
        Animation amRotate = new RotateAnimation(0.0f, 720.0f, 400.0f, 300.0f);
        amRotate.setStartOffset(2000);
        amRotate.setDuration(2000);
        amRotate.setRepeatCount(0);

        Animation amScale = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f);
        amScale.setStartOffset(2000);
        amScale.setDuration(2000);
        amScale.setRepeatCount(0);

        AnimationSet amSet = new AnimationSet(true);
        amSet.addAnimation(amRotate);
        amSet.addAnimation(amScale);
        return amSet;
    }

    AnimationSet scaleRotateOut()
    {
        Animation amRotate = new RotateAnimation(720.0f, 0.0f, 400.0f, 300.0f);
        amRotate.setStartOffset(0);
        amRotate.setDuration(2000);
        amRotate.setRepeatCount(0);

        Animation amScale = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f);
        amScale.setStartOffset(0);
        amScale.setDuration(2000);
        amScale.setRepeatCount(0);

        AnimationSet amSet = new AnimationSet(true);
        amSet.addAnimation(amRotate);
        amSet.addAnimation(amScale);
        return amSet;
    }

    AnimationSet transIn()
    {
        Animation amTranslate = new TranslateAnimation(-800.0f, 0.0f, 0.0f, 0.0f);
        amTranslate.setDuration(2000);
        amTranslate.setRepeatCount(0);
        AnimationSet amSet = new AnimationSet(false);
        amSet.addAnimation(amTranslate);
        return amSet;
    }

    AnimationSet transOut()
    {
        Animation amTranslate = new TranslateAnimation(0.0f, 800.0f, 0.0f, 0.0f);
        amTranslate.setDuration(2000);
        amTranslate.setRepeatCount(0);
        AnimationSet amSet = new AnimationSet(false);
        amSet.addAnimation(amTranslate);
        return amSet;
    }

    AnimationSet scaleRotaeTransIn()
    {
        Animation amRotate = new RotateAnimation(0.0f, 720.0f, 400.0f, 300.0f);
        amRotate.setStartOffset(1000);
        amRotate.setDuration(2000);
        amRotate.setRepeatCount(0);

        Animation amScale = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f);
        amScale.setStartOffset(0);
        amScale.setDuration(2000);
        amScale.setRepeatCount(0);

        Animation amTranslate = new TranslateAnimation(-600.0f, 0.0f, -400.0f, 0.0f);
        amTranslate.setStartOffset(1000);
        amTranslate.setDuration(2000);
        amTranslate.setRepeatCount(0);

        AnimationSet amSet = new AnimationSet(false);
        amSet.addAnimation(amRotate);
        amSet.addAnimation(amScale);
        amSet.addAnimation(amTranslate);
        return amSet;
    }

    AnimationSet scaleRotaeTransOut()
    {
        Animation amRotate = new RotateAnimation(0.0f, 720.0f, 400.0f, 300.0f);
        amRotate.setStartOffset(0);
        amRotate.setDuration(2000);
        amRotate.setRepeatCount(0);

        Animation amScale = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f);
        amScale.setStartOffset(0);
        amScale.setDuration(2000);
        amScale.setRepeatCount(0);

        Animation amTranslate = new TranslateAnimation(0.0f, 600.0f, 0.0f, -400.0f);
        amTranslate.setStartOffset(0);
        amTranslate.setDuration(2000);
        amTranslate.setRepeatCount(0);

        AnimationSet amSet = new AnimationSet(false);
        amSet.addAnimation(amRotate);
        amSet.addAnimation(amScale);
        amSet.addAnimation(amTranslate);
        return amSet;
    }
}
