package com.example.soosofficeregistrationwizard_cards;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<MainActivity.Person> mDataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        MaterialCardView cv;
        TextView personName;
        TextView personAge;
        ImageView personPhoto;
        SeekBar seekBar;

        public MyViewHolder(View itemView) {
            super(itemView);

            cv = itemView.findViewById(R.id.cv_myTextView_cv);
            personName = itemView.findViewById(R.id.person_name);
            personAge = itemView.findViewById(R.id.person_age);
            personPhoto = itemView.findViewById(R.id.person_photo);
            seekBar = itemView.findViewById(R.id.sb_myTextView_elevation);
        }

    }

    public MyAdapter(List<MainActivity.Person> myDataSet) {
        super();
        mDataSet = myDataSet;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_text_view, parent, false);

        MyViewHolder vh = new MyViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        holder.cv.setCardElevation(100);
        holder.cv.setMinimumWidth(400);

        ImageView iv = holder.personPhoto;
        TextView nameView = holder.personName;
        TextView ageView = holder.personAge;
        SeekBar sb = holder.seekBar;

        String personName = "soosoft CEO";
        String personAge = "69 years.";

        nameView.setText(personName);
        ageView.setText(personAge);
        iv.setImageResource(mDataSet.get(position).photoId);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                MyLog.d(progress + " is the progress");
                holder.cv.setCardElevation(progress);
                MyLog.d(holder.cv.getCardElevation() + " is the elevation");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
