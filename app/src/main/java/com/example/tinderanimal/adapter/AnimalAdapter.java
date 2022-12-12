package com.example.tinderanimal.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tinderanimal.R;
import com.example.tinderanimal.animalPage;
import com.example.tinderanimal.model.Animal;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder> {

    Context context;
    List<Animal> animals;

    public AnimalAdapter(Context context, List<Animal> animals) {
        this.context = context;
        this.animals = animals;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View animalItems = LayoutInflater.from((context)).inflate(R.layout.animals_layout, parent, false);
        return new AnimalAdapter.AnimalViewHolder(animalItems);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, @SuppressLint("RecyclerView") int position) {
        int imgID = context.getResources().getIdentifier(animals.get(position).getImg(),"drawable", context.getPackageName());
        holder.animalImg.setImageResource(imgID);
        holder.animalTitle.setText(animals.get(position).getTitle());
        holder.descriptionAnimal.setText(animals.get(position).getDescription());


        holder.buttonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, animalPage.class);

                intent.putExtra("imgA", imgID);
                intent.putExtra("titleA", animals.get(position).getTitle());
                intent.putExtra("descA", animals.get(position).getDescription());
                intent.putExtra("numA", animals.get(position).getNumber());
                intent.putExtra("mailA", animals.get(position).getMail());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    public static  final class AnimalViewHolder extends RecyclerView.ViewHolder{

        ImageView animalImg;
        TextView animalTitle, descriptionAnimal;
        ImageButton buttonClick;

        public AnimalViewHolder(@NonNull View itemView) {
            super(itemView);

            buttonClick = itemView.findViewById(R.id.buttonCloseAnimal);
            animalImg = itemView.findViewById(R.id.animalIMG);
            animalTitle = itemView.findViewById(R.id.nameAnimal);
            descriptionAnimal = itemView.findViewById(R.id.descriptionAnimal);
        }
    }

}
