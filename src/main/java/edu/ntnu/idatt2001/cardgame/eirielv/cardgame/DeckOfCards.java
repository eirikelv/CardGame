package edu.ntnu.idatt2001.cardgame.eirielv.cardgame;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author Eirik Elvestad
 */
public class DeckOfCards {
    private final char[] suit = {'S','H','D','C'};
    private final int numberOfFace = 13;
    private List<PlayingCard> deckOfCards;
    private List<PlayingCard> handOfCard;
    private Random random = new Random();

    /**
     * DeckOfCards() makes a ArryList deckOfCards, which holds StackOfCards, and connects faces with suit
     */
    public DeckOfCards() {
        this.deckOfCards = new ArrayList<>();

        IntStream.range(0, numberOfFace).forEach(p -> deckOfCards.add(new PlayingCard(suit[0], (p % numberOfFace)+1)));
        IntStream.range(0, numberOfFace).forEach(p -> deckOfCards.add(new PlayingCard(suit[1], (p % numberOfFace)+1)));
        IntStream.range(0, numberOfFace).forEach(p -> deckOfCards.add(new PlayingCard(suit[2], (p % numberOfFace)+1)));
        IntStream.range(0, numberOfFace).forEach(p -> deckOfCards.add(new PlayingCard(suit[3], (p % numberOfFace)+1)));
    }

    /**
     * List<> dealHand adds n random card from deckOfCards arrayList. If it finds a duplicate, dealHand takes a new card
     * @param n number of cards on the table
     * @return ArrayList handOfCard that holds the cards on the table
     */
    public List<PlayingCard> dealHand(int n){
        this.handOfCard = new ArrayList<>();
        random.ints(n,0,52).forEach(r ->
                {
                    if (!handOfCard.contains(deckOfCards.get(r))){
                    handOfCard.add(deckOfCards.get(r));
                }
                else {
                    handOfCard.add(deckOfCards.get(random.nextInt(52)));
                    System.out.println("fant duplicat");
                    }
                }
        );

        return handOfCard;
    }

    /**
     * sumOfFaces goes through all faces of playingcards on the table, and add them together
     * @return a integer represented ass string
     */
    public String sumOfFaces(){
        return String.valueOf(handOfCard.stream().map(PlayingCard::getFace).reduce(0, Integer::sum));
    }

    /**
     * flushCheck makes a list that sorts all cards on the table by the suit on the card, from a-z. If index 0 of the
     * sorted list is the same as index 4, it returns yes, or else it return no
     * @return String "yes" if it is a flush or string if not
     */
    public String flushCheck(){
        List<PlayingCard> sortedList;
        sortedList = handOfCard.stream().sorted(Comparator.comparing(PlayingCard::getSuit)).toList();

        if(sortedList.get(0).getSuit() == (sortedList.get(4).getSuit())){
            return "Yes";
        }
        return "No";
    }

    /**
     *cardOfHeartCheck filters through all cards on table and gets all that has H as suit, and then maps it to a list
     * with strings
     * @return All cards with H as suit represented as String, in a list
     */
    public List<String> cardOfHeartCheck(){
        return handOfCard.stream().filter(card -> card.getSuit() == 'H').map(card -> card.getAsString()).toList();
    }

    /**
     * queenOfSpades streams through the cards on the table and see if any card as string matches "S12". If one card
     * does match, the method returns Yes, if not, No
     * @return String "Yes" if a card is queen of spades, or String "No" if not
     */
    public String queenOfSpades(){
        if(handOfCard.stream().anyMatch(card -> card.getAsString().equals("S12"))){
            return "Yes";
        }
         return "No";
    }

    /**
     * This is a getter for handOfCard list
     * @return ArrayList handOfCard
     */
    public List<PlayingCard> getHandOfCard(){
        return handOfCard;
    }




}
