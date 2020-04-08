package pagera.logic.tables;

public class MarkColumns
{
    
    
    private int qNum;
    private String mark;
    public static final String YES = "YES";
    public static final String NO = "NO";
    
    public MarkColumns(int n , String m)
    {
     
       qNum = n;
       mark = m;
    
    }

    public void setQNum(int qNum) {
        this.qNum = qNum;
    }

    public int getQNum() {
        return qNum;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }
}
