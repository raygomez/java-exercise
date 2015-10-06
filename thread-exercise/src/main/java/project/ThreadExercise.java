package project;

/**
 * Hello world!
 *
 */
public class ThreadExercise
{
    public static void main( String[] args )
    {
        SleepingThread threadA = new SleepingThread("A", 5);
        SleepingThread threadB = new SleepingThread("B", 7);
        SleepingThread threadC = new SleepingThread("C", 6);

        threadA.start();
        threadB.start();
        threadC.start();

    }
}
