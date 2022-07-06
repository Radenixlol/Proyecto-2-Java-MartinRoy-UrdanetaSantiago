/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

/**
 *
 * @author Santiago Urdaneta & Roy Martin
 */
public class ListaString {

    private NodoListaString first, last;
    private int size;

    /**
     * @author: Santiago Urdaneta
     * @deprecated: constructor de la lista
     */
    public ListaString() {
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
     * @author Santiago Urdaneta
     * @deprecated: convierte la lista en un arreglo con el tamaño de la lista
     * @return lista convertida en arreglo 
     */
    public String[] convertirListaArray() {
        String arreglo[] = new String[size];
        NodoListaString temp = first;
        int i = 0;
        while (temp != null) {
            arreglo[i] = temp.getElemento();
            temp = temp.getNext();
            i++;
        }
        return arreglo;
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
