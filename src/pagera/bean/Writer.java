package pagera.bean;

public class Writer {
   
    private String name = "No Name has given";
    private String mail = "No Mail has given";
    private String webAddress = "No Web Address has given";
    private String description = "No Description has given" ;
    
    public Writer() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
