package com.example.alaatask.ui.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alaatask.R;
import com.example.alaatask.databinding.FragmentSetListBinding;
import com.example.alaatask.data.model.Data;
import com.example.alaatask.network.AlaaTvApi;
import com.example.alaatask.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SetListFragment extends Fragment {
    private FragmentSetListBinding mBinding;
//    private Retrofit mRetrofit = RetrofitInstance.getRetrofitInstance();
//    private AlaaTvApi mTvApi;

    public static SetListFragment newInstance() {
        SetListFragment fragment = new SetListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mTvApi = mRetrofit.create(AlaaTvApi.class);
//        Call<Data> Call;
//
//        Call = mTvApi.getAllData();
//        Call.enqueue(new Callback<Data>() {
//            @Override
//            public void onResponse(retrofit2.Call<Data> call, Response<Data> response) {
//                if (response.isSuccessful()){
//                    Log.d("MAJID","YES");
//                }
//                Log.d("MAJID","YESs");
//            }
//
//            @Override
//            public void onFailure(retrofit2.Call<Data> call, Throwable t) {
//                Log.d("MAJID","NO",t);
//            }
//        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_set_list, container, false );

        return mBinding.getRoot();
    }
}