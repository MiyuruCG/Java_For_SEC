package sample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkRobots implements Runnable {

    CreateRobots cr;
    private ExecutorService service = Executors.newFixedThreadPool(5);
    //private int num;

    public WorkRobots(CreateRobots cr){
        this.cr = cr;
    }

   // private void changeNum(int i){ num = i; }
    @Override
    public void run() {

        try {
            Robots rs = cr.getRobot();
            service.execute(()->{
                int val = rs.getValue();
                for (int i=0;i<3;i++){

                    System.out.println("My value: "+val+i);
                }
                return;
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
