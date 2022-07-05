package proyecto2;

/**
 *
 * @author Santiago Urdaneta
 */
public class NodoListaSecun {

    private NodoListaSecun next;
    protected ListaString elementos;
    private String object;

    public NodoListaSecun(String object) {
        this.next = null;
        this.elementos = new ListaString();
        this.object = object;
    }

    public NodoListaSecun getNext() {
        return next;
    }
    
    public void setNext(NodoListaSecun next) {
        this.next = next;
    }

    public ListaString getElementos() {
        return elementos;
    }

    public void setElementos(ListaString elementos) {
        this.elementos = elementos;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

}
