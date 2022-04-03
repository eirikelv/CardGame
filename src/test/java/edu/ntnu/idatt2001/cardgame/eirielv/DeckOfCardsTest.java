package edu.ntnu.idatt2001.cardgame.eirielv;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class DeckOfCardsTest {

    @Test
    void getHandOfCard_returns_correct_array() {
        DeckOfCards deckOfCards = new DeckOfCards();
        assertEquals(deckOfCards.dealHand(5), deckOfCards.getHandOfCard());
    }

    @Nested
    class DealHand{
        @Test
        void Test_if_dealHand_gives_a_hand_of_cards_with_5_cards () {
            DeckOfCards deckOfCards = new DeckOfCards();
            deckOfCards.dealHand(5);
            assertEquals(5, deckOfCards.getHandOfCard().size());
        }

        @Test
        void Tests_if_dealHand_dont_det_duplicates () {
            DeckOfCards deckOfCards = new DeckOfCards();
            ArrayList<PlayingCard> testListe = new ArrayList<>();
            Boolean run = true;
            deckOfCards.dealHand(5);
            for (int i = 0; i < 5; i++) {
                if (!testListe.contains(deckOfCards.getHandOfCard().get(i))) {
                    testListe.add(deckOfCards.getHandOfCard().get(i));
                }

            }
            assertEquals(deckOfCards.getHandOfCard().size(), testListe.size());
        }
    }

    @Test
    void sumOfFaces_return_the_correct_sum_of_faces() {
        DeckOfCards deckOfCards = new DeckOfCards();

        PlayingCard card1 = new PlayingCard('H', 5);
        deckOfCards.getHandOfCard().add(card1);
        PlayingCard card2 = new PlayingCard('H', 10);
        deckOfCards.getHandOfCard().add(card2);
        PlayingCard card3 = new PlayingCard('D', 5);
        deckOfCards.getHandOfCard().add(card3);
        PlayingCard card4 = new PlayingCard('S', 5);
        deckOfCards.getHandOfCard().add(card4);
        PlayingCard card5 = new PlayingCard('C', 5);
        deckOfCards.getHandOfCard().add(card5);

        String testSum = "30";

        assertEquals(deckOfCards.sumOfFaces(),testSum);
    }

    @Nested
    class Flush_check {

        @Test
        void Test_if_flushCheck_returns_yes_if_deck_of_cards_has_flush() {
            DeckOfCards deckOfCards = new DeckOfCards();
            PlayingCard card1 = new PlayingCard('H', 1);
            deckOfCards.getHandOfCard().add(card1);
            PlayingCard card2 = new PlayingCard('H', 4);
            deckOfCards.getHandOfCard().add(card2);
            PlayingCard card3 = new PlayingCard('H', 8);
            deckOfCards.getHandOfCard().add(card3);
            PlayingCard card4 = new PlayingCard('H', 10);
            deckOfCards.getHandOfCard().add(card4);
            PlayingCard card5 = new PlayingCard('H', 12);
            deckOfCards.getHandOfCard().add(card5);
            String flush = deckOfCards.flushCheck();
            assertSame("Yes", flush);
        }

        @Test
        void Test_if_flushCheck_returns_no_if_deck_of_cards_dont_have_flush(){
            DeckOfCards deckOfCards = new DeckOfCards();
            PlayingCard card1 = new PlayingCard('S', 1);
            deckOfCards.getHandOfCard().add(card1);
            PlayingCard card2 = new PlayingCard('C', 4);
            deckOfCards.getHandOfCard().add(card2);
            PlayingCard card3 = new PlayingCard('D', 8);
            deckOfCards.getHandOfCard().add(card3);
            PlayingCard card4 = new PlayingCard('H', 11);
            deckOfCards.getHandOfCard().add(card4);
            PlayingCard card5 = new PlayingCard('S', 12);
            deckOfCards.getHandOfCard().add(card5);
            String flush = deckOfCards.flushCheck();
            assertSame("No", flush);
        }
    }

    @Nested
    class Card_of_heart_check {

        @Test
        void CardOfHeartCheck_returns_correct_hearts_on_table() {
            DeckOfCards deckOfCards = new DeckOfCards();
            List<String> testList = new ArrayList<>();

            PlayingCard card1 = new PlayingCard('H', 1);
            deckOfCards.getHandOfCard().add(card1);
            PlayingCard card2 = new PlayingCard('H', 4);
            deckOfCards.getHandOfCard().add(card2);
            PlayingCard card3 = new PlayingCard('H', 8);
            deckOfCards.getHandOfCard().add(card3);
            PlayingCard card4 = new PlayingCard('C', 4);
            deckOfCards.getHandOfCard().add(card4);
            PlayingCard card5 = new PlayingCard('D', 8);
            deckOfCards.getHandOfCard().add(card5);

            testList.add(0,"H1");
            testList.add(1,"H4");
            testList.add(2,"H8");

            assertEquals(deckOfCards.cardOfHeartCheck(),testList);
        }

        @Test
        void CardOfHeartCheck_returns_nothing_if_no_hearts(){
            DeckOfCards deckOfCards = new DeckOfCards();

            PlayingCard card1 = new PlayingCard('S', 1);
            deckOfCards.getHandOfCard().add(card1);
            PlayingCard card2 = new PlayingCard('C', 4);
            deckOfCards.getHandOfCard().add(card2);
            PlayingCard card3 = new PlayingCard('D', 8);
            deckOfCards.getHandOfCard().add(card3);
            PlayingCard card4 = new PlayingCard('S', 11);
            deckOfCards.getHandOfCard().add(card4);
            PlayingCard card5 = new PlayingCard('S', 12);
            deckOfCards.getHandOfCard().add(card5);

            assertTrue(deckOfCards.cardOfHeartCheck().isEmpty());
        }
    }
    @Nested
    class queenOfSpades {
        @Test
        void queenOfSpades_returns_yes_if_there_is_a_queen_of_spades_on_table() {
            DeckOfCards deckOfCards = new DeckOfCards();

            PlayingCard card1 = new PlayingCard('S', 12);
            deckOfCards.getHandOfCard().add(card1);
            PlayingCard card2 = new PlayingCard('C', 4);
            deckOfCards.getHandOfCard().add(card2);
            PlayingCard card3 = new PlayingCard('D', 8);
            deckOfCards.getHandOfCard().add(card3);
            PlayingCard card4 = new PlayingCard('S', 11);
            deckOfCards.getHandOfCard().add(card4);
            PlayingCard card5 = new PlayingCard('S', 10);
            deckOfCards.getHandOfCard().add(card5);

            String queenOfSpadesYes = deckOfCards.queenOfSpades();
            assertTrue(queenOfSpadesYes.equals("Yes"));
        }

        @Test
        void queenOfSpades_returns_no_if_there_is_no_queen_of_spades_on_table() {
            DeckOfCards deckOfCards = new DeckOfCards();

            PlayingCard card1 = new PlayingCard('H', 12);
            deckOfCards.getHandOfCard().add(card1);
            PlayingCard card2 = new PlayingCard('C', 4);
            deckOfCards.getHandOfCard().add(card2);
            PlayingCard card3 = new PlayingCard('D', 8);
            deckOfCards.getHandOfCard().add(card3);
            PlayingCard card4 = new PlayingCard('S', 11);
            deckOfCards.getHandOfCard().add(card4);
            PlayingCard card5 = new PlayingCard('S', 10);
            deckOfCards.getHandOfCard().add(card5);

            String queenOfSpadesYes = deckOfCards.queenOfSpades();
            assertTrue(queenOfSpadesYes.equals("No"));
        }
    }
}