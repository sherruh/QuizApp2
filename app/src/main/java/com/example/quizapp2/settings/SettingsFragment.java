package com.example.quizapp2.settings;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import android.view.View;

import com.example.quizapp2.R;
import com.example.quizapp2.core.CoreFragment;
import com.example.quizapp2.main.MainViewModel;

public class SettingsFragment extends CoreFragment {

    private MainViewModel mViewModel;

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.settings_fragment;
    }
}
