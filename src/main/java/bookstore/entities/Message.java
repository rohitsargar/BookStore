
package bookstore.entities;


public class Message {
    private String conatent;
    private String type;
    private String cssclass;

    public Message(String conatent, String type, String cssclass) {
        this.conatent = conatent;
        this.type = type;
        this.cssclass = cssclass;
    }

    public String getConatent() {
        return conatent;
    }

    public void setConatent(String conatent) {
        this.conatent = conatent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCssclass() {
        return cssclass;
    }

    public void setCssclass(String cssclass) {
        this.cssclass = cssclass;
    }
    
 
    
    
}
