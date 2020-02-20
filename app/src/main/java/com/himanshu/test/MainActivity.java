package com.himanshu.test;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.widget.Toast;

import com.himanshu.test.databinding.ActivityMainBinding;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        FormViewModel formViewModel = new FormViewModel();
        binding.setFormViewModel(formViewModel);

        formViewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user.getuName().length() > 0 || user.getuAge().length() > 0)
                    Toast.makeText(getApplicationContext(), "Name : " + user.getuName() + " Age : " + user.getuAge(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
