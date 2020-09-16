package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main extends Application {

    ExecutorService service = Executors.newFixedThreadPool(5);

    @Override
    public void start(Stage primaryStage) throws Exception{
        System.out.println("Hello world");

        for(int i = 0; i < 10 ; i ++){
            Runnable obj = new MyRunnable("MyWorkerThread "+i);
            service.execute(obj);
        }

        service.shutdown();
        while (!service.isTerminated()){}

        System.out.println("All threads have completed ");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
