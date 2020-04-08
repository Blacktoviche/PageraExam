package pagera.bean;

import java.io.Serializable;

public class Answer implements Serializable
{
   
    private String answer;
    private boolean state = false;
    
    public Answer()
    {
    
    }

    public void setAnswer(String answer)
    {
        this.answer = answer;
    }

    public String getAnswer()
    {
        return answer;
    }

    public void setState(boolean state)
    {
        this.state = state;
    }

    public boolean isRight()
    {
        return state;
    }
}
