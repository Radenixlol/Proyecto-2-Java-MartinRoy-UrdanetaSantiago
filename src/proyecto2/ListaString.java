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
public class ListaString {

    private NodoListaString first, last;
    private int size;

    public ListaString() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public boolean esVacio() {
        return first == null;
    }

    public void insertarFinal(NodoListaString NodoNuevo) {
        if (esVacio()) {
            first = NodoNuevo;
            last = NodoNuevo;
        } else {
            last.setNext(NodoNuevo);
            last = NodoNuevo;
        }
        size++;
    }

    /**
     * @return the first
     */
    public NodoListaString getFirst() {
        return first;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(NodoListaString first) {
        this.first = first;
    }

    /**
     * @return the last
     */
    public NodoListaString getLast() {
        return last;
    }

    /**
     * @param last the last to set
     */
    public void setLast(NodoListaString last) {
        this.last = last;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }
}
