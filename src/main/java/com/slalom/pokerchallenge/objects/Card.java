package com.slalom.pokerchallenge.objects;

import java.util.Map;
import static java.util.Map.entry;

public class Card implements Comparable<Card> {

    private Integer rank;
    private String suit;

    // ranks will map to corresponding integer for sorting purposes
    private static final Map<String, Integer> ranks = Map.ofEntries(
            entry("2", 2),
            entry("3", 3),
            entry("4", 4),
            entry("5", 5),
            entry("6", 6),
            entry("7", 7),
            entry("8", 8),
            entry("9", 9),
            entry("T", 10),
            entry("J", 11),
            entry("Q", 12),
            entry("K", 13),
            entry("A", 14)
    );

    public Card() {

    }

    // initialize an instance of the Card class
    public Card(String rank, String suit) {
        super();
        // rank maps to integer value
        this.rank = this.ranks.get(rank);
        this.suit = suit;
    }

    @Override
    public int compareTo(Card other) {
        return this.rank.compareTo(other.rank);
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

}
