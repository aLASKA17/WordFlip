package org.a1aska17.model;

public class Flashcard {
    private String deck;
    private String term;
    private String answer;

    public Flashcard(String deck, String term, String answer) {
        this.deck = deck;
        this.term = term;
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public String getTerm() {
        return term;
    }

    public String getDeck() {
        return deck;
    }
}
