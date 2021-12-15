package com.example.seminarproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VocabCardAdapter extends RecyclerView.Adapter<VocabCardAdapter.ViewHolder>{

    private List<VocabCard> vocabcards;

    public VocabCardAdapter(List<VocabCard> vocabcards){
        this.vocabcards = vocabcards;
    }

    @NonNull
    @Override
    public VocabCardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View vocabcardView = inflater.inflate(R.layout.item_vocabcard, parent, false);
        ViewHolder viewHolder =  new ViewHolder(vocabcardView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VocabCard vocabcard = vocabcards.get(position);

        holder.textView_word.setText(vocabcard.getWord());
        holder.textView_definition.setText(vocabcard.getDefinition());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), VocabCardInfo.class);
                intent.putExtra("spanish word", vocabcard.getWord());
                intent.putExtra("definition", vocabcard.getDefinition());
                intent.putExtra("english word", vocabcard.getEngword());
                intent.putExtra("phrase", vocabcard.getPhrase());
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return vocabcards.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView textView_word;
        TextView textView_definition;

        public ViewHolder(View itemView){
            super(itemView);
            textView_word = itemView.findViewById(R.id.textView_word);
            textView_definition = itemView.findViewById(R.id.textView_definition);
        }
    }
}
