/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

/**
 *
 * @author Santiago Urdaneta
 */
public class NodoListaSecun {

    private NodoListaSecun next;
    private String[] elementos;
    private String title;

    public NodoListaSecun(String[] elementos) {
        this.next = null;
        this.elementos = elementos;
        this.title = title;
    }

    public NodoListaSecun getNext() {
        return next;
    }

    public void setNext(NodoListaSecun next) {
        this.next = next;
    }

    public String[] getElementos() {
        return elementos;
    }

    public void setElementos(String[] elementos) {
        this.elementos = elementos;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
