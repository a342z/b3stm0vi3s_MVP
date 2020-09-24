package com.example.b3stm0vi3s0.Activities;

import android.util.Log;

import androidx.recyclerview.widget.GridLayoutManager;

import com.example.b3stm0vi3s0.Network.ApiClient;
import com.example.b3stm0vi3s0.Network.ApiInterface;
import com.example.b3stm0vi3s0.RecyclerViewAdapter;
import com.example.b3stm0vi3s0.models.Movie;
import com.example.b3stm0vi3s0.models.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {

    private static final String TAG = "MainPresenter";
    IView mIView;
    List<Movie> mMovies;
    public MainPresenter(IView IView) {
        mIView = IView;
    }

    public void doYourJob()
    {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Result> call = apiService.getMovies(ApiClient.API_KEY);

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                mMovies = response.body().getMovies();
                if(mMovies!= null)
                    mIView.setRecyclerView(mMovies);
                else {
                    mIView.showErrorMsg("ERROR: NULL Movies found");
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

                mIView.showErrorMsg("ERROR: call.enqueue failed");

            }
        });


    }
}
