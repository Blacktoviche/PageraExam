package pagera.logic.tables;


public class ColumnData
{

  private String  title;
  private int   width;
  private int  alignment;

 

  public ColumnData(String title, int width, int alignment)
  {
    this.title = title;
    this.width = width;
    this.alignment = alignment;
  }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setAlignment(int alignment) {
        this.alignment = alignment;
    }

    public int getAlignment() {
        return alignment;
    }
}
