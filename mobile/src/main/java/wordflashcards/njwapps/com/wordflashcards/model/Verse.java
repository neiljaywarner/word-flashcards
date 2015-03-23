package wordflashcards.njwapps.com.wordflashcards.model;

/**
 * Created by warner on 3/22/15.
 */
public class Verse {

    private String reference;
    private String text;
    //TODO: translation, but think this through re: freeform text, enum, db lookup, etc.
    public Verse(String reference, String text) {
        this.reference = reference;
        this.text = text;
    }

    public String getReference() {
        return reference;
    }

    public String getText() {
        return text;
    }
}
