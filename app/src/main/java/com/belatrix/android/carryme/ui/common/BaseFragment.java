package com.belatrix.android.carryme.ui.common;

import android.content.Context;
import android.support.v4.app.Fragment;

/**
 * Created by ffranco on 23/08/16.
 */
public class BaseFragment extends Fragment {
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            onAttachBaseActivity((BaseActivity) context);
        }
    }

    /**
     * This method will be called when this fragment is fully
     * attached to a {@link BaseActivity} only if this fragment
     * is being hosted by a {@link BaseActivity}, otherwise this
     * method never will be called.
     * @param activity
     */
    protected void onAttachBaseActivity(BaseActivity activity) {
    }
}
