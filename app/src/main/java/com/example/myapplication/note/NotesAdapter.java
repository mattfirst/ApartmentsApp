package com.example.myapplication.note;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteViewHolder>{

    private List<Note> notes;
    private  NotesListener notesListener;

    public NotesAdapter(List<Note> notes) {

        this.notes = notes;

    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NoteViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_container_note,parent,false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {

        holder.setNote(notes.get(position));


    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    static class NoteViewHolder extends RecyclerView.ViewHolder{

        TextView textTitle,textSubtitle,textDate;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);

            textTitle = itemView.findViewById(R.id.textTitle);
            textSubtitle = itemView.findViewById(R.id.textSubtitle);
            textDate = itemView.findViewById(R.id.textDate);
        }

        void setNote (Note note){

            textTitle.setText(note.getTitle());
            if(note.getSubtitle().trim().isEmpty()){

                textSubtitle.setVisibility(View.GONE);

            }else {
                textSubtitle.setVisibility(View.VISIBLE);
                textSubtitle.setText(note.getSubtitle());

            }
            textDate.setText(note.getDateTime());

        }
    }
}
