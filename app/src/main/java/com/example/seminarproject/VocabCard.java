package com.example.seminarproject;

public class VocabCard {
    private String word;
    private String definition;
    private String engword;
    private String phrase;

    public VocabCard(String word, String definition, String engword, String phrase){
        this.word = word;
        this.definition = definition;
        this.engword = engword;
        this.phrase = phrase;
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

    public String getEngword() {
        return engword;
    }

    public void setEngword(String engword) {
        this.engword = engword;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }
}
