package com.example.appcrudproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.appcrudproject.activities.AddPersonActivity;
import com.example.appcrudproject.activities.BaseActivity;
import com.example.appcrudproject.activities.InspectPersonActivity;
import com.example.appcrudproject.adapters.PersonAdapter;
import com.example.appcrudproject.entities.Person;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MainActivity extends BaseActivity {

    private IPersonService _PService;
    private List<Person> _People;
    private static PersonAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _PService = APIClient.getClient().create(IPersonService.class);


        Call<List<Person>> call1 = _PService.get();
        call1.enqueue(new Callback<List<Person>>() {
            @Override
            public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {
                _People = response.body();
                RefreshList(_People);
            }
            @Override
            public void onFailure(Call<List<Person>> call, Throwable t) {
                call.cancel();
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(e->{
Intent intent = new Intent(MainActivity.this, AddPersonActivity.class);
                activityLauncher.launch(intent, result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if(data.getExtras() != null) {
                            Person p = data.getParcelableExtra("newPerson");
                            Call<Person> c = _PService.create(p);
                            c.enqueue(new Callback<Person>() {
                                @Override
                                public void onResponse(Call<Person> call, Response<Person> response) {
                                    Person newP = response.body();
                                    _People.add(newP);
                                    RefreshList(_People);
                                }
                                @Override
                                public void onFailure(Call<Person> call, Throwable t) {
                                    call.cancel();
                                }
                            });
                        }
                    }
                });
        });

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
    public void NavToPerson(Person pers){
        Intent intent = new Intent(MainActivity.this, InspectPersonActivity.class);
        intent.putExtra("person", pers);
        activityLauncher.launch(intent, result -> {
            if (result.getResultCode() == Activity.RESULT_OK) {
                Intent data = result.getData();
                if(data.getExtras() != null) {

                    Person p = data.getParcelableExtra("updatedPerson");
                    if (p!=null){
                        Call<Person> c = _PService.update(p);
                        c.enqueue(new Callback<Person>() {
                            @Override
                            public void onResponse(Call<Person> call, Response<Person> response) {
                                Person newP = response.body();
                                _People.remove(pers);
                                _People.add(newP);
                                RefreshList(_People);
                            }
                            @Override
                            public void onFailure(Call<Person> call, Throwable t) {
                                call.cancel();
                            }
                        });
                    }
                    Person d = data.getParcelableExtra("deletedPerson");
                    if (d!=null){
                        Call<Person> c = _PService.delete(Long.toString(d.getId()));
                        c.enqueue(new Callback<Person>() {
                            @Override
                            public void onResponse(Call<Person> call, Response<Person> response) {
                                Person deleted = response.body();
                                _People.remove(pers);
                                RefreshList(_People);
                            }
                            @Override
                            public void onFailure(Call<Person> call, Throwable t) {
                                call.cancel();
                            }
                        });
                    }

                }
            }
        });
    }

    private void RefreshList(List<Person> people) {
        adapter = new PersonAdapter((ArrayList<Person>) people, MainActivity.this);
        ListView peopleList = findViewById(R.id.peopleList);
        peopleList.setAdapter(adapter);
        /*
        peopleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Person dataModel= people.get(position);

            }
        });

         */
    }

}