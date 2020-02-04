package com.example.quizapp2.data.remote;

import com.example.quizapp2.model.Question;

import java.util.List;

public interface IQuizApiClient {

    void qetQuestions(QuestionsCallback callback);

    interface QuestionsCallback{

        void onSuccess(List<Question> questions);

        void onFailure(Exception e);

    }
}
