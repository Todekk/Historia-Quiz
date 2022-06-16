package eu.todek.navigationtest;
import androidx.lifecycle.ViewModel;

public class QuestionsViewModel {
    private int currentQuestionIndex = 0;
    private int correctAnswers = 0;

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public void setCurrentQuestionIndex(int currentQuestionIndex) {
        this.currentQuestionIndex = currentQuestionIndex;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }

    public void incrementCorrectAnswers(){
        correctAnswers++;
    }

    public void incrementCurrentQuestion(){
        currentQuestionIndex++;
    }
}
