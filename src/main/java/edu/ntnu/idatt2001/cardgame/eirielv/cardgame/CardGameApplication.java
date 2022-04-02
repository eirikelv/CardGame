package edu.ntnu.idatt2001.cardgame.eirielv.cardgame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CardGameApplication extends Application{


    public static void main(String[] args) {
        launch(args);
    }
    /**
     * Stating method with starting screen
     * @param stage starting stage
     * @throws Exception when path not found
     */
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/edu/ntnu/idatt2001/cardgame/eirielv/cardgame/view/CardGameView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("CardGame");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * {@inheritDoc}
     * @throws Exception
     */
    @Override
    public void init() throws Exception{
        super.init();
    }

    /**
     * {@inheritDoc}
     * @throws Exception
     */
    @Override
    public void stop() throws Exception{
        super.stop();
    }
}
