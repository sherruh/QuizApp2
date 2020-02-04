package com.example.quizapp2.data.remote;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class QuizApiClient implements IQuizApiClient {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://opentdb.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    QuizApi client = retrofit.create(QuizApi.class);

    @Override
    public void qetQuestions(final QuestionsCallback callback) {
        Call<QuestionsResponse> call = client.getQuestions(
                10,
                null,
                null
        );

        call.enqueue(new Callback<QuestionsResponse>() {
            @Override
            public void onResponse(Call<QuestionsResponse> call, Response<QuestionsResponse> response) {

            }

            @Override
            public void onFailure(Call<QuestionsResponse> call, Throwable t) {
                callback.onFailure(new Exception(t));
            }
        });
    }

    private interface QuizApi{
        @GET("api.php")
        Call<QuestionsResponse> getQuestions(
                @Query("amount") int amount,
                @Query("category") String category,
                @Query("difficulty") String difficulty
        );
    }
}
