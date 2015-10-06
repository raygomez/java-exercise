package project;

/**
 * Hello world!
 *
 */
public class ExceptionExercise
{
    public static void main( String[] args )
    {
        try {
            throw new MyException();
        } catch (MyException e) {
            System.out.println("Handled " + e.getClass().getSimpleName());
        }

    }
}
