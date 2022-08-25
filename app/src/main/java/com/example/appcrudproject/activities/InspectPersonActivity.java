package com.example.appcrudproject.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.appcrudproject.R;
import com.example.appcrudproject.entities.Person;

public class InspectPersonActivity extends BaseActivity {

    private Person Person;
    private TextView idF;
    private EditText emailF;
    private EditText nameF;
    private EditText phoneF;
    private EditText noteF;
    private CheckBox chkb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspect_person);
        Person = this.getIntent().getParcelableExtra("person");
         idF = findViewById(R.id.viewId);
         idF.setText(Long.toString(Person.getId()));
         emailF = findViewById(R.id.editEmail);
         emailF.setText(Person.getEmail());
         nameF = findViewById(R.id.editName);
        nameF.setText(Person.getName());
         phoneF = findViewById(R.id.editNumber);
        phoneF.setText(Person.getPhoneNumber());
         noteF = findViewById(R.id.editNote);
        noteF.setText(Person.getNote());
         chkb = findViewById(R.id.editchxBox);
         chkb.setChecked(Person.getFavorite());
        Button cancel = findViewById(R.id.btnCancel);
        cancel.setOnClickListener(e->{
            Intent inte = this.getIntent();
            setResult(RESULT_OK, inte);
            finish();
        });
        Button add = findViewById(R.id.btnUpdatePers);
        Button delete = findViewById(R.id.btnDeletePers);
        delete.setOnClickListener(e->{
            Intent inte = this.getIntent();// new Intent();
            inte.putExtra("deletedPerson",Person);
            setResult(RESULT_OK, inte);
            finish();
        });
        add.setOnClickListener(e->{

            Person.setEmail(emailF.getText().toString());
            Person.setName(nameF.getText().toString());
            Person.setPhoneNumber(phoneF.getText().toString());
            Person.setNote(noteF.getText().toString());
            Person.setFavorite(chkb.isChecked());
            if (Person.getId()>0
                    && Person.getEmail()!=null && !Person.getEmail().isEmpty()
                    && Person.getName()!=null && !Person.getName().isEmpty()
                    && Person.getPhoneNumber()!=null && !Person.getPhoneNumber().isEmpty()
                    && Person.getNote()!=null && !Person.getNote().isEmpty()){
                Intent inte = this.getIntent();// new Intent();
                inte.putExtra("updatedPerson",Person);
                setResult(RESULT_OK, inte);
                finish();
            }
        });
    }
}