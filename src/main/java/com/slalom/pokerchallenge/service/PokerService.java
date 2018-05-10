package com.slalom.pokerchallenge.service;

import com.slalom.pokerchallenge.objects.Card;
import com.slalom.pokerchallenge.objects.PokerHand;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PokerService {

    private String response = "high card";

    public String processHand(PokerHand pokerHand) {
        List<Card> cards = pokerHand.getCards();
        if (straightFlush(cards)) {
            response = "straight flush";
        } else if (fourKind(cards)) {
            response = "four of a kind";
        } else if (fullHouse(cards)) {
            response = "full house";
        } else if (flush(cards)) {
            response = "flush";
        } else if (straight(cards)) {
            response = "straight";
        } else if (threeKind(cards)) {
            response = "three of a kind";
        } else if (twoPair(cards)) {
            response = "two pair";
        } else if (onePair(cards)) {
            response = "one pair";
        }

        return response;
    }

    public Map<Integer, Integer> rankCounts(List<Card> cards) {
        Map<Integer, Integer> rankCounts = new HashMap<>();

        for (int i = 2; i < 15; i++) {
            rankCounts.put(i, 0);
        }
        for(Card card: cards) {
            rankCounts.put(card.getRank(), rankCounts.get(card.getRank()) + 1);
        }

        return rankCounts;
    }

    public boolean straightFlush(List<Card> cards) {
        boolean sameSuit = true;
        boolean seq = true;
        Card card;
        Card nextCard;

        for (int i = 0; i < cards.size() - 1; i++) {
            card = cards.get(i);
            nextCard = cards.get(i+1);
            sameSuit = sameSuit && (card.getSuit().equals(nextCard.getSuit()));
            seq = seq && (card.getRank() == nextCard.getRank() - 1);
        }

        return sameSuit && seq;
    }

    public boolean fourKind(List<Card> cards) {
        Map<Integer, Integer> rankCounts = rankCounts(cards);
        return (rankCounts.containsValue(4));
    }

    public boolean fullHouse(List<Card> cards) {
        Map<Integer, Integer> rankCounts = rankCounts(cards);
        return (rankCounts.containsValue(3) && rankCounts.containsValue(2));
    }

    public boolean flush(List<Card> cards) {
        boolean sameSuit = true;
        Card card;
        Card nextCard;
        for (int i = 0; i < cards.size() - 1; i++) {
            card = cards.get(i);
            nextCard = cards.get(i+1);
            sameSuit = sameSuit && (card.getSuit().equals(nextCard.getSuit()));
        }
        return sameSuit;
    }

    public boolean straight(List<Card> cards) {
        boolean seq = true;
        Card card;
        Card nextCard;
        for (int i = 0; i < cards.size() - 1; i++) {
            card = cards.get(i);
            nextCard = cards.get(i+1);
            seq = seq && (card.getRank() == nextCard.getRank() - 1);
        }
        return seq;
    }

    public boolean threeKind(List<Card> cards) {
        Map<Integer, Integer> rankCounts = rankCounts(cards);
        return (rankCounts.containsValue(3));
    }

    public boolean twoPair(List<Card> cards) {
        int numCount = 0;
        Map<Integer, Integer> rankCounts = rankCounts(cards);
        Collection<Integer> values = rankCounts.values();
        for (Integer value: values) {
            if (value == 2) {
                numCount++;
            }
        }
        return numCount == 2;
    }

    public boolean onePair(List<Card> cards) {
        int numCount = 0;
        Map<Integer, Integer> rankCounts = rankCounts(cards);
        Collection<Integer> values = rankCounts.values();
        for (Integer value: values) {
            if (value == 2) {
                numCount++;
            }
        }
        return numCount == 1;
    }


}
