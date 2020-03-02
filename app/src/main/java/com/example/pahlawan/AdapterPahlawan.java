package com.example.pahlawan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterPahlawan extends RecyclerView.Adapter<AdapterPahlawan.PahlawanViewHolder> {

    private Context context;
    private ArrayList<ModelPahlawan> list;
    private OnItemClikCallback onItemClikCallback;

    public AdapterPahlawan(Context context) {
        this.context = context;
    }

    public ArrayList<ModelPahlawan> getList() {
        return list;
    }

    public void setList(ArrayList<ModelPahlawan> list) {
        this.list = list;
    }

    public void setOnItemClikCallback(OnItemClikCallback onItemClikCallback) {
        this.onItemClikCallback = onItemClikCallback;
    }

    @NonNull
    @Override
    public PahlawanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pahlawan,parent,false);
        return new PahlawanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PahlawanViewHolder holder, int position) {
        Glide.with(context).load(getList().get(position).getImage()).into(holder.ivfoto);
        holder.tvnama.setText(getList().get(position).getName());
        holder.tvDesc.setText(getList().get(position).getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClikCallback.onItemCliked(list.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return getList().size();
    }

    public class PahlawanViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivfoto;
        private TextView tvnama, tvDesc;
        public PahlawanViewHolder(@NonNull View itemView) {
            super(itemView);
            ivfoto = itemView.findViewById(R.id.iv_foto);
            tvnama = itemView.findViewById(R.id.tv_nama);
            tvDesc = itemView.findViewById(R.id.tv_deskrip);
        }
    }

    public interface OnItemClikCallback{
        void onItemCliked(ModelPahlawan pahlawan);
    }
}
