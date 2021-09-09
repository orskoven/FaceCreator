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
        drawBlossingCheeks(false,"rød");
        drawNose();
        drawShape();
        drawMouth();
        drawEyes();
        drawHair();

    }

    public static void drawShape() {
        //højre side ansigtsform
        gc.strokeLine(150,150,150,400);
        gc.strokeLine(150,400,200,500);
        gc.strokeLine(200,500,250,550);
        gc.strokeLine(250,550,275,575);
        gc.strokeLine(275,575,300,575);
        // venstre side ansigtsform
        gc.strokeLine(width - 150,150,width - 150,400);
        gc.strokeLine(width - 150,400,width - 200,500);
        gc.strokeLine(width - 200,500,width - 250,550);
        gc.strokeLine(width - 250,550,width - 275,575);
        gc.strokeLine(width - 275,575,width - 300,575);

    }

    public static void drawBlossingCheeks(boolean isBlussing, String cheekColor) {
        if (isBlussing == true) {
            if (cheekColor.equals("rød")) {
                gc.setFill(Color.RED);
                gc.fillOval(230, 220 + 100, 30, 30);
                gc.fillOval(370, 220 + 100, 30, 30);
            }
        }

    }

    public static void drawMouth() {
        System.out.println("Write your mood:");
        Scanner scanner = new Scanner(System.in);
        String moodInput = "sad";
        if (moodInput.equals("happy")) {
            gc.fillOval(220,370,200,100);
        } if (moodInput.equals("sad")) {
            gc.fillOval(300, 350 + 10, 10, 10);
            gc.setFill(Color.DEEPSKYBLUE);
            for (int i = 0; i < 600; i++) {
                gc.fillOval(220, 220 + 10 + i, 2, 2);
                gc.fillOval(width - 220 , 220 + 10 + i, 2, 2);
                gc.fillOval(220, 220 + 40 + i, 2, 2);
                gc.fillOval(width - 220, 220 + 50 + i, 2, 2);
                gc.fillOval(220, 220 + 70 + i, 2, 2);
                gc.fillOval(width - 220, 220 + 80 + i, 2, 2);
                gc.fillOval(220, 220 + 90 + i, 2, 2);
                gc.fillOval(width - 220, 220 + 100 + i, 2, 2);
            }


        }

    }
    public static  void drawNose(){
        Random random = new Random();
        int low1 = -15;
        int high1 = 10;
        int result2 = random.nextInt(high1 - low1) + low1;
        int low = -10;
        int high = 10;
        int result = random.nextInt(high - low) + low;
        gc.strokeLine(290+result2,300+result,290,310);
        gc.strokeLine(310,310+result,290,310);
    }
    public static void drawHair(){
        Random random = new Random();
        int low1 = 0;
        int high1 = 100;
        int result2 = random.nextInt(high1 - low1) + low1;
        int low = -5;
        int high = 100;
        int result = random.nextInt(high - low) + low;
        for (int i = 150; i < 300; i++){
            gc.strokeLine(i+0,150-result,450,150-result2);
            gc.strokeLine(450,150,450,150-result2);
            gc.strokeLine(i+0,150-result,150,150);
            i++;
        }
    }

    public static void drawEyes() {
        gc.setFill(Color.BLACK);
        gc.strokeLine(205,210,240,210);
        gc.strokeLine(width - 205,210,width - 240,210);
        gc.fillOval(220,220,20,20);
        gc.fillOval(360,220,20,20);
    }

    public static void main(String[] args) {
        launch();
        
    }
}