package com.example.quizapp2.history;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quizapp2.R;
import com.example.quizapp2.core.CoreFragment;

public class HistoryFragment extends CoreFragment {

    private HistoryFragmentViewModel mViewModel;

    public static HistoryFragment newInstance() {
        return new HistoryFragment();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HistoryFragmentViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    protected int getLayoutId() {
        return R.layout.history_fragment;
    }
}
