package edu.ntnu.idatt2001.cardgame.eirielv.cardgame;

import java.util.*;
import java.util.stream.IntStream;

public class DeckOfCards {
    private final char[] suit = {'S','H','D','C'};
    private final int numberOfFace = 13;
    private List<PlayingCard> deckOfCards;
    private List<PlayingCard> handOfCard;
    private Random random = new Random();


    public DeckOfCards() {
        this.deckOfCards = new ArrayList<>();

        IntStream.range(0, numberOfFace).forEach(p -> deckOfCards.add(new PlayingCard(suit[0], (p % numberOfFace)+1)));
        IntStream.range(0, numberOfFace).forEach(p -> deckOfCards.add(new PlayingCard(suit[1], (p % numberOfFace)+1)));
        IntStream.range(0, numberOfFace).forEach(p -> deckOfCards.add(new PlayingCard(suit[2], (p % numberOfFace)+1)));
        IntStream.range(0, numberOfFace).forEach(p -> deckOfCards.add(new PlayingCard(suit[3], (p % numberOfFace)+1)));
    }

    public List<PlayingCard> dealHand(int n){
        this.handOfCard = new ArrayList<>();
        random.ints(n,0,52).forEach(r ->
                {
                    if (!handOfCard.contains(deckOfCards.get(r))){
                        handOfCard.add(deckOfCards.get(r));
                    }
                    else {
                        handOfCard.add(deckOfCards.get(random.nextInt(52)));
                    }
                }
        );

        return handOfCard;
    }

    public String sumOfFaces(){
        return String.valueOf(handOfCard.stream().map(PlayingCard::getFace).reduce(0, Integer::sum));
    }

    public String flushCheck(){
        List<PlayingCard> sortedList;
        sortedList = handOfCard.stream().sorted(Comparator.comparing(PlayingCard::getSuit)).toList();

        if(sortedList.get(0).equals(sortedList.get(4))){
            return "Yes";
        }
        return "No";
    }

    public List<String> cardOfHeartCheck(){
        return handOfCard.stream().filter(card -> card.getSuit() == 'H').map(card -> card.getAsString()).toList();
    }

    public String queenOfSpades(){
        if(handOfCard.stream().anyMatch(card -> card.getAsString().equals("S12"))){
            return "Yes";
        }
         return "No";
    }

    public List<PlayingCard> getHandOfCard(){
        return handOfCard;
    }




}
