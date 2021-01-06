package edu.gsu.GUI;

import java.io.FileNotFoundException;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.collections.*;
import javafx.concurrent.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.*;
import javafx.util.Duration;

public class Main extends Application {

    public static final String SPLASH_IMAGE = "BoBoLogo.jpg";

    private Pane splashLayout;
    private ProgressBar loadProgress;
    private Label progressText;
    private static final int SPLASH_WIDTH = 1260;

    public static void main(String [] args) throws Exception {

        launch(args);

    }

    @Override
    public void init() throws FileNotFoundException {

        ImageView splash = new ImageView(new Image(SPLASH_IMAGE));

        loadProgress = new ProgressBar();
        loadProgress.setPrefWidth(SPLASH_WIDTH);
        progressText = new Label("BoBo Airline is loading....");
        splashLayout = new VBox();
        splashLayout.getChildren().addAll(splash, loadProgress, progressText);
        progressText.setAlignment(Pos.CENTER);
        splashLayout.setStyle(
                "-fx-padding: 5; " +
                        "-fx-background-color: #f0f8ff; " +
                        "-fx-border-width:5; " +
                        "-fx-border-color: " +
                        "linear-gradient(to bottom, #3b5998, derive(#3b5998, 50%));"
        );

        splashLayout.setEffect(new DropShadow());

    }

    @Override
    public void start(final Stage initStage) throws Exception {
        Task<ObservableList<String>> mainMenu = new Task<ObservableList<String>>() {
            @Override
            protected ObservableList<String> call() throws InterruptedException {

                ObservableList<String> loadingMenu = FXCollections.<String>observableArrayList();
                ObservableList<String> loadingScreen = FXCollections.observableArrayList("0%", "9%", "16%", "23%", "32%","39%", "44%", "53%", "64%","76%", "88%", "94%", "100%");

                updateMessage("BoBo Airline is loading....");

                for (int i = 0; i < loadingScreen.size(); i++) {

                    Thread.sleep(400);
                    updateProgress(i + 1, loadingScreen.size());
                    String nextLoading = loadingScreen.get(i);
                    loadingMenu.add(nextLoading);
                    updateMessage("BoBo Airline is loading...." + nextLoading);
                }

                Thread.sleep(400);
                updateMessage("Loading Complete.");

                return loadingMenu;

            }
        };

        showSplash(initStage, mainMenu, () -> showMainStage(mainMenu.valueProperty()));
        new Thread(mainMenu).start();

    }

    private void showMainStage(ReadOnlyObjectProperty<ObservableList<String>> mainMenu) {

        try {
            StartingPanel sp = new StartingPanel();

            sp.start(new Stage());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void showSplash(final Stage initStage, Task<?> task, InitCompletionHandler initCompletionHandler) {
        progressText.textProperty().bind(task.messageProperty());
        loadProgress.progressProperty().bind(task.progressProperty());
        task.stateProperty().addListener((observableValue, oldState, newState) -> {
            if (newState == Worker.State.SUCCEEDED) {
                loadProgress.progressProperty().unbind();
                loadProgress.setProgress(1);
                initStage.toFront();
                FadeTransition fadeSplash = new FadeTransition(Duration.seconds(1.2), splashLayout);
                fadeSplash.setFromValue(1.0);
                fadeSplash.setToValue(0.0);
                fadeSplash.setOnFinished(actionEvent -> initStage.hide());
                fadeSplash.play();

                initCompletionHandler.complete();
            } // todo add code to gracefully handle other task states.
        });

        Scene splashScene = new Scene(splashLayout, Color.TRANSPARENT);
        initStage.setScene(splashScene);
        initStage.initStyle(StageStyle.TRANSPARENT);
        initStage.setAlwaysOnTop(true);
        initStage.show();
    }

    public interface InitCompletionHandler {
        void complete();
    }
}
