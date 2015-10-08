package project;

import java.io.*;

class CharacterShifter
{

    private void shift(String input, String output, int offset) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(input));
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output)));
            String line;

            while ((line = reader.readLine()) != null) {

                for (int i = 0; i < line.length(); i++) {
                    writer.write((char) (line.charAt(i) + offset));
                }
                writer.write('\n');
            }

            reader.close();
            writer.close();

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

    }

    public static void main( String[] args )
    {
        CharacterShifter shifter =  new CharacterShifter();
        shifter.shift("input.txt", "output.txt", 3);
    }
}
