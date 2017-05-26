package com.harati.np.newapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.harati.np.newapp.Activity.MainActivity;

import io.realm.Realm;
import io.realm.RealmObject;

/**
 * Created by Sameer on 5/5/2017.
 */

public class DefaultDashboardFragment extends Fragment {
    RealmObject realmObject;
    Realm realm;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((MainActivity)getActivity()).setTitle("Dashboard");
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
