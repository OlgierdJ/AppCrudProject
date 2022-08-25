package com.example.appcrudproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.appcrudproject.MainActivity;
import com.example.appcrudproject.R;
import com.example.appcrudproject.activities.BaseActivity;
import com.example.appcrudproject.entities.Person;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class PersonAdapter extends ArrayAdapter<Person> implements View.OnClickListener{

    private ArrayList<Person> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        LinearLayout Holder;
        TextView txtId;
        TextView txtName;
        TextView txtEmail;
        TextView txtPhone;
        TextView txtNote;
        CheckBox chkFavorite;
    }

    public PersonAdapter(ArrayList<Person> data, Context context) {
        super(context, R.layout.custom_item, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        Person dataModel=(Person)object;
        ((MainActivity)mContext).NavToPerson(dataModel);
        /*
        switch (v.getId())
        {
            case R.id.item_info:
                Snackbar.make(v, "Release date " +dataModel.getName(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
                break;
        }

         */
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Person dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.custom_item, parent, false);

            viewHolder.txtId = (TextView) convertView.findViewById(R.id.idField);
            viewHolder.Holder = (LinearLayout) convertView.findViewById(R.id.holder);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.nameField);
            viewHolder.txtEmail = (TextView) convertView.findViewById(R.id.emailField);
            viewHolder.txtPhone = (TextView) convertView.findViewById(R.id.phoneField);
            viewHolder.txtNote = (TextView) convertView.findViewById(R.id.noteField);
            viewHolder.chkFavorite = (CheckBox) convertView.findViewById(R.id.favoriteChk);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        viewHolder.txtId.setText(Long.toString(dataModel.getId()));
        viewHolder.txtName.setText(dataModel.getName());
        viewHolder.txtEmail.setText(dataModel.getEmail());
        viewHolder.txtPhone.setText(dataModel.getPhoneNumber());
        viewHolder.txtNote.setText(dataModel.getNote());
        viewHolder.chkFavorite.setChecked(dataModel.getFavorite());
        viewHolder.Holder.setOnClickListener(this);
        viewHolder.Holder.setTag(position);
        // Return the completed view to render on screen
        return convertView;
    }
}
