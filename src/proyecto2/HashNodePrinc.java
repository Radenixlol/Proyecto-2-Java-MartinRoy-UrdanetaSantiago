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
public class HashNodePrinc {

    private Integer key;
    private NodoListaPrinc value;
    private HashNodePrinc next;

    public HashNodePrinc(NodoListaPrinc value) {
        this.value = value;
        this.key = null;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public NodoListaPrinc getValue() {
        return value;
    }

    public void setValue(NodoListaPrinc value) {
        this.value = value;
    }

    public HashNodePrinc getNext() {
        return next;
    }

    public void setNext(HashNodePrinc next) {
        this.next = next;
    }
}
