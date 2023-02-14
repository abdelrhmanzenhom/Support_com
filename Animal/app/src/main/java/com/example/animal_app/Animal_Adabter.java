package com.example.animal_app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Animal_Adabter extends RecyclerView.Adapter<Animal_Adabter.AnimalViewHolder> {
  private   List<Animal> AnimalsList=new ArrayList<>();

private Context context;
    public Animal_Adabter(Context context,List<Animal> animalsList) {
        this.context=context;
        AnimalsList = animalsList;

    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.the_animal,parent,false);
        return new AnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Animal_Adabter.AnimalViewHolder holder, int position) {
        holder.namee.setText(AnimalsList.get(position).getName());
        holder.family.setText(AnimalsList.get(position).getFamily());
        holder.age.setText(""+AnimalsList.get(position).getAge());



    }

    @Override
    public int getItemCount() {
        return AnimalsList.size();
    }

    public class AnimalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
private TextView namee,family,age;
        public AnimalViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            namee=itemView.findViewById(R.id.TV_name);
            family=itemView.findViewById(R.id.TV_family);
            age=itemView.findViewById(R.id.TV_age);
        }

        @Override
        public void onClick(View view) {
            int pos=getAdapterPosition();
            Intent tent=new Intent(context,AnimalDetails.class);
            tent.putExtra("name",AnimalsList.get(pos).getName());
            tent.putExtra("family",AnimalsList.get(pos).getFamily());
            context.startActivity(tent);


        }
    }
}
