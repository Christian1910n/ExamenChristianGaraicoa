package com.example.examen_christiangaraicoa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examen_christiangaraicoa.databinding.ListItemBinding;

import java.util.Objects;

public class Adapter extends ListAdapter<products,Adapter.ProEqViewHolder> {



    protected Adapter() {
        super(DIFF_CALLBACK);
    }

    public static final DiffUtil.ItemCallback<products> DIFF_CALLBACK=new DiffUtil.ItemCallback<products>() {
        @Override
        public boolean areItemsTheSame(@NonNull products oldItem, @NonNull products newItem) {
            return Objects.equals(oldItem.getId(), newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull products oldItem, @NonNull products newItem) {
            return oldItem.equals(newItem);
        }
    };

    private OnItemClickListener onItemClickListener;

    interface OnItemClickListener{
        void onItemClick(products products);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }
    @NonNull
    @Override
    public Adapter.ProEqViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemBinding binding= ListItemBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new ProEqViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ProEqViewHolder holder, int position) {
        products products= getItem(position);
        holder.bind(products);
    }

    public class ProEqViewHolder extends RecyclerView.ViewHolder {
        private ListItemBinding binding;
        public ProEqViewHolder(@NonNull ListItemBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }

        public void bind(products products){
            binding.txtnombre.setText(String.valueOf(products.getName()));
            binding.txtprice.setText(String.valueOf(products.getPrice()));

            binding.getRoot().setOnClickListener(v -> {
                onItemClickListener.onItemClick(products);
            });

            binding.executePendingBindings();
        }
    }
}
