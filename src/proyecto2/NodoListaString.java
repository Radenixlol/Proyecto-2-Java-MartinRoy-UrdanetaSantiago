package proyecto2;

/**
 *
 * @author Santiago Urdaneta
 */
public class NodoListaString {

    private NodoListaString next;
    private String elemento;

    /**
     * @author: Santiago Urdaneta
     * @param elemento elemento con el que se rellenará el nodo
     * @deprecated: constructor de la Tabla de Dispersión
     */
    public NodoListaString(String elemento) {
        this.next = null;
        this.elemento = elemento;
    }

    /**
     * @return the next
     */
    public NodoListaString getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(NodoListaString next) {
        this.next = next;
    }

    /**
     * @return the elemento
     */
    public String getElemento() {
        return elemento;
    }

    /**
     * @param elemento the next to elemento
     */
    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

}
