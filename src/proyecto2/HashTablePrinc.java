package proyecto2;

import javax.swing.JOptionPane;

/**
 *
 * @author Santiago Urdaneta
 */
public class HashTablePrinc {

    private HashNodePrinc[] arreglo;
    private int capacidad;
    private int tamaño;

    public HashTablePrinc() {
        this.capacidad = 401;
        arreglo = new HashNodePrinc[capacidad];
        this.tamaño = 0;
    }

    public int Tamaño() {
        return tamaño;
    }

    public boolean EsVacio() {
        return tamaño == 0;
    }

    public void Agregar(NodoListaPrinc Nodo) {
        int arregloIndice = getArregloIndice(Nodo);
        HashNodePrinc cabeza = arreglo[arregloIndice];
        if (cabeza == null) {
            tamaño++;
            ListaPrinc Lista = new ListaPrinc();
            Lista.insertarFinal(Nodo);
            cabeza = arreglo[arregloIndice];
            HashNodePrinc NodoHash = new HashNodePrinc(Nodo);
            NodoHash.setNext(cabeza);
            arreglo[arregloIndice] = NodoHash;
            System.out.println("PRIMER ELEMENTO GUARDADO");
        } else {
            while (cabeza != null) {
                if (cabeza.getValue().getTitle().equals(Nodo.getTitle())) {
                    JOptionPane.showMessageDialog(null, "El artículo: '" + Nodo.getTitle() + "' ya se encuentra en la base de datos.");
                    return;
                }
                if (cabeza.getNext() == null) {
                    break;
                }
                cabeza = cabeza.getNext();
            }
            cabeza.getValue().setNext(Nodo);
            System.out.println("HUBO COLISION, GUARDADO");
        }
    }

    public int getArregloIndice(NodoListaPrinc Nodo) {
        String title = Nodo.getTitle();
        int ascii = 0;
        for (int i = 0; i < title.length(); i++) {
            char caracter = title.charAt(i);
            ascii = ascii + (int) caracter;
        }
        int key = ascii % capacidad;
        return key;
    }

    public NodoListaPrinc Encontrar(NodoListaPrinc Nodo) {
        int arregloIndice = getArregloIndice(Nodo);
        HashNodePrinc cabeza = arreglo[arregloIndice];
        while (cabeza != null) {
            if (cabeza.getValue().getTitle().equals(Nodo.getTitle())) {
                System.out.println("ENCONTRADO 1");
                System.out.println(cabeza.getValue().getTitle() + cabeza.getValue().getText());
                System.out.println();
                return cabeza.getValue();
            }
            System.out.println(cabeza.getValue().getTitle() + cabeza.getValue().getText());
            cabeza = cabeza.getNext();
        }
        JOptionPane.showMessageDialog(null, "El artículo: '" + Nodo.getTitle() + "', no se encuentra en la base de datos.");
        return null;
    }
}
