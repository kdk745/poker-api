package com.slalom.pokerchallenge.objects;

public class PokerHand {

    Card[] cards;
    String hand;

    public PokerHand() {

    }

    // initialize an instance of the PokerHand class
    public PokerHand(Card[] cards) {
        super();
        // rank maps to integer value
        this.cards = cards;
    }

    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    public String getHand() {
        return hand;
    }

    public void setHand(String hand) {
        this.hand = hand;
    }
}
