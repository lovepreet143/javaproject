import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {
    public ArrayList<QuestionsAnswers> loadQAFromFile(File file){

        ArrayList<QuestionsAnswers> quesAns = new ArrayList<QuestionsAnswers>();
        try (Scanner scan = new Scanner(file)) {
            while(scan.hasNextLine()){
                String[] separateQA = scan.nextLine().split("###");
                quesAns.add(new QuestionsAnswers(separateQA[0], separateQA[1]));
            }

            
        } catch (Exception e) {
            System.out.println("Oops, file not found");
        }
        return quesAns;
        
    }
}
