package sample;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CreateRobots implements Runnable{

    private BlockingQueue<Robots> robotsQue = new ArrayBlockingQueue<>(5);

    @Override
    public void run() {

        for(int i = 1; i <= 10; i ++){
            Robots rs = new Robots("Robo"+i , i+10);
            try {
                robotsQue.put(rs);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public Robots getRobot() throws InterruptedException {
        return robotsQue.take();
    }

    public int getSize(){
        return robotsQue.size();
    }
}
