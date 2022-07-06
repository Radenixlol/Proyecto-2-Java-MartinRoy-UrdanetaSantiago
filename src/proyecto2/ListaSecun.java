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
public class ListaSecun {

    private NodoListaSecun first, last;
    private int size;

    /**
     * @author: Santiago Urdaneta
     * @deprecated: constructor de la lista
     */
    public ListaSecun() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * @author: Santiago Urdaneta
     * @deprecated: conocer si la lista está vacía
     * @return booleano
     */
    public boolean esVacio() {
        return first == null;
    }

    /**
     * @author Santiago Urdaneta
     * @param NodoNuevo nodo que se insertará en la lista
     * @deprecated: se inserta el nodo al final de la lista
     */
    public void insertarFinal(NodoListaSecun NodoNuevo) {
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
    public NodoListaSecun getFirst() {
        return first;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(NodoListaSecun first) {
        this.first = first;
    }

    /**
     * @return the last
     */
    public NodoListaSecun getLast() {
        return last;
    }

    /**
     * @param last the last to set
     */
    public void setLast(NodoListaSecun last) {
        this.last = last;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }
}
