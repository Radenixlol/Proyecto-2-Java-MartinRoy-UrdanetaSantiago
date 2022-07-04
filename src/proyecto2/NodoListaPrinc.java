/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author Santiago Urdaneta
 */
public class NodoListaPrinc {

    private NodoListaPrinc next;
    private String title;
    private String text;
    private String[] authors;
    private String[] key_words;

    public NodoListaPrinc(String title, String text, String[] authors, String[] key_words) {
        this.next = null;
        this.title = title;
        this.text = text;
        this.authors = authors;
        this.key_words = key_words;
    }
    
    /**
     * @return the next
     */
    public NodoListaPrinc getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(NodoListaPrinc next) {
        this.next = next;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the authors
     */
    public String[] getAuthors() {
        return authors;
    }

    /**
     * @param authors the authors to set
     */
    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    /**
     * @return the key_words
     */
    public String[] getKey_words() {
        return key_words;
    }

    /**
     * @param key_words the key_words to set
     */
    public void setKeys(String[] key_words) {
        this.key_words = key_words;
    }

}
