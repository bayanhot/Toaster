package com.example.toasterlibrary;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Toast;

/**
 * author SGY
 * date 2019/7/7
 * desc
 */
public class Toaster {

    private static Context context;
    private static Toast toast;

    private Toaster() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 在Application中初始化ToastUtils.init(this)
     *
     * @param context 上下文
     */
    public static void init(Context context) {
        Toaster.context = context.getApplicationContext();
    }

    /**
     * 发送Toast
     *
     * @param msg 消息
     */
    public static void show(String msg) {
        showToast(msg);
    }

    /**
     * 发送Toast，并改变字体颜色
     *
     * @param msg          消息
     * @param messageColor 字体颜色
     */
    public static void show(String msg, int messageColor) {
        showToast(msg, messageColor);
    }

    /**
     * 发送Toast，并改变字体颜色和背景样式
     *
     * @param msg           消息
     * @param messageColor  字体颜色
     * @param shapeResource 背景样式
     */
    //
    public static void show(String msg, int messageColor, int shapeResource) {
        showToast(msg, messageColor, shapeResource);
    }

    /**
     * @param message 消息
     */
    private static void showToast(String message) {
        cancelToast();
        toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        toast.show();
    }

    /**
     * @param message      消息
     * @param messageColor 字体颜色
     */
    private static void showToast(String message, int messageColor) {
        cancelToast();
        setColor(message, messageColor);
        toast.show();
    }

    /**
     * @param massage       消息
     * @param messageColor  字体颜色
     * @param shapeResource 背景样式
     */
    private static void showToast(String massage, int messageColor, int shapeResource) {
        cancelToast();
        setColor(massage, messageColor);
        setBackGround(shapeResource);
        toast.show();
    }


    /**
     * 发送Toast，改变位置
     *
     * @param msg     消息
     * @param gravity 位置
     */
    public static void showAt(String msg, int gravity) {
        showToastAt(msg, gravity);
    }

    /**
     * 发送Toast，改变字体颜色，改变位置
     *
     * @param msg          消息
     * @param messageColor 字体颜色
     * @param gravity      位置
     */
    public static void showAt(String msg, int messageColor, int gravity) {
        showToastAt(msg, messageColor, gravity);
    }

    /**
     * 发送Toast，改变字体颜色，改变背景样式，改变位置
     *
     * @param msg           消息
     * @param messageColor  字体颜色
     * @param shapeResource 背景样式
     * @param gravity       位置
     */
    public static void showAt(String msg, int messageColor, int shapeResource, int gravity) {
        showToastAt(msg, messageColor, shapeResource, gravity);
    }

    /**
     * 发送Toast，改变字体颜色，改变背景样式，改变位置、偏移
     *
     * @param msg           消息
     * @param messageColor  字体颜色
     * @param shapeResource 背景样式
     * @param gravity       位置
     * @param x             基于位置的x轴偏移
     * @param y             基于位置的y轴偏移
     */
    public static void showAt(String msg, int messageColor, int shapeResource, int gravity, int x, int y) {
        showToastAt(msg, messageColor, shapeResource, gravity, x, y);
    }

    /**
     * @param message 消息
     * @param gravity 位置
     */
    private static void showToastAt(String message, int gravity) {
        cancelToast();
        toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        toast.setGravity(gravity, 0, 200);
        toast.show();
    }

    /**
     * @param message      消息
     * @param messageColor 字体颜色
     * @param gravity      位置
     */
    private static void showToastAt(String message, int messageColor, int gravity) {
        cancelToast();
        setColor(message, messageColor);
        toast.setGravity(gravity, 0, 200);
        toast.show();
    }

    /**
     * @param message       消息
     * @param messageColor  字体颜色
     * @param shapeResource 背景样式
     * @param gravity       位置
     */
    private static void showToastAt(String message, int messageColor, int shapeResource, int gravity) {
        cancelToast();
        setColor(message, messageColor);
        setBackGround(shapeResource);
        toast.setGravity(gravity, 0, 200);
        toast.show();
    }

    /**
     * @param message       消息
     * @param messageColor  字体颜色
     * @param shapeResource 背景样式
     * @param gravity       位置
     * @param x             基于位置的x轴偏移
     * @param y             基于位置的y轴偏移
     */
    private static void showToastAt(String message, int messageColor, int shapeResource, int gravity, int x, int y) {
        cancelToast();
        setColor(message, messageColor);
        setBackGround(shapeResource);
        toast.setGravity(gravity, x, y);
        toast.show();
    }

    /**
     * 设置文字颜色
     *
     * @param msg          消息
     * @param messageColor 字体颜色
     */
    private static void setColor(String msg, int messageColor) {
        SpannableString spannableString = new SpannableString(msg);
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(ContextCompat.getColor(context, messageColor));
        spannableString.setSpan(colorSpan, 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        toast = Toast.makeText(context, spannableString, Toast.LENGTH_SHORT);
    }

    /**
     * 设置背景样式
     *
     * @param shapeResource 背景样式
     */
    private static void setBackGround(int shapeResource) {
        View view = toast.getView();
        view.setBackgroundResource(shapeResource);
    }

    /**
     * 取消Toast显示
     */
    private static void cancelToast() {
        if (toast != null) {
            toast.cancel();
            toast = null;
        }
    }

    /**
     * 外部调用取消Toast
     */
    public static void cancel() {
        cancelToast();
    }
}
