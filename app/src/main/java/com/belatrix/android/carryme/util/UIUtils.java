/*
 * UIUtils.java
 * PayMeWallet
 *
 * Created by Christian Canahuire on 18/11/2016.
 * Copyright © 2016 GOOODK. All rights reserved.
 */

package com.belatrix.android.carryme.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.belatrix.android.carryme.R;
import com.belatrix.android.carryme.listener.IOnActionListener;

import java.io.IOException;
import java.io.InputStream;

public final class UIUtils {

    private UIUtils() {
    }

    public static ProgressDialog showProgressDialog(Context context, String title, String message) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setTitle(title);
        progressDialog.setMessage(message);
        progressDialog.setCancelable(false);
        progressDialog.show();
        return progressDialog;
    }

    public static ProgressDialog showProgressDialog(Context context, String message) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("");
        progressDialog.setMessage(message);
        progressDialog.setCancelable(false);
        if (progressDialog.getWindow() != null) {
            progressDialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        }
        progressDialog.show();

        return progressDialog;
    }

    public static void showAlertDialog(Context context, String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton(R.string.lang_common_action_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.create().show();
    }

    public static void showSimpleAlertDialog(Context context, String title, String message,
                                       @Nullable final IOnActionListener onActionListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(R.string.lang_common_action_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (onActionListener != null) {
                    onActionListener.onAction();
                }
            }
        });
        builder.setCancelable(false);
        builder.create().show();
    }

    public static void showSimpleAlertDialog(Context context, String title, String message,
                                             String positiveButtonText,
                                             @Nullable final IOnActionListener onActionListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(positiveButtonText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (onActionListener != null) {
                    onActionListener.onAction();
                }
            }
        });
        builder.setCancelable(false);
        builder.create().show();
    }

    public static void showTwoOptionsAlertDialog(Context context, String title, String message,
                                                 @Nullable final IOnActionListener onPositiveListener,
                                                 @Nullable final IOnActionListener onNegativeListener) {
        showTwoOptionsAlertDialog(context, title, message, context.getResources().getString(R.string.lang_common_action_ok),
                onPositiveListener, context.getResources().getString(R.string.lang_common_action_cancel), onNegativeListener);
    }

    public static void showTwoOptionsAlertDialog(Context context, String title, String message,
                                                 String positiveButtonText,
                                                 @Nullable final IOnActionListener onPositiveListener,
                                                 String negativeButtonText,
                                                 @Nullable final IOnActionListener onNegativeListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(positiveButtonText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (onPositiveListener != null) {
                    onPositiveListener.onAction();
                }
            }
        });
        builder.setNegativeButton(negativeButtonText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (onNegativeListener != null) {
                    onNegativeListener.onAction();
                }
            }
        });
        builder.setCancelable(true);
        builder.create().show();
    }

    @DrawableRes
    public static int getDrawableResourceId(Context context, String resourceName) {
        return context.getResources().getIdentifier(resourceName, "drawable", context.getPackageName());
    }

    public static int fromDpToPx(Context context, float dp) {
        Resources r = context.getResources();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics());
    }

    public static Bitmap getBitmapFromAsset(Context context, String filePath) {
        AssetManager assetManager = context.getAssets();

        Bitmap bitmap = null;
        try {
            InputStream inputStream = assetManager.open(filePath);
            bitmap = BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            Log.e("UIUtils", "Couldn't find any bitmap in: " + filePath);
        }

        return bitmap;
    }

    public static Bitmap getBitmapFromStorage(String filePath) {
        return BitmapFactory.decodeFile(filePath);
    }

    public static Bitmap getBitmapFromStorageDownscaled(String filePath, int downscale) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = downscale;

        return BitmapFactory.decodeFile(filePath, options);
    }

    public static void hideSoftKeyboard(Activity activity) {
        activity.getWindow()
                .setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    public static void showSoftKeyboard(Activity activity) {
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        InputMethodManager inputManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    public static void forceHideKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }
    public static void forceHideKeyboard(Context context, View focusedView) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) context.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                focusedView.getWindowToken(), 0);
    }

}
