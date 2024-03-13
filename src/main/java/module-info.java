module be.ugent.objprog.ugentopoly {
    requires javafx.controls;
    requires javafx.fxml;
    requires be.ugent.objprog.dice;

    opens be.ugent.objprog.ugentopoly to javafx.fxml;
    exports be.ugent.objprog.ugentopoly;
}