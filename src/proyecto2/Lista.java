/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author Radenixlol
 */
public class Lista {

    private NodoLista first, last;
    private int size;

    public Lista(NodoLista first, NodoLista last, int size) {
        this.first = first;
        this.last = last;
        this.size = 0;
    }

    /**
     * @return the first
     */
    public NodoLista getFirst() {
        return first;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(NodoLista first) {
        this.first = first;
    }

    /**
     * @return the last
     */
    public NodoLista getLast() {
        return last;
    }

    /**
     * @param last the last to set
     */
    public void setLast(NodoLista last) {
        this.last = last;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }
}
