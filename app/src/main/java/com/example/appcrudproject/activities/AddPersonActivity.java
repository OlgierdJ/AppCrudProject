package com.example.appcrudproject.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.appcrudproject.R;
import com.example.appcrudproject.entities.Person;

public class AddPersonActivity extends BaseActivity {

    private Person newPerson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newPerson = new Person();
        setContentView(R.layout.activity_add_person);
        Button cancel = findViewById(R.id.btnCancel);
        cancel.setOnClickListener(e->{
                Intent inte = this.getIntent();
                setResult(RESULT_OK, inte);
                finish();
        });
        Button add = findViewById(R.id.btnAddPers);
        add.setOnClickListener(e->{
            EditText emailF = findViewById(R.id.addEmail);
            EditText nameF = findViewById(R.id.addName);
            EditText phoneF = findViewById(R.id.addNumber);
            EditText noteF = findViewById(R.id.addNote);
            CheckBox chkb = findViewById(R.id.chxBox);
            newPerson.setId(0);
            newPerson.setEmail(emailF.getText().toString());
            newPerson.setName(nameF.getText().toString());
            newPerson.setPhoneNumber(phoneF.getText().toString());
            newPerson.setNote(noteF.getText().toString());
            newPerson.setFavorite(chkb.isChecked());
            if (newPerson.getId()==0
                    && newPerson.getEmail()!=null && !newPerson.getEmail().isEmpty()
                    && newPerson.getName()!=null && !newPerson.getName().isEmpty()
                    && newPerson.getPhoneNumber()!=null && !newPerson.getPhoneNumber().isEmpty()
                    && newPerson.getNote()!=null && !newPerson.getNote().isEmpty()){
                Intent inte = this.getIntent();// new Intent();
                inte.putExtra("newPerson",newPerson);
                setResult(RESULT_OK, inte);
                finish();
            }
        });
    }
}