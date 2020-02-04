package com.example.quizapp2;

import android.app.Application;

import com.example.quizapp2.data.remote.IQuizApiClient;
import com.example.quizapp2.data.remote.QuizApiClient;

public class App extends Application {

    public static IQuizApiClient quizApiClient;

    @Override
    public void onCreate() {
        super.onCreate();
        quizApiClient = new QuizApiClient();
    }
}
