/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author Santiago Urdaneta
 */
public class ListaPrinc {

    private NodoListaPrinc first, last;
    private int size;

    /**
     * @author: Santiago Urdaneta
     * @deprecated: constructor de la lista
     */
    public ListaPrinc() {
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
    public void insertarFinal(NodoListaPrinc NodoNuevo) {
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
    public NodoListaPrinc getFirst() {
        return first;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(NodoListaPrinc first) {
        this.first = first;
    }

    /**
     * @return the last
     */
    public NodoListaPrinc getLast() {
        return last;
    }

    /**
     * @param last the last to set
     */
    public void setLast(NodoListaPrinc last) {
        this.last = last;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }
}
