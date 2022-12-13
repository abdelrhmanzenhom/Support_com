package com.example.fourth_task;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HabitsAdabter extends RecyclerView.Adapter<HabitsAdabter.HabitsViewholder> {
    List<Habit> habitsList=new ArrayList<>();

    public List<Habit> setHabitsList(List<Habit> habitsList) {
        this.habitsList = habitsList;
        return habitsList;
    }

    @NonNull
    @Override
    public HabitsAdabter.HabitsViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.habit_item,parent,false);
        return new HabitsViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HabitsAdabter.HabitsViewholder holder, int position) {
holder.namee.setText(habitsList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return habitsList.size();
    }

    public class HabitsViewholder extends RecyclerView.ViewHolder {
        TextView namee;
        public HabitsViewholder(@NonNull View itemView) {

            super(itemView);
             namee=itemView.findViewById(R.id.textView2);
        }
    }
}
