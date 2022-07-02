package proyecto2;

import javax.swing.JOptionPane;

/**
 *
 * @author Radenixlol
 */

public class HashTable {

    
    private HashNode[] arreglo;
    private int capacidad;
    private int tamaño;

    public HashTable(int capacidad) {
        this.capacidad = capacidad;
        arreglo = new HashNode[capacidad];
        this.tamaño = 0;
    }

    private class HashNode {

        private Integer key;
        private String value;
        private HashNode next;

        public HashNode(Integer key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public int Tamaño() {
        return tamaño;
    }

    public boolean EsVacio() {
        return tamaño == 0;
    }

    public void Agregar(Integer key, String value) {
        if (key == null || value == null) {
            JOptionPane.showInputDialog(null, "Error al ingresar los datos, valide.");
        }
        int arregloIndice = getArregloIndice(key);
        HashNode cabeza = arreglo[arregloIndice];
        while (cabeza != null) {
            if (cabeza.key.equals(key)) {
                cabeza.value = value;
                return;
            }
            cabeza = cabeza.next;
        }
        tamaño++;
        cabeza = arreglo[arregloIndice];
        HashNode node = new HashNode(key, value);
        node.next = cabeza;
        arreglo[arregloIndice] = node;

    }

    public int getArregloIndice(Integer key) {  //esta es la funcion hash tipica que estoy usando, falta cambiarla
        return key % capacidad;
    }

    public String Quitar(Integer key) { //falta perfeccionar, solo quita la cabeza
        if (key == null) {
            JOptionPane.showInputDialog(null, "Error al ingresar los datos, valide.");
        }
        int arregloIndice = getArregloIndice(key);
        HashNode cabeza = arreglo[arregloIndice];
        HashNode previo = null;
        while(cabeza != null){
            if(cabeza.key.equals(key)){
                break;
            }
            previo = cabeza;
            cabeza = cabeza.next; 
        }
        if(cabeza == null){
            return null;
        }
        tamaño--;
        if(previo != null){
            previo.next = cabeza.next;
        }
        else{
            arreglo[arregloIndice] = cabeza.next;
        }
        return cabeza.value;
    }

    public String Encontrar(Integer key) { // EN CASO DE COLISION RETORNA EL ULTIMO ELEMENTO DE LA LISTA
        if (key == null) {
            JOptionPane.showInputDialog(null, "Error al ingresar los datos, valide.");
        }
        int arregloIndice = getArregloIndice(key);
        HashNode cabeza = arreglo[arregloIndice];
        while (cabeza != null) {
            if (cabeza.key.equals(key)) {
                return cabeza.value;
            }
            cabeza = cabeza.next;
        }

        return null;
    }
}