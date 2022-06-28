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
    private Lista first;
    private Lista last;
    private int size;
    
    public void CreaLista(){
        this.setFirst(null);
        this.setLast(null);
        this.setSize(0);
    }

    /**
     * @return the first
     */
    public Lista getFirst() {
        return first;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(Lista first) {
        this.first = first;
    }

    /**
     * @return the last
     */
    public Lista getLast() {
        return last;
    }

    /**
     * @param last the last to set
     */
    public void setLast(Lista last) {
        this.last = last;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
    
}
