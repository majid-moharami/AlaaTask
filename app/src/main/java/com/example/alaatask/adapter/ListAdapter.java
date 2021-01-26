package com.example.alaatask.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.example.alaatask.R;
import com.example.alaatask.databinding.ListItemBinding;
import com.example.alaatask.viewmodel.ListFragmentViewModel;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ItemHolder> {

    private ListFragmentViewModel mViewModel;
    private LifecycleOwner mOwner;

    public ListAdapter(ListFragmentViewModel viewModel, LifecycleOwner owner ) {
        mViewModel = viewModel;
        mOwner = owner;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemBinding itemListBinding = DataBindingUtil.inflate(
                LayoutInflater.from(mViewModel.getApplication()),
                R.layout.list_item ,
                parent,
                false );
        return new ListAdapter.ItemHolder(itemListBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        final int[] size = {0};
        mViewModel.getSetsMutableLiveData().observe( mOwner , sets -> {
            size[0] = sets.size();
        });
        return size[0];
    }

    class ItemHolder extends RecyclerView.ViewHolder {
        private ListItemBinding mItemListBinding;

        public ItemHolder(ListItemBinding itemListBinding) {
            super(itemListBinding.getRoot());
            mItemListBinding = itemListBinding;
            mItemListBinding.setViewModel(mViewModel);
        }

        public void onBind(int position) {
            mItemListBinding.setPosition(position);
            mItemListBinding.executePendingBindings();
        }
    }
}
