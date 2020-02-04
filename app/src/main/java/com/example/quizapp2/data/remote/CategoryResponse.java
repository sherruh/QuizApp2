package com.example.quizapp2.data.remote;

import com.example.quizapp2.model.Category;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class CategoryResponse {
    @SerializedName("trivia_categories")
    private List<Category> categories;

    public CategoryResponse(List<Category> categories) {
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
