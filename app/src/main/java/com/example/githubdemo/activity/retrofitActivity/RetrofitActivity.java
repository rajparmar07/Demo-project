package com.example.githubdemo.activity.retrofitActivity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

import com.example.githubdemo.R;
import com.example.githubdemo.activity.retrofitActivity.adapter.ListDataAdapter;
import com.example.githubdemo.activity.retrofitActivity.api.Api;
import com.example.githubdemo.activity.retrofitActivity.api.ApiInterface;
import com.example.githubdemo.activity.retrofitActivity.model.ListModel;
import com.example.githubdemo.databinding.ActivityRetrofitBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends AppCompatActivity {

    ActivityRetrofitBinding binding;
    List<ListModel> dataList = new ArrayList<>();
    RecyclerView.LayoutManager manager;
    ListDataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_retrofit);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Retrofit Example");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.rcvRetrofit.setLayoutManager(manager);

        adapter = new ListDataAdapter(this, dataList);
        binding.rcvRetrofit.setAdapter(adapter);

        doApiCall();

    }

    private void doApiCall() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface service = retrofit.create(ApiInterface.class);

        Call<List<ListModel>> call = service.getPhotos();

        call.enqueue(new Callback<List<ListModel>>() {
            @Override
            public void onResponse(Call<List<ListModel>> call, Response<List<ListModel>> response) {
                if (response.body() != null) {
                    binding.flProgress.setVisibility(View.GONE);
                    dataList.addAll(response.body());

                    adapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<List<ListModel>> call, Throwable t) {
                binding.flProgress.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(), "Something went wrong. Please try again. ", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}