package proyecto2;

import javax.swing.JOptionPane;

/**
 *
 * @author Santiago Urdaneta
 */
public class HashTable {

    private HashNode[] arreglo;
    private int capacidad;
    private int tamaño;

    public HashTable() {
        this.capacidad = 401;
        arreglo = new HashNode[capacidad];
        this.tamaño = 0;
    }

    private class HashNode {

        private Integer key;
        private NodoLista value;
        private HashNode next;

        public HashNode(Integer key, NodoLista value) {
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

    public void Agregar(Integer key, NodoLista value) {
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

    public int getArregloIndice(Integer key) {
        return key % capacidad;
    }

    // EN CASO DE COLISION RETORNA EL ULTIMO ELEMENTO DE LA LISTA
    public NodoLista Encontrar(Integer key) {
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
