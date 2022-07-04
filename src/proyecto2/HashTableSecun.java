package proyecto2;

import javax.swing.JOptionPane;

/**
 *
 * @author Santiago Urdaneta
 */
public class HashTableSecun {

    private ListaSecun[] arreglo;
    private int capacidad;
    private int tamaño;

    public HashTableSecun() {
        this.capacidad = 401;
        arreglo = new ListaSecun[capacidad];
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
            arreglo[i] = new ListaSecun();
        }
    }

    public void Agregar(NodoListaSecun Nodo) {
        int arregloIndice = getArregloIndice(Nodo);
        ListaSecun cabeza = arreglo[arregloIndice];
        if (cabeza.esVacio()) {
            cabeza.insertarFinal(Nodo);
            tamaño++;
            System.out.println("PRIMER ELEMENTO GUARDADO");
        } else {
            boolean existe = false;
            NodoListaSecun primero = cabeza.getFirst();
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

    public int getArregloIndice(NodoListaSecun Nodo) {
        String title = Nodo.getTitle();
        int ascii = 0;
        for (int i = 0; i < title.length(); i++) {
            char caracter = title.charAt(i);
            ascii = ascii + (int) caracter;
        }
        int key = ascii % capacidad;
        return key;
    }

    public NodoListaSecun Encontrar(NodoListaSecun Nodo) {
        int arregloIndice = getArregloIndice(Nodo);
        System.out.println(arregloIndice);
        ListaSecun cabeza = arreglo[arregloIndice];
        if (!(cabeza.esVacio())) {
            NodoListaSecun primero = cabeza.getFirst();
            while (primero != null) {
                if (primero.getTitle().equals(Nodo.getTitle())) {
                    System.out.println("ENCONTRADO");
                    System.out.println(primero.getTitle());
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
