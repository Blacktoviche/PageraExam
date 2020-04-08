package pagera.bean;

import java.io.Serializable;

import java.util.LinkedList;
import java.util.List;


public class Question implements Serializable 
{
    
    private String question;
    private List<Answer> answers = new LinkedList<Answer>();
    private String mode;
    private int answersCount;
    public static final String MULTI = "multi";
    public static final String SINGLE = "single";
    private String note;
    
    public Question()
    {
    
    }
    
    public void setQuestion(String question)
    {
        this.question = question;
    }

    public String getQuestion()
    {
        return question;
    }

    public void setAnswers(List<Answer> answers)
    {
        this.answers = answers;
    }

    public List<Answer> getAnswers()
    {
        return answers;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return mode;
    }

    public void setAnswersCount(int answersCount) {
        this.answersCount = answersCount;
    }

    public int getAnswersCount() {
        return answersCount;
    }
}
