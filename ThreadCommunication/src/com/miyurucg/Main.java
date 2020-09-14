package com.miyurucg;

class Q{
    int num;
    boolean valueSet = false;

    //when using wait method need to use synchronized in the method
    public synchronized void put(int num)
    {
        while(valueSet)
        {
            try{wait();}catch (Exception e){}
        }
        System.out.println("Put " + num);
        this.num = num;
        valueSet = true;
        notify();//notify the consumers wait method

    }

    public synchronized void get(){
        while(!valueSet)
        {
            try{wait();}catch (Exception e){}
        }
        System.out.println("Get " + num);
        valueSet = false;
        notify(); //notify the producer (wait method)
    }
}

class Producer implements Runnable
{
    Q q;

    public Producer(Q q){
        this.q = q;
        Thread t1 = new Thread(this, "Producer");
        t1.start();
    }

    @Override
    public void run() {
        int i = 0;
        while(true){
            q.put(i++);
            try{
                Thread.sleep(500);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}

class Consumer implements Runnable{
    Q q;

    public Consumer( Q q){
        this.q = q;
        Thread t2 = new Thread(this, "Consumer");
        t2.start();
    }

    @Override
    public void run() {
        while(true){
            q.get();
            try{
                Thread.sleep(5000);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
    }
}
