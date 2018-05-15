package com.slalom.pokerchallenge.controller;

import com.slalom.pokerchallenge.objects.Card;
import com.slalom.pokerchallenge.objects.PokerHand;
import com.slalom.pokerchallenge.service.CardService;
import com.slalom.pokerchallenge.service.PokerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cards")
public class PokerController {

    private CardService cardService;

    public PokerController(CardService cardService, PokerService pokerService) {
        this.cardService = cardService;
    }

    @GetMapping
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String processCards(@RequestBody Map<String, List<Map>> payload) throws Exception {
        List<Map> hand;
        hand = payload.get("hand");
        if (hand.size() != 5) {
            return "error in your input";
        }
        PokerHand pokerHand = cardService.processCards(hand);
        return pokerHand.getHand();
    }
}
