package com.example.b3stm0vi3s0.Activities;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.b3stm0vi3s0.Network.ApiClient;
import com.example.b3stm0vi3s0.Network.ApiInterface;
import com.example.b3stm0vi3s0.R;
import com.example.b3stm0vi3s0.RecyclerViewAdapter;
import com.example.b3stm0vi3s0.models.Movie;
import com.example.b3stm0vi3s0.models.Result;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class MainActivity extends AppCompatActivity  implements IView{

    private static final String TAG = "MainActivity";
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private List<Movie> mMovies;
    Context mContext;
    MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = this;
        mPresenter = new MainPresenter(this);
        mPresenter.doYourJob();
    }

    @Override
    public void setRecyclerView(List<Movie> movies)
    {
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mContext, movies);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(mContext,2));
    }

    @Override
    public void showErrorMsg(String error) {
            Toast.makeText(this,error, Toast.LENGTH_LONG).show();
    }
}