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
public class HashNodeSecun {

    private Integer key;
    private NodoListaSecun value;
    private HashNodeSecun next;

    public HashNodeSecun(NodoListaSecun value) {
        this.value = value;
        this.key = null;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public NodoListaSecun getValue() {
        return value;
    }

    public void setValue(NodoListaSecun value) {
        this.value = value;
    }

    public HashNodeSecun getNext() {
        return next;
    }

    public void setNext(HashNodeSecun next) {
        this.next = next;
    }
}
