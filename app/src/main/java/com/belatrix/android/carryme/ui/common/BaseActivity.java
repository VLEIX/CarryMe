package com.belatrix.android.carryme.ui.common;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by ffranco on 23/08/16.
 */
public class BaseActivity extends AppCompatActivity {
//    private IOnBackPressedListener backPressedListener;
//
//    /**
//     * If you set a back pressed listener to this activity, this
//     * listener will override the current functionality of {@link #onBackPressed()}
//     * in order to perform custom navigation when the user presses back
//     * button.
//     * @param backPressedListener
//     */
//    public void setOnBackPressedListener(@Nullable IOnBackPressedListener backPressedListener) {
//        this.backPressedListener = backPressedListener;
//    }

    @Override
    public void onBackPressed() {
//        if (backPressedListener != null) {
//            backPressedListener.onBackPressed();
//        }
//        else {
            super.onBackPressed();
//        }
    }
}
