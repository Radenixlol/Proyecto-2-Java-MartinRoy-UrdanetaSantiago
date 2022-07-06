package proyecto2;

/**
 *
 * @author Santiago Urdaneta
 */
public class NodoListaSecun {

    private NodoListaSecun next;
    protected ListaString elementos;
    private String object;

    /**
     * @author: Santiago Urdaneta
     * @param object elemento con el que se rellenará el nodo
     * @deprecated: constructor de la Tabla de Dispersión
     */
    public NodoListaSecun(String object) {
        this.next = null;
        this.elementos = new ListaString();
        this.object = object;
    }

    /**
     * @return the next
     */
    public NodoListaSecun getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(NodoListaSecun next) {
        this.next = next;
    }

    /**
     * @return the elementos
     */
    public ListaString getElementos() {
        return elementos;
    }

    /**
     * @param elementos the elementos to set
     */
    public void setElementos(ListaString elementos) {
        this.elementos = elementos;
    }

    /**
     * @return the object
     */
    public String getObject() {
        return object;
    }

    /**
     * @param object the object to set
     */
    public void setObject(String object) {
        this.object = object;
    }

}
