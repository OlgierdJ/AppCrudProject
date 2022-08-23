package com.example.appcrudproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;

import com.example.appcrudproject.activities.BaseActivity;
import com.example.appcrudproject.entities.Person;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.util.List;

public class MainActivity extends BaseActivity {

    private IPersonService _PService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        //StrictMode.setThreadPolicy(policy);
        /*
        _PService = APIClient.getClient().create(IPersonService.class);
        Call<List<Person>> call1 = _PService.get();
        call1.enqueue(new Callback<List<Person>>() {
            @Override
            public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {
                List<Person> p = response.body();
            }
            @Override
            public void onFailure(Call<List<Person>> call, Throwable t) {
                call.cancel();
            }
        });

         */
        /*
        Person toC = new Person();
        toC.setId(0);
        toC.setName("bob");
        toC.setEmail("bobstreet@atplace");
        toC.setNote("he is bob");
        toC.setFavorite(true);
        toC.setPhoneNumber("28771104");
        Call<Person> call2 = _PService.create(toC);
        call2.enqueue(new Callback<Person>() {
            @Override
            public void onResponse(Call<Person> call, Response<Person> response) {
                Created = response.body();
            }
            @Override
            public void onFailure(Call<Person> call, Throwable t) {
                call.cancel();
            }
        });

         */
        /*
        Call<Person> call3 = _PService.get("1");
        call3.enqueue(new Callback<Person>() {
            @Override
            public void onResponse(Call<Person> call, Response<Person> response) {
                PersonById = response.body();
                PersonById.setName("bobby");
                Call<Person> call4 = _PService.update(PersonById);
                call4.enqueue(new Callback<Person>() {
                    @Override
                    public void onResponse(Call<Person> call, Response<Person> response) {
                        UpdatedPerson = response.body();
                        Call<Person> call5 =_PService.delete("1");
                        call5.enqueue(new Callback<Person>() {
                            @Override
                            public void onResponse(Call<Person> call, Response<Person> response) {
                                DeletedPerson = response.body();
                            }
                            @Override
                            public void onFailure(Call<Person> call, Throwable t) {
                                call.cancel();
                            }
                        });
                    }
                    @Override
                    public void onFailure(Call<Person> call, Throwable t) {
                        call.cancel();
                    }
                });
            }
            @Override
            public void onFailure(Call<Person> call, Throwable t) {
                call.cancel();
            }
        });




         */








    }
}