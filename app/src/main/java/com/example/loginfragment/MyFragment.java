package com.example.loginfragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;


public class MyFragment extends Fragment {


    public MyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        show_hide_password();
        setupViews();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my, container, false);
    }


    public void setupViews()
    {
        EditText CNICText;
        CNICText = (EditText) getView().findViewById(R.id.CNIC_field);
        CNICText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void afterTextChanged(Editable editable) {
                String value = CNICText.getText().toString();
                char[] ch= value.toCharArray();

                if (value.matches("^[0-9]{5}-[0-9]{7}-[0-9]$")) {
                    CNICText.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.ic_action_name) , null);
                }
                else {
                    CNICText.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);

                }

            }
        });
    }
    public void show_hide_password()
    {
        EditText etPassword= (EditText) getView().findViewById(R.id.password_field) ;
        ImageView iv_password = (ImageView) getView().findViewById(R.id.show_hide_password);
        iv_password.setImageResource(R.drawable.show_password_icon);
        iv_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etPassword.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())){
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    iv_password.setImageResource(R.drawable.hide_password_icon);
                }
                else
                {
                    etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    iv_password.setImageResource(R.drawable.show_password_icon);
                }
            }
        });
    }




}