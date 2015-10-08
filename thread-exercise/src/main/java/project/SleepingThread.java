package project;

class SleepingThread extends Thread{

    private int time;
    private final String name;

    public SleepingThread(String name, int sleepTime){
        this.time = sleepTime;
        this.name = name;
    }

    public void run() {

        while(time > 0) {
            System.out.println("Thread " + name + " is sleeping for " + time + " seconds.");
            try {
                Thread.sleep(time * 1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            time--;
        }
        System.out.println("Thread " + name + " is done sleeping.");
    }
}
