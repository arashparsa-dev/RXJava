package com.example.rxjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.rxjava.Adapter.PostAdapter;
import com.example.rxjava.Model.Post;
import com.example.rxjava.api.APIClient;
import com.example.rxjava.api.APIInterface;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    APIInterface request;
    PostAdapter adapter;
    String url = "http://192.168.1.12/rxjava/";

    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.rv_home);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        request = APIClient.getApiClient(url).create(APIInterface.class);



        compositeDisposable.add(request.getPost()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(new Consumer<List<Post>>() {
            @Override
            public void accept(List<Post> posts) throws Throwable {
                adapter=new PostAdapter(getApplicationContext(),posts);
                recyclerView.setAdapter(adapter);
            }
        }));

        //single is good for take error log
       /* compositeDisposable.add(request.getPost()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribeWith(new DisposableSingleObserver<List<Post>>() {
            @Override
            public void onSuccess(@NonNull List<Post> posts) {
                adapter=new PostAdapter(getApplicationContext(),posts);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onError(@NonNull Throwable e) {
            Log.d("Error",e.getMessage()+"");
            }
        }));*/
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }
}