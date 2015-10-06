package project;

/**
 * Hello world!
 *
 */
public class ThreadExercise
{
    public static void main( String[] args )
    {
        SleepingThread thread1 = new SleepingThread(5);
        thread1.start();
    }
}
