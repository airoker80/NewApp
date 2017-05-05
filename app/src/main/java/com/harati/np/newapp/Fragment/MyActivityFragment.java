package com.harati.np.newapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.harati.np.newapp.Activity.MainActivity;

/**
 * Created by Sameer on 5/5/2017.
 */

public class MyActivityFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((MainActivity)getActivity()).setTitle("My Activities");
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
