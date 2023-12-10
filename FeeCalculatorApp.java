import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FeeCalculatorApp extends Application {

    private static final double NATIONAL_FEE_RATE = 0.06; // 6%
    private static final double INTERNATIONAL_FEE_RATE = 0.03; // 3%

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Fee Calculator App");

        Label resultLabel = new Label("Result will be displayed here.");

        Button nationalButton = new Button("Calculate National Fee");
        nationalButton.setOnAction(e -> {
            double transactionAmount = 100.0; // Example transaction amount
            double fee = calculateFee(transactionAmount, false);
            resultLabel.setText("National Fee Applied: " + fee);
        });

        Button internationalButton = new Button("Calculate International Fee");
        internationalButton.setOnAction(e -> {
            double transactionAmount = 100.0; // Example transaction amount
            double fee = calculateFee(transactionAmount, true);
            resultLabel.setText("International Fee Applied: " + fee);
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(nationalButton, internationalButton, resultLabel);

        Scene scene = new Scene(layout, 300, 150);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private static double calculateFee(double amount, boolean isInternational) {
        double feeRate = isInternational ? INTERNATIONAL_FEE_RATE : NATIONAL_FEE_RATE;
        return amount * feeRate;
    }
}
