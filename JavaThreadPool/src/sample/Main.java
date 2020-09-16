package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.robot.Robot;
import javafx.stage.Stage;

import java.util.concurrent.*;


public class Main extends Application {

    private ExecutorService service = Executors.newFixedThreadPool(5);
    private BlockingQueue<Robots> robotsQue = new ArrayBlockingQueue<>(5);

    @Override
    public void start(Stage primaryStage) throws Exception{
//        System.out.println("Hello world");
//
//        for(int i = 0; i < 10 ; i ++){
//            Runnable obj = new MyRunnable("MyWorkerThread "+i);
//            service.execute(obj);
//        }
//
//        service.shutdown();
//        while (!service.isTerminated()){}
//
//        System.out.println("All threads have completed ");

        CreateRobots cr = new CreateRobots();
        Thread producer = new Thread(cr, "producer");
        producer.start();

        for(int i = 0; i < 8 ; i ++){
            //Runnable obj = new MyRunnable("MyWorkerThread "+i);
            //service.execute(obj);
            WorkRobots wr = new WorkRobots(cr);
            service.execute(wr);
        }
        service.shutdown();
        while (!service.isTerminated()){}

        System.out.println("All threads have completed ");


    }


    public static void main(String[] args) {
        launch(args);
    }
}
