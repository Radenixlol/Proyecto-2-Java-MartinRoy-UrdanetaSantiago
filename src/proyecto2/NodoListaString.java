package proyecto2;

/**
 *
 * @author Santiago Urdaneta
 */
public class NodoListaString {

    private NodoListaString next;
    private String elemento;

    public NodoListaString(String elemento) {
        this.next = null;
        this.elemento = elemento;
    }

    public NodoListaString getNext() {
        return next;
    }
    
    public void setNext(NodoListaString next) {
        this.next = next;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

}
