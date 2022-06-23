package com.example.loginfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.container) != null)
        {
            if(savedInstanceState!=null)
            {
                return;
            }
            FragmentManager fragmentManager= getSupportFragmentManager();
            fragmentManager.beginTransaction().add(R.id.container, new MyFragment(),null).commit();
        }


    }



}