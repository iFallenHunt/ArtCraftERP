module com.tecsolucoes.monamour {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tecsolucoes.monamour to javafx.fxml;
    exports com.tecsolucoes.monamour;
}