import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTacToeFX extends Application {

    private Button[][] buttons = new Button[3][3];
    private char currentPlayer = 'X';

    @Override
    public void start(Stage stage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button = new Button();
                button.setMinSize(80, 80);
                button.setOnAction(e -> handleMove(button));
                grid.add(button, j, i);
                buttons[i][j] = button;
            }
        }

        Scene scene = new Scene(grid, 240, 240);
        stage.setScene(scene);
        stage.show();
    }

    private void handleMove(Button button) {
        int row = -1;
        int col = -1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j] == button) {
                    row = i;
                    col = j;
                }
            }
        }

        if (row >= 0 && row < 3 && col >= 0 && col < 3 && button.getText().isEmpty()) {
            button.setText(String.valueOf(currentPlayer));
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
