package com.example.quizapp2.main;

import androidx.appcompat.widget.AppCompatSpinner;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.quizapp2.App;
import com.example.quizapp2.R;
import com.example.quizapp2.core.CoreFragment;
import com.example.quizapp2.data.remote.IQuizApiClient;
import com.example.quizapp2.model.Question;
import com.example.quizapp2.utils.Logger;

import java.util.List;

public class MainFragment extends CoreFragment implements SeekBar.OnSeekBarChangeListener {

    private MainViewModel mViewModel;
    private TextView tvAmount;
    private SeekBar seekBar;
    private AppCompatSpinner spinnerCategory;
    private AppCompatSpinner spinnerDifficulty;

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
        spinnerCategory = getActivity().findViewById(R.id.main_category_spinner);
        spinnerDifficulty = getActivity().findViewById(R.id.main_difficulty_spinner);
        App.quizApiClient.qetQuestions(new IQuizApiClient.QuestionsCallback() {
            @Override
            public void onSuccess(List<Question> questions) {
                Logger.d(String.valueOf(questions.size()));
            }

            @Override
            public void onFailure(Exception e) {
                Logger.d(e.getMessage());
            }
        });

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

    }
}
