package com.slalom.pokerchallenge.service;

import com.slalom.pokerchallenge.objects.Card;
import com.slalom.pokerchallenge.objects.PokerHand;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class CardService {

    private PokerHand pokerHand = new PokerHand();

    public List<Card> getAllCards() {

        return pokerHand.getCards();
    }

    public PokerHand processCards(List<Map> hand) {
        Card[] cards = new Card[5];
        int idx = 0;
        for (Map card: hand) {
            String rank = String.valueOf(card.get("rank"));
            String suit = String.valueOf(card.get("suit"));
            cards[idx] = new Card(
                            rank,
                            suit
            );
            idx++;
        }
        Arrays.sort(cards);
        pokerHand.setCards(Arrays.asList(cards));
        return pokerHand;
    }

}
