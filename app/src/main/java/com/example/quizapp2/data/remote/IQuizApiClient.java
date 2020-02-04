package com.example.quizapp2.data.remote;

import com.example.quizapp2.model.Category;
import com.example.quizapp2.model.Question;

import java.util.List;

public interface IQuizApiClient {

    void qetQuestions(QuestionsCallback callback);

    void getCategories(CategoriesCallback callback);

    interface QuestionsCallback{

        void onSuccess(List<Question> questions);

        void onFailure(Exception e);

    }

    interface CategoriesCallback{

        void onSuccess(List<Category> categories);

        void onFailure(Exception e);
    }
}
