package com.example.quizapp2.data.remote;

import com.example.quizapp2.model.Question;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuestionsResponse {
    @SerializedName("response_code")
    private int responseCode;

    private List<Question> results;
}
