package com.slalom.pokerchallenge.controller;

import com.slalom.pokerchallenge.objects.Card;
import com.slalom.pokerchallenge.objects.PokerHand;
import com.slalom.pokerchallenge.service.CardService;
import com.slalom.pokerchallenge.service.PokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class PokerController {

    private CardService cardService;
    private PokerService pokerService;

    @Autowired
    public PokerController(CardService cardService, PokerService pokerService) {
        this.cardService = cardService;
        this.pokerService = pokerService;
    }

    @RequestMapping("/cards")
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }

    @RequestMapping(method = RequestMethod.POST, value="/cards")
    public String processCards(@RequestBody Map<String, List<Map>> payload) throws Exception {
        PokerHand hand = cardService.processCards(payload.get("hand"));
        String result = pokerService.processHand(hand);
        return result;
    }
}
