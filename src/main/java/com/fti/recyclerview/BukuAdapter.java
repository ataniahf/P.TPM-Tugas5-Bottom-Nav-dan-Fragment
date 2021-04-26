package com.fti.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BukuAdapter extends RecyclerView.Adapter<BukuAdapter.ViewHolder> {
    private Context context;
    private ArrayList<BukuModel> bukuModels;

    public BukuAdapter(ArrayList<BukuModel> listData, Context context) {
        this.bukuModels = listData;
        this.context = context;
    }

    public ArrayList<BukuModel> getBukuModels() {
        return bukuModels;
    }

    public void setBukuModels(ArrayList<BukuModel> bukuModels) {
        this.bukuModels = bukuModels;
    }

    @NonNull
    @Override
    public BukuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_buku,viewGroup,false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull BukuAdapter.ViewHolder viewHolder, int i){
        Glide.with(context).load(getBukuModels().get(i).getGambarBuku()).into(viewHolder.ivImageBuku);
        viewHolder.tvJudulBuku.setText(getBukuModels().get(i).getJudulBuku());
        viewHolder.tvHargaBuku.setText(getBukuModels().get(i).getHargaBuku());
        viewHolder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveIntent = new Intent(context, SinopsisActivity.class);
                moveIntent.putExtra("judulBuku", getBukuModels().get(i).getJudulBuku());
                moveIntent.putExtra("gambarBuku", getBukuModels().get(i).getGambarBuku());
                moveIntent.putExtra("sinopsisBuku",getBukuModels().get(i).getSinopsisBuku());
                moveIntent.putExtra("hargaBuku",getBukuModels().get(i).getHargaBuku());
                context.startActivity(moveIntent);
            }
        });

        viewHolder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                String shareSubject = getBukuModels().get(i).getJudulBuku();
                String shareBody = getBukuModels().get(i).getJudulBuku()+"\nHarga : Rp. "+ getBukuModels().get(i).getHargaBuku()+"\n" +getBukuModels().get(i).getSinopsisBuku();
                share.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
                share.putExtra(Intent.EXTRA_TEXT, shareBody);
                context.startActivity(Intent.createChooser(share, "Share Using"));
            }
        });
    }

    @Override
    public int getItemCount() {
        return getBukuModels().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivImageBuku;
        private TextView tvJudulBuku,tvHargaBuku;
        private Button btnDetail, btnShare;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            ivImageBuku = itemView.findViewById(R.id.ivGambarBuku);
            tvJudulBuku = itemView.findViewById(R.id.tvJudulBuku);
            tvHargaBuku = itemView.findViewById(R.id.tvHargaBuku);
            btnDetail = itemView.findViewById(R.id.btnDetail);
            btnShare = itemView.findViewById(R.id.btnShare);
        }

    }
}
