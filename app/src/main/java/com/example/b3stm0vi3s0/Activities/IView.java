package com.example.b3stm0vi3s0.Activities;

import com.example.b3stm0vi3s0.models.Movie;

import java.util.List;

public interface IView {
    void setRecyclerView(List<Movie> movies);
    void showErrorMsg(String error);
}
