package com.example.rxjava.api;

import com.example.rxjava.Model.List_Users;
import com.example.rxjava.Model.Post;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface APIInterface {


    @GET("getPosts.php")
    Observable<List<Post>> getPost();



    //Flowable==> instead Observable(Observable better) + Flowable has memory issues
    /*@GET("getPosts.php")
    Flowable<List<Post>> getPost();*/
    //Single==> instead Observable. still Observable recommended
    /*@GET("getPosts.php")
    Single<List<Post>> getPost();*/
}
