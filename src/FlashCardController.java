import java.io.File;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class FlashCardController {
    int i = 0;

    ArrayList<QuestionsAnswers> ourLoadedQuestionAnswers = new ArrayList<QuestionsAnswers>();
    public void initialize(){
        FileManager fileManager = new FileManager();
        ourLoadedQuestionAnswers = fileManager.loadQAFromFile(new File("src/QuestionAnswers.txt"));
        textArea.setText(ourLoadedQuestionAnswers.get(i).getQuestion());
        textArea.setEditable(false);
        nextQuestion.setDisable(true);
    }

    @FXML
    private Button button;

    @FXML
    private Button nextQuestion;

    @FXML
    private TextArea textArea;

    @FXML
    void buttonPressed(ActionEvent event) throws Exception {
        textArea.setText(ourLoadedQuestionAnswers.get((i)).getAnswer());
        i++;   
        button.setDisable(true);  
        nextQuestion.setDisable(false);
        if(i == ourLoadedQuestionAnswers.size()){
            nextQuestion.setText("Start Again!");
            i = 0;
        }   

    }

    @FXML
    void nextQuestionPressed(ActionEvent event) {
        textArea.setText(ourLoadedQuestionAnswers.get(i).getQuestion());
        nextQuestion.setDisable(true);
        button.setDisable(false);
    }


}
