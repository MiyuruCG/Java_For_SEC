package com.miyurucg;

public class Main
{

    public static void main(String[] args) throws Exception
    {


        Thread t1 = new Thread(()-> {
            for(int i = 1;i<=5;i++){
                System.out.println("Hi "+Thread.currentThread().getPriority());
                try{Thread.sleep(1000);} catch(Exception e){System.out.println(e.getMessage());}
            }
        }, "Hi-Thread");
        Thread t2 = new Thread(()-> {
            for(int i = 1;i<=5;i++){
                System.out.println("Hello "+Thread.currentThread().getPriority());
                try{Thread.sleep(1000);} catch(Exception e){System.out.println(e.getMessage());}
            }
        }, "Hello-Thread");

//        System.out.println(t1.getName());
//        System.out.println(t2.getName());
//        t2.setPriority(Thread.MIN_PRIORITY);
//        t1.setPriority(Thread.MAX_PRIORITY);
//        System.out.println(t1.getPriority());
//        System.out.println(t2.getPriority());

        t1.start();
        try{Thread.sleep(10);} catch(Exception e){System.out.println(e.getMessage());}
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Bye");

    }
}
