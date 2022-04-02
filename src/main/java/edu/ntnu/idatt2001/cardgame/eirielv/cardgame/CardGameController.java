package edu.ntnu.idatt2001.cardgame.eirielv.cardgame;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.ResourceBundle;

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

    @FXML
    public void checkHand(){
        setSumOfTheFaces();
        setFlush();
        setCardsOfHeart();
        setQueenOfSpades();
    }

    @FXML
    public void setSumOfTheFaces(){
        sumOfTheFaces.setText(deckOfCards.sumOfFaces());
    }

    @FXML
    public void setFlush(){
        flush.setText(deckOfCards.flushCheck());
    }

    @FXML
    public void setCardsOfHeart(){
        StringBuilder sb = new StringBuilder();
        for(String cardOfHeart : deckOfCards.cardOfHeartCheck()) {
            sb.append(cardOfHeart).append(" ");
        }
        cardsOfHeart.setText(sb.toString());
    }

    @FXML
    public void setQueenOfSpades(){
        queenOfSpades.setText(deckOfCards.queenOfSpades());
    }

    @FXML
    public void showHandsOfCards(){
        card1.setImage(new Image("/edu/ntnu/idatt2001/cardgame/eirielv/cardgame/ImageOfCards/" + deckOfCards.getHandOfCard().get(0).getAsString() + ".png"));
        card2.setImage(new Image("/edu/ntnu/idatt2001/cardgame/eirielv/cardgame/ImageOfCards/" + deckOfCards.getHandOfCard().get(1).getAsString() + ".png"));
        card3.setImage(new Image("/edu/ntnu/idatt2001/cardgame/eirielv/cardgame/ImageOfCards/" + deckOfCards.getHandOfCard().get(2).getAsString() + ".png"));
        card4.setImage(new Image("/edu/ntnu/idatt2001/cardgame/eirielv/cardgame/ImageOfCards/" + deckOfCards.getHandOfCard().get(3).getAsString() + ".png"));
        card5.setImage(new Image("/edu/ntnu/idatt2001/cardgame/eirielv/cardgame/ImageOfCards/" + deckOfCards.getHandOfCard().get(4).getAsString() + ".png"));
    }

}
