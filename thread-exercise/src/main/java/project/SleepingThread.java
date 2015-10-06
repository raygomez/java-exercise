package project;

public class SleepingThread extends Thread{

    int time;
    public SleepingThread(int sleepTime){
        time = sleepTime;
    }

    public void run() {
        System.out.println("Hello World!");
    }
}
