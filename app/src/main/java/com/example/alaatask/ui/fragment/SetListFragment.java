package com.example.alaatask.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.alaatask.R;
import com.example.alaatask.databinding.FragmentSetListBinding;
import com.example.alaatask.viewmodel.ListFragmentViewModel;


public class SetListFragment extends Fragment {
    private FragmentSetListBinding mBinding;
    private ListFragmentViewModel mViewModel;

    public static SetListFragment newInstance() {
        SetListFragment fragment = new SetListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ListFragmentViewModel.class);
        registerObserver();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_set_list, container, false);

        return mBinding.getRoot();
    }

    private void registerObserver() {
        mViewModel.getSetsMutableLiveData().observe(this, sets -> {

        });
    }
}