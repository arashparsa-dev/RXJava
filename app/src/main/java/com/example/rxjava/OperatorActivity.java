package com.example.rxjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.rxjava.Model.List_Users;
import com.example.rxjava.Model.Users;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class OperatorActivity extends AppCompatActivity {

    CompositeDisposable compositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create
        /*


        Observable <Users> usersObservable = Observable.create(new ObservableOnSubscribe<Users>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Users> emitter) throws Throwable {
             for(Users users : List_Users.getUsers()){
                 if(!emitter.isDisposed())
                     emitter.onNext(users);
             }
             if (!emitter.isDisposed())
                 emitter.onComplete();
            }
        })
                //jologiri az block shodan ui
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());




        usersObservable.subscribe(new Observer<Users>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Users users) {
                Log.d("On_Next_Thread : " , Thread.currentThread().getName());
                Log.d("On_Next_Create : " , users.getName() + " " + users.getEmail());

            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("On_Error" ,e.getMessage() + "");
            }

            @Override
            public void onComplete() {
                Log.d("On_complete : " ,"Complete" );

            }
        });



         */
        //Just
        /*

        Observable<String> stringObservable = Observable.just("arash" , "siavash" , "ava" , "forough")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());

        stringObservable.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {

                Log.d("On_Next_Thread : " , Thread.currentThread().getName());
                Log.d("On_Next_Create : " , s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.d("On_complete : " ,"Complete" );
            }
        });

*/
        //fromIterable
        /*



        Observable<Users> usersObservable = Observable.fromIterable(List_Users.getUsers())
                //filter jologiri az block ui
                .filter(new Predicate<Users>() {
                    @Override
                    public boolean test(Users users) throws Throwable {


                        Log.d("On_Next_filter",Thread.currentThread().getName());
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        return true;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());

        usersObservable.subscribe(new Observer<Users>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Users users) {

                Log.d("On_Next_Thread",Thread.currentThread().getName());
                Log.d("On_Next_fromIterable",users.getName()+ " "+ users.getEmail()+" "+users.getId());


            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("On_error" , e.getMessage()+ "");
            }

            @Override
            public void onComplete() {
                Log.d("On_complete","complete");
            }
        });

*/
        //Range & Repeat
        /*


        Observable<Integer> rangeObservable = Observable.range(1,20)
                .repeat(5)
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread());

        //dar mavared sangin Schedulers.io() ro to subscribeOn biyar


        rangeObservable.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Integer integer) {
            Log.d("On_Next_Thread" , Thread.currentThread().getName());
            Log.d("On_Next_Range" , integer.toString());
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.d("ON_Complete" , "Complete");

            }
        });


*/
        //Disposable
        /*

        compositeDisposable = new CompositeDisposable();
        Observable<Users> usersObservable = Observable.fromIterable(List_Users.getUsers())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());


        usersObservable.subscribe(new Observer<Users>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                compositeDisposable.add(d);
                Log.d("On_subscribe" , "Disposable");

            }

            @Override
            public void onNext(@NonNull Users users) {
                Log.d("On_Next_Thread" , Thread.currentThread().getName());
                Log.d("On_Next_Disposable" , users.getName());

            }

            @Override
            public void onError(@NonNull Throwable e) {

                Log.d("On_error" , e.getMessage()+ "");
            }

            @Override
            public void onComplete() {
                Log.d("On_Complete" , "Complete");
            }
        });

        compositeDisposable.add(usersObservable.subscribe(new Consumer<Users>() {
            @Override
            public void accept(Users users) throws Throwable {

            }
        }));


*/

        //handler
        /*  Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               Log.d("handelr_OK","OK");
            }
        },4000);


*/

        //internal+takewhile
        /* Observable<Long> intervalObservable = Observable.interval(1 , TimeUnit.SECONDS)
                .takeWhile(new Predicate<Long>() {
                    @Override
                    public boolean test(Long aLong) throws Throwable {
                        return aLong<=10;
                        //if u want unlimited return true
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());


        intervalObservable.subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Long aLong) {
            Log.d("On_Next_thread" , Thread.currentThread().getName());
            Log.d("On_Next_interval" , aLong+"");
            }

            @Override
            public void onError(@NonNull Throwable e) {
            Log.d("On_error" ,e.getMessage());
            }

            @Override
            public void onComplete() {
            Log.d("On_complete","complete");
            }
        });
*/
        //timer estefade bishtar az interval
        /* Observable<Long> timerObservable = Observable.timer(6, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());


        timerObservable.subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Long aLong) {
                Log.d("On_Next_thread" , Thread.currentThread().getName());
                Log.d("On_Next_interval" , aLong+"");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("On_error" ,e.getMessage());

            }

            @Override
            public void onComplete() {
                Log.d("On_complete","complete");

            }
        });*/
        //take
        /* Observable<Users> takeObservable = Observable.fromIterable(List_Users.getUsers())
                .take(2)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());


        takeObservable.subscribe(new Observer<Users>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Users users) {
                Log.d("On_Next_thread" , Thread.currentThread().getName());
                Log.d("On_Next_take" , users.getName() + " "+users.getEmail());
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("On_error" ,e.getMessage());

            }

            @Override
            public void onComplete() {
                Log.d("On_complete","complete");

            }
        });


*/
        //takewhile
        /* Observable<Users> takeObservable = Observable.fromIterable(List_Users.getUsers())
                .takeWhile(new Predicate<Users>() {
                    @Override
                    public boolean test(Users users) throws Throwable {
                        return users.isShow_item();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());


        takeObservable.subscribe(new Observer<Users>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Users users) {
                Log.d("On_Next_thread" , Thread.currentThread().getName());
                Log.d("On_Next_take" , users.getName() + " "+users.getEmail());
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("On_error" ,e.getMessage());

            }

            @Override
            public void onComplete() {
                Log.d("On_complete","complete");

            }
        });

*/
        //Distinct=motemayez
        /*
        Observable<Users> takeObservable = Observable.fromIterable(List_Users.getUsers())
                .distinct(new Function<Users, String>() {

                    @Override
                    public String apply(Users users) throws Throwable {
                        return users.getName() + " " + users.getEmail();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());


        takeObservable.subscribe(new Observer<Users>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Users users) {
                Log.d("On_Next_thread" , Thread.currentThread().getName());
                Log.d("On_Next_take" , users.getName() + " "+users.getEmail());
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("On_error" ,e.getMessage());

            }

            @Override
            public void onComplete() {
                Log.d("On_complete","complete");

            }
        });
*/
        //Buffer
        @NonNull Observable<List<Users>> bufferObservable = Observable.fromIterable(List_Users.getUsers())
                .buffer(2)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());


        bufferObservable.subscribe(new Observer<List<Users>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull List<Users> list) {
                Log.d("On_Next_take" , "......................");
                for(Users users : list)
                Log.d("On_Next_take" , users.getName() + " "+users.getEmail());
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.d("On_complete","complete");
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
//        compositeDisposable.dispose();
    }
}