package sample;

public class MyRunnable implements Runnable {
    String name;

    public MyRunnable(String name){
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Thread " + name + " starting. ");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread " + name + " ends. ");
    }
}
