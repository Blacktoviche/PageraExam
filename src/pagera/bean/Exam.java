package pagera.bean;

import java.util.LinkedList;
import java.util.List;

public class Exam
{
    
    private String name;
    private int time;
    private int average;
    private List<Question> questionsList = new LinkedList<Question>();
    private Writer writer = new Writer();
    private int questionsCount;
    
    public Exam()
    {
     
     
    
    
    
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    public int getAverage() {
        return average;
    }

    public void setQuestionsList(List<Question> questionsList) {
        this.questionsList = questionsList;
    }

    public List<Question> getQuestionsList() {
        return questionsList;
    }


    public void setQuestionsCount(int questionsCount)
    {
        this.questionsCount = questionsCount;
    }

    public int getQuestionsCount()
    {
        return questionsCount;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    public Writer getWriter() {
        return writer;
    }
}
