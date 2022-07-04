package proyecto2;

import javax.swing.JOptionPane;

/**
 *
 * @author Santiago Urdaneta
 */
public class HashTablePrinc {

    private ListaPrinc[] arreglo;
    private int capacidad;
    private int tamaño;

    public HashTablePrinc() {
        this.capacidad = 401;
        arreglo = new ListaPrinc[capacidad];
        this.tamaño = 0;
    }

    public int Tamaño() {
        return tamaño;
    }

    public boolean EsVacio() {
        return tamaño == 0;
    }

    public void Inicio() {
        for (int i = 0; i < this.capacidad; i++) {
            arreglo[i] = new ListaPrinc();
        }
    }

    public void Agregar(NodoListaPrinc Nodo) {
        int arregloIndice = getArregloIndice(Nodo);
        ListaPrinc cabeza = arreglo[arregloIndice];
        if (cabeza.esVacio()) {
            cabeza.insertarFinal(Nodo);
            tamaño++;
            System.out.println("PRIMER ELEMENTO GUARDADO");
        } else {
            boolean existe = false;
            NodoListaPrinc primero = cabeza.getFirst();
            while ((primero != null) && !(existe)) {
                if ((primero.getTitle()).equals(Nodo.getTitle())) {
                    JOptionPane.showMessageDialog(null, "El artículo: '" + Nodo.getTitle() + "' ya se encuentra en la base de datos.");
                    existe = true;
                }
                primero = primero.getNext();
            }
            if (!(existe)) {
                cabeza.insertarFinal(Nodo);
                System.out.println("HUBO COLISION, GUARDADO");
            }
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
        System.out.println(arregloIndice);
        ListaPrinc cabeza = arreglo[arregloIndice];
        if (!(cabeza.esVacio())) {
            NodoListaPrinc primero = cabeza.getFirst();
            while (primero != null) {
                if (primero.getTitle().equals(Nodo.getTitle())) {
                    System.out.println("ENCONTRADO");
                    System.out.println(primero.getTitle() + primero.getText());
                    System.out.println();
                    return primero;
                }
                primero = primero.getNext();
            }
            JOptionPane.showMessageDialog(null, "El artículo: '" + Nodo.getTitle() + "', no se encuentra en la base de datos.");
            return null;
        }
        JOptionPane.showMessageDialog(null, "El artículo: '" + Nodo.getTitle() + "', no se encuentra en la base de datos.");
        return null;
    }
}
