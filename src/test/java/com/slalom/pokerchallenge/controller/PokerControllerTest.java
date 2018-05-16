package com.slalom.pokerchallenge.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PokerControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    public void apiCall(String body, String result) throws Exception {
        mockMvc.perform(post("/cards")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .string(result));
    }

    @Test
    public void testStraightFlush() throws Exception {
        apiCall("{\n" +
                "\t\"hand\": [\n" +
                "\t\t{\"rank\": \"3\", \"suit\": \"s\"},\n" +
                "\t\t{\"rank\": \"2\", \"suit\": \"s\"},\n" +
                "\t\t{\"rank\": \"A\", \"suit\": \"s\"},\n" +
                "\t\t{\"rank\": \"5\", \"suit\": \"s\"},\n" +
                "\t\t{\"rank\": \"4\", \"suit\": \"s\"}\n" +
                "\t\t]\n" +
                "}", "straight flush");
    }

    @Test
    public void testFourKind() throws Exception {
        apiCall("{\n" +
                "\t\"hand\": [\n" +
                "\t\t{\"rank\": \"A\", \"suit\": \"s\"},\n" +
                "\t\t{\"rank\": \"A\", \"suit\": \"d\"},\n" +
                "\t\t{\"rank\": \"A\", \"suit\": \"h\"},\n" +
                "\t\t{\"rank\": \"A\", \"suit\": \"c\"},\n" +
                "\t\t{\"rank\": \"5\", \"suit\": \"s\"}\n" +
                "\t\t]\n" +
                "}", "four of a kind");
    }

    @Test
    public void testFullHouse() throws Exception {
        apiCall("{\n" +
                "\t\"hand\": [\n" +
                "\t\t{\"rank\": \"A\", \"suit\": \"s\"},\n" +
                "\t\t{\"rank\": \"A\", \"suit\": \"d\"},\n" +
                "\t\t{\"rank\": \"A\", \"suit\": \"h\"},\n" +
                "\t\t{\"rank\": \"5\", \"suit\": \"c\"},\n" +
                "\t\t{\"rank\": \"5\", \"suit\": \"s\"}\n" +
                "\t\t]\n" +
                "}", "full house");
    }

    @Test
    public void testFlush() throws Exception {
        apiCall("{\n" +
                "\t\"hand\": [\n" +
                "\t\t{\"rank\": \"7\", \"suit\": \"s\"},\n" +
                "\t\t{\"rank\": \"4\", \"suit\": \"s\"},\n" +
                "\t\t{\"rank\": \"6\", \"suit\": \"s\"},\n" +
                "\t\t{\"rank\": \"K\", \"suit\": \"s\"},\n" +
                "\t\t{\"rank\": \"J\", \"suit\": \"s\"}\n" +
                "\t\t]\n" +
                "}", "flush");
    }

    @Test
    public void testStraight() throws Exception {
        apiCall("{\n" +
                "\t\"hand\": [\n" +
                "\t\t{\"rank\": \"8\", \"suit\": \"s\"},\n" +
                "\t\t{\"rank\": \"9\", \"suit\": \"c\"},\n" +
                "\t\t{\"rank\": \"J\", \"suit\": \"s\"},\n" +
                "\t\t{\"rank\": \"T\", \"suit\": \"h\"},\n" +
                "\t\t{\"rank\": \"Q\", \"suit\": \"d\"}\n" +
                "\t\t]\n" +
                "}", "straight");
    }

    @Test
    public void testThreeKind() throws Exception {
        apiCall("{\n" +
                "\t\"hand\": [\n" +
                "\t\t{\"rank\": \"8\", \"suit\": \"s\"},\n" +
                "\t\t{\"rank\": \"8\", \"suit\": \"c\"},\n" +
                "\t\t{\"rank\": \"7\", \"suit\": \"s\"},\n" +
                "\t\t{\"rank\": \"T\", \"suit\": \"h\"},\n" +
                "\t\t{\"rank\": \"8\", \"suit\": \"d\"}\n" +
                "\t\t]\n" +
                "}", "three of a kind");
    }

    @Test
    public void testTwoPairs() throws Exception {
        apiCall("{\n" +
                "\t\"hand\": [\n" +
                "\t\t{\"rank\": \"8\", \"suit\": \"s\"},\n" +
                "\t\t{\"rank\": \"8\", \"suit\": \"c\"},\n" +
                "\t\t{\"rank\": \"7\", \"suit\": \"s\"},\n" +
                "\t\t{\"rank\": \"T\", \"suit\": \"h\"},\n" +
                "\t\t{\"rank\": \"7\", \"suit\": \"d\"}\n" +
                "\t\t]\n" +
                "}", "two pairs");
    }

    @Test
    public void testOnePair() throws Exception {
        apiCall("{\n" +
                "\t\"hand\": [\n" +
                "\t\t{\"rank\": \"8\", \"suit\": \"s\"},\n" +
                "\t\t{\"rank\": \"Q\", \"suit\": \"c\"},\n" +
                "\t\t{\"rank\": \"K\", \"suit\": \"s\"},\n" +
                "\t\t{\"rank\": \"T\", \"suit\": \"h\"},\n" +
                "\t\t{\"rank\": \"8\", \"suit\": \"d\"}\n" +
                "\t\t]\n" +
                "}", "one pair");
    }

    @Test
    public void testHighCard() throws Exception {
        apiCall("{\n" +
                "\t\"hand\": [\n" +
                "\t\t{\"rank\": \"8\", \"suit\": \"s\"},\n" +
                "\t\t{\"rank\": \"A\", \"suit\": \"c\"},\n" +
                "\t\t{\"rank\": \"3\", \"suit\": \"s\"},\n" +
                "\t\t{\"rank\": \"2\", \"suit\": \"h\"},\n" +
                "\t\t{\"rank\": \"T\", \"suit\": \"d\"}\n" +
                "\t\t]\n" +
                "}", "high card");
    }


}