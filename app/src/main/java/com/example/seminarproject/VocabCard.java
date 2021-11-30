package com.example.seminarproject;

public class VocabCard {
    private String word;
    private String definition;

    public VocabCard(String word, String definition){
        this.word = word;
        this.definition = definition;
    }

    public String getWord(){
        return word;
    }

    public void setWord(String word){
        this.word = word;
    }

    public String getDefinition(){
        return definition;
    }
    public void setDefinition(){
        this.definition = definition;
    }
}
