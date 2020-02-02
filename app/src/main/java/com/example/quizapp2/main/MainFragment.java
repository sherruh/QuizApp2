package com.example.quizapp2.main;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.quizapp2.R;
import com.example.quizapp2.core.CoreFragment;
import com.example.quizapp2.utils.Logger;

public class MainFragment extends CoreFragment implements SeekBar.OnSeekBarChangeListener {

    private MainViewModel mViewModel;
    private TextView tvAmount;
    private SeekBar seekBar;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        tvAmount = getActivity().findViewById(R.id.main_text_amount);
        seekBar = getActivity().findViewById(R.id.main_seek_bar);
        seekBar.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.main_fragment;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        tvAmount.setText(String.valueOf(seekBar.getProgress()));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        /*Logger.d(String.valueOf(seekBar.getProgress()));
        tvAmount.setText(String.valueOf(seekBar.getProgress()));*/
    }
}
