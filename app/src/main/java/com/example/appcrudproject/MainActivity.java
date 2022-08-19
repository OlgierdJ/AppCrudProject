package com.example.appcrudproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private IPersonService _PService;
    private Person Created;
    private Person PersonById;
    private Person UpdatedPerson;
    private Person DeletedPerson;
    private List<Person> People;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        _PService = APIClient.getClient().create(IPersonService.class);
        Call<List<Person>> call1 = _PService.get();
        call1.enqueue(new Callback<List<Person>>() {
            @Override
            public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {
                People = response.body();

            }
            @Override
            public void onFailure(Call<List<Person>> call, Throwable t) {
                call.cancel();
            }
        });
        /*Call<Person> call2 = _PService.create(new Person(0,"bob","bobstreet","28771104","he is bob",true));
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
        Call<Person> call3 = _PService.get(Integer.toString(People.get(0).getId()));
        call3.enqueue(new Callback<Person>() {
            @Override
            public void onResponse(Call<Person> call, Response<Person> response) {
                PersonById = response.body();
            }
            @Override
            public void onFailure(Call<Person> call, Throwable t) {
                call.cancel();
            }
        });
        PersonById.setName("bobby");
        Call<Person> call4 = _PService.update(PersonById);
        call4.enqueue(new Callback<Person>() {
            @Override
            public void onResponse(Call<Person> call, Response<Person> response) {
                UpdatedPerson = response.body();
            }
            @Override
            public void onFailure(Call<Person> call, Throwable t) {
                call.cancel();
            }
        });
        Call<Person> call5 =_PService.delete(Integer.toString(People.get(0).getId()));
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

         */
        this._PService.hashCode();
    }
}