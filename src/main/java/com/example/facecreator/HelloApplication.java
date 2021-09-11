package com.example.facecreator;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class HelloApplication extends Application {
    static int width = 600;
    static int height = 600;
    static Canvas canvas = new Canvas(width, height);
    static GraphicsContext gc = canvas.getGraphicsContext2D();


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        Group root = new Group();
        Scene scene = new Scene(root, width, height);
        stage.setTitle("Face");
        stage.setScene(scene);

        gc.clearRect(0, 0, width, height);
        root.getChildren().add(canvas);

        drawPrimitiveFace();

        stage.show();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.1), event -> {
            gc.clearRect(0, 0, width, height);
            drawPrimitiveFace();
        }));
        timeline.setCycleCount(360);
        timeline.play();
    }

    public static void drawPrimitiveFace() {
        drawNose();
        drawShape(150, 150);
        drawMouth();
        drawEyes(1000, -1000);
        drawHair(100,-100);

    }

    public static void drawShape(int xvalue, int yvalue) {
        Random random = new Random();
        int low1 = -7;
        int high1 = 7;
        int result2 = random.nextInt(high1 - low1) + low1;
        Random random2 = new Random();
        int low = 0;
        int high = 2;
        int result = random2.nextInt(high - low) + low;
        //venstre side ansigtsform1
        gc.setLineWidth(5.);
        gc.strokeLine(xvalue, yvalue, 150 + result2, 400 + result2);
        gc.strokeLine(xvalue + result2, 400 + result2, 200 + result2, 500 + result2);
        gc.strokeLine(xvalue + 50 + result2, 500 + result2, 250 + result2, 550 + result2);
        gc.strokeLine(xvalue + 100 + result2, 550 + result2, 275 + result2, 575 + result2);
        gc.strokeLine(xvalue + 125 + result2, 575 + result2, 300 - result, 575 - result);
        // højre side ansigtsform
        gc.strokeLine(width - 150, 150, width - 150 - result2, 400 - result2);
        gc.strokeLine(width - 150 - result2, 400 - result2, width - 200 - result2, 500 - result2);
        gc.strokeLine(width - 200 - result2, 500 - result2, width - 250 - result2, 550 - result2);
        gc.strokeLine(width - 250 - result2, 550 - result2, width - 275 - result2, 575 - result2);
        gc.strokeLine(width - 275 - result2, 575 - result2, width - 300 - result, 575 - result);

    }


    public static void drawMouth() {
        Random random4 = new Random();
        int low4 = 100;
        int high4 = 150;
        int result4 = random4.nextInt(high4 - low4) + low4;
        gc.setFill(Color.LIGHTPINK);
        gc.fillOval(160 + result4, 350 + 10, 50, 10);
        Random random = new Random();
        int low1 = 0;
        int high1 = 600;
        int result2 = random.nextInt(high1 - low1) + low1;
        Random random2 = new Random();
        int low = -100;
        int high = 600;
        int result = random2.nextInt(high - low) + low;
        gc.setFill(Color.DEEPSKYBLUE);
        for (int j = 220 % 2; j < 400; j++) {
            gc.fillOval(230, 230 + result2, 2, result2);
            j++;
        }
        for (int i = 220; i < 400; i++) {
            gc.fillOval(width - 230, width - 230 + result, 2, result);
            i++;
        }
    }


    public static void drawNose() {
        Random random = new Random();
        int low1 = -20;
        int high1 = 10;
        int result2 = random.nextInt(high1 - low1) + low1;
        int low = -50;
        int high = 2;
        int result = random.nextInt(high - low) + low;
        gc.strokeLine(290 + result2, 300 + result, 290, 310);
        gc.strokeLine(310, 310 + result, 290, 310);
    }

    public static void drawHair(int high2,int low2) {
        Random random = new Random();
        int low1 = 0;
        int high1 = 150;
        int result2 = random.nextInt(high1 - low1) + low1;
        int low = -5;
        int high = 150;
        int result = random.nextInt(high - low) + low;
        int result3 = random.nextInt(high2 - low2) + low2;

        if (result3 > 999 && result3 < 000) {
            gc.setFill(Color.BLACK);
        } else if (result3 > 000 && result3 <= 100) {
            gc.setFill(Color.RED);
        } else if (result3 >= 100 && result3 <= 200) {
            gc.setFill(Color.YELLOW);
        }
        if (result3 >= 150 && result3 <= 600) {
            gc.setFill(Color.PALEVIOLETRED);
        } else if (result3 >= 30 && result3 <= 40) {
            gc.setFill(Color.CYAN);
        } else if (result3 >= 5 && result3 <= 9) {
            gc.setFill(Color.BROWN);
        }

            for (int i = 150; i < 300; i++) {
                gc.strokeLine(i + 0, 150 - result, 450, 150 - result2);
                gc.strokeLine(450, 150, 450, 150 - result2);
                gc.strokeLine(i + 0, 150 - result, 150, 150);
                i++;
            }
        }
        
        public static void drawEyes ( int high3, int low3){
            Random random = new Random();
            int result3 = random.nextInt(high3 - low3) + low3;
            if (result3 >= 999 && result3 <= 000) {
                gc.setFill(Color.BLACK);
            } else if (result3 > 000 && result3 <= 100) {
                gc.setFill(Color.RED);
            } else if (result3 >= 100 && result3 <= 200) {
                gc.setFill(Color.YELLOW);
            }
            if (result3 >= 150 && result3 <= 600) {
                gc.setFill(Color.PALEVIOLETRED);
            } else if (result3 >= 30 && result3 <= 40) {
                gc.setFill(Color.CYAN);
            } else if (result3 >= 5 && result3 <= 9) {
                gc.setFill(Color.BROWN);
            }

                gc.strokeLine(205, 210, 240, 210);
                gc.strokeLine(width - 205, 210, width - 240, 210);
                gc.fillOval(220, 220, 20, 20);
                gc.fillOval(360, 220, 20, 20);
            }



    public static void main(String[] args) {
        launch();

    }
}