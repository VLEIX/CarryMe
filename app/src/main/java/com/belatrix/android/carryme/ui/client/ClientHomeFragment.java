package com.belatrix.android.carryme.ui.client;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.belatrix.android.carryme.R;
import com.belatrix.android.carryme.ui.common.MVPFragment;
import com.google.android.gms.location.places.ui.PlacePicker;

/**
 * Created by Flavio Franco Tunqui (VLEIX) on 2/3/17.
 * GOOODK
 */
public class ClientHomeFragment extends MVPFragment<IClientHomePresenter> implements IClientHomeView {

    private static final int PLACE_PICKER_REQUEST = 1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.client_home_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setInitValues();
    }

    @Override
    protected IClientHomePresenter provideViewPresenter() {
        return new ClientHomePresenter(this);
    }

    private void setInitValues() {

    }

    @Override
    public void navigateToSelectPlace() {
        try {
            PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
            startActivityForResult(builder.build(getActivity()), PLACE_PICKER_REQUEST);
        }
        catch (Exception ex) {
            showAlertDialog(getResourceString(R.string.lang_common_error), getResourceString(R.string.lang_common_error_google_places));
        }
    }
}
