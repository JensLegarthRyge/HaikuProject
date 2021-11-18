package Data;

import AnalysisEngine.HaikuPoem;

import java.io.*;

public class FileHandler {
    public void write(HaikuPoem haikuPoem){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Haiku Poem.csv", true));
            bufferedWriter.write(String.valueOf(haikuPoem));
            bufferedWriter.write("\n\n");
            bufferedWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
