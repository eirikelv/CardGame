package edu.ntnu.idatt2001.cardgame.eirielv.cardgame;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Eirik Elvestad
 */
public class CardGameController implements Initializable {
    DeckOfCards deckOfCards = new DeckOfCards();


    @FXML
    private TextField sumOfTheFaces;

    @FXML
    private TextField flush;

    @FXML
    private TextField cardsOfHeart;

    @FXML
    private TextField queenOfSpades;

    @FXML
    private ImageView card1;

    @FXML
    private ImageView card2;

    @FXML
    private ImageView card3;

    @FXML
    private ImageView card4;

    @FXML
    private ImageView card5;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    /**
     * dealHand deals hands to the dealer table. If there already exist cards on the table, the method clears the table
     * and deals a new hand of cards
     */
    @FXML
    public void dealHand() {
        if(deckOfCards.getHandOfCard() == null){
            deckOfCards.dealHand(5);
        }
        else {
            deckOfCards.getHandOfCard().clear();
            deckOfCards.dealHand(5);
        }
        showHandsOfCards();
    }

    /**
     * checkHand gives checkHand button functions. Where the function is to sum the faces on the table, check for flush
     * check for queen of spades, and show all cards with heart
     */
    @FXML
    public void checkHand(){
        setSumOfTheFaces();
        setFlush();
        setCardsOfHeart();
        setQueenOfSpades();
    }

    /**
     * setSumOfTheFaces sets the textfield to hold the sum of all faces
     */
    @FXML
    public void setSumOfTheFaces(){
        sumOfTheFaces.setText(deckOfCards.sumOfFaces());
    }

    /**
     * setFlush sets the textfield to have yes or no, depending on if there is a flush or not
     */
    @FXML
    public void setFlush(){
        flush.setText(deckOfCards.flushCheck());
    }

    /**
     * setCardsOfHeart sets the testfield to hold all names of the cards with hearts ass String
     */
    @FXML
    public void setCardsOfHeart(){
        StringBuilder sb = new StringBuilder();
        for(String cardOfHeart : deckOfCards.cardOfHeartCheck()) {
            sb.append(cardOfHeart).append(" ");
        }
        cardsOfHeart.setText(sb.toString());
    }

    /**
     * setQueenOfSpades sets the text to the textfield to say yes or no based on if there exists a queenOfSpades on the
     * table
     */
    @FXML
    public void setQueenOfSpades(){
        queenOfSpades.setText(deckOfCards.queenOfSpades());
    }

    /**
     * showHandsOfCards combines the Strings in the handOfCards arrayList with the images in the resource folder that
     * holds png's of the cards
     */
    @FXML
    public void showHandsOfCards(){
        card1.setImage(new Image("/edu/ntnu/idatt2001/cardgame/eirielv/cardgame/ImageOfCards/" + deckOfCards.getHandOfCard().get(0).getAsString() + ".png"));
        card2.setImage(new Image("/edu/ntnu/idatt2001/cardgame/eirielv/cardgame/ImageOfCards/" + deckOfCards.getHandOfCard().get(1).getAsString() + ".png"));
        card3.setImage(new Image("/edu/ntnu/idatt2001/cardgame/eirielv/cardgame/ImageOfCards/" + deckOfCards.getHandOfCard().get(2).getAsString() + ".png"));
        card4.setImage(new Image("/edu/ntnu/idatt2001/cardgame/eirielv/cardgame/ImageOfCards/" + deckOfCards.getHandOfCard().get(3).getAsString() + ".png"));
        card5.setImage(new Image("/edu/ntnu/idatt2001/cardgame/eirielv/cardgame/ImageOfCards/" + deckOfCards.getHandOfCard().get(4).getAsString() + ".png"));
    }

}
