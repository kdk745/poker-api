package com.slalom.pokerchallenge.controller;

import com.slalom.pokerchallenge.objects.Card;
import com.slalom.pokerchallenge.service.CardService;
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

    @Autowired
    private CardService cardService;

    @RequestMapping("/cards")
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }

    @RequestMapping(method = RequestMethod.POST, value="/cards")
    public void processCards(@RequestBody Map<String, List<Map>> payload) throws Exception {
        List<Card> message = cardService.processCards(payload.get("hand"));
        System.out.println(message);
    }
}
