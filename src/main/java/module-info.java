module edu.ntnu.idatt2001.cardgame.eirielv.cardgame {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens edu.ntnu.idatt2001.cardgame.eirielv.cardgame to javafx.fxml;
    exports edu.ntnu.idatt2001.cardgame.eirielv.cardgame;
}