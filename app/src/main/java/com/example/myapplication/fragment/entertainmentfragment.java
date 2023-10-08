package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Api.ApiUtilites;
import com.example.myapplication.R;
import com.example.myapplication.adapter.Adapter;
import com.example.myapplication.models.MainNews;
import com.example.myapplication.models.Modelclass;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class entertainmentfragment extends Fragment {

    String api ="c8c48dfa60234a398d81ab7160c16859";
    ArrayList<Modelclass> modelclassArrayList;
    Adapter  adapter;
    String country="in";
    private RecyclerView recyclerViewofentertainment;
    private  String category="entertainment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.entertainmentfragment,null);

        recyclerViewofentertainment = v.findViewById(R.id.recyclerviewentertainment);
        modelclassArrayList = new ArrayList<>();
        recyclerViewofentertainment.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter= new Adapter(getContext(),modelclassArrayList);
        recyclerViewofentertainment.setAdapter(adapter);
        return v;
    }


    private void findNews(){
        ApiUtilites.getApiInterface().getNews(country,100,api).enqueue(new Callback<MainNews>() {
            @Override
            public void onResponse(Call<MainNews> call, Response<MainNews> response) {
                if (response.isSuccessful()){
                    modelclassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MainNews> call, Throwable t) {

            }
        });
    }
}
