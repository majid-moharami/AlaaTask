package com.example.alaatask.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;

import android.app.Activity;
import android.os.Bundle;

import com.example.alaatask.R;
import com.example.alaatask.databinding.ActivityMainBinding;
import com.example.alaatask.databinding.ActivityMainBindingImpl;
import com.example.alaatask.databinding.FragmentSetListBindingImpl;
import com.example.alaatask.ui.fragment.SetListFragment;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(mBinding.fragmrntContainer.getId(), SetListFragment.newInstance())
                .commit();
    }
}