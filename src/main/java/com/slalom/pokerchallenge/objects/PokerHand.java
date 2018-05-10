package com.slalom.pokerchallenge.objects;

import java.util.List;

public class PokerHand {

    List<Card> cards;
    String hand;

    public PokerHand() {

    }

    // initialize an instance of the PokerHand class
    public PokerHand(List<Card> cards) {
        super();
        // rank maps to integer value
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public String getHand() {
        return hand;
    }

    public void setHand(String hand) {
        this.hand = hand;
    }
}
