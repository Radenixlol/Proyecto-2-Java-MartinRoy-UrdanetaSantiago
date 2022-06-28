/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author Radenixlol
 */
public class Nodo {
    private Nodo next;
    private String title;
    private String text;
    private String[] authors;
    private String[] keys;
    
    public void CreaNodo(String title, String text, String[] authors, String[] keys){
        this.setNext(null);
        this.setTitle(title);
        this.setText(text);
        this.setAuthors(authors);
        this.setKeys(keys);
    }

    /**
     * @return the next
     */
    public Nodo getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(Nodo next) {
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
     * @return the keys
     */
    public String[] getKeys() {
        return keys;
    }

    /**
     * @param keys the keys to set
     */
    public void setKeys(String[] keys) {
        this.keys = keys;
    }
    
}
