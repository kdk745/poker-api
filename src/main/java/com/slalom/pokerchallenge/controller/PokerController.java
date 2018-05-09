package com.slalom.pokerchallenge.controller;

import com.slalom.pokerchallenge.objects.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class PokerController {

    @RequestMapping("/cards")
    public List<Card> getAllCards() {

        Card[] results = {
                new Card("7", "c"),
                new Card("3", "h"),
                new Card("2", "s"),
                new Card("A", "d"),
                new Card("5", "c")
        };

        // sorts the cards in ascending order
        Arrays.sort(results);

        return Arrays.asList(results);
    }
}
