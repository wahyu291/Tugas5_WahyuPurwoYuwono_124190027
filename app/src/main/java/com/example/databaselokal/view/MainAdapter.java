package com.example.databaselokal.view;

import android.content.Context;
import android.view. LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.databaselokal.R;
import com.example.databaselokal.entity. DataDesa;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.recyclerview.widget.RecyclerView;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewHolder> {
    Context context;
    List<DataKampus> list;
    MainContact.view mView;

    public MainAdapter(Context context, List<DataKampus> list, MainContact.view mView) {
        this.context = context;
        this.list = list;
        this.mView = mView;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_desa, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final DataKampus item = list.get(position);
        holder.tvNama.setText(item.getName());
        holder.tvAlamat.setText(item.getAddress());
        holder.tvJumlah.setText(item.getPenduduk());
        holder.id.setText(item.getId());
        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.editData(item);
            }
        });
        holder.cardView.setOnLongClickListener(new View.On LongClickListener() {
            @Override
            public boolean onLongClick (View view){
                mView.deleteData(item);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvAlamat, tvJumlah, id;
        CardView cardView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_item_nama);
            tvAlamat = itemView.findViewById(R.id.tv_item_alamat);
            tvJumlah = itemView.findViewById(R.id.tv_item_penduduk);
            id = itemView.findViewById(R.id.tv_item_id);
            cardView = itemView.findViewById(R.id.cv_item);
        }
    }
}