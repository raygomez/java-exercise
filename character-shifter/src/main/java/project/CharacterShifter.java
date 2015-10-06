package project;

import java.io.IOException;
import java.lang.System;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CharacterShifter
{

    void shift(String filename) {
        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get(filename)));
        } catch(IOException exp){
            System.out.println("Unable to read file.");
        }
        System.out.println(content);
    }


    public static void main( String[] args )
    {
        CharacterShifter shifter =  new CharacterShifter();

        System.out.println(System.getProperty("user.dir"));

    }
}
