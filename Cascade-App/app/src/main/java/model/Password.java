package model;

/**
 * Created by Vlad on 5/1/2015.
 */
public class Password {

    private String text = "";

    public Password(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
