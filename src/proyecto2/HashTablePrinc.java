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

    /**
     * @author: Santiago Urdaneta
     * @deprecated: constructor de la Tabla de Dispersión
     */
    public HashTablePrinc() {
        this.capacidad = 401;
        arreglo = new ListaPrinc[capacidad];
        this.tamaño = 0;
    }

    /**
     * @author: Santiago Urdaneta
     * @deprecated: conocer si la TablaHash está vacía
     * @return: booleano
     */
    public boolean EsVacio() {
        return tamaño == 0;
    }

    /**
     * @author Santiago Urdaneta
     * @param Nodo el cual se agregará a la TablaHash
     * @deprecated: Evalua si la key donde se insertará el nodo está vacía o no, si esta se
     * encuentra vacía, se crea una lista vacía y le inserta el nodo; en caso contrario, le 
     * añade el nodo a insertar a la lista ya existente en esa posición (key) del la TablaHash
     */
    public boolean Agregar(NodoListaPrinc Nodo) {
        int arregloIndice = getArregloIndice(Nodo);
        if (arreglo[arregloIndice] == null) {
            arreglo[arregloIndice] = new ListaPrinc();
            ListaPrinc Lista = arreglo[arregloIndice];
            Lista.insertarFinal(Nodo);
            tamaño++;
            System.out.println("PRIMER ELEMENTO GUARDADO");
            return true;
        } else {
            boolean existe = false;
            ListaPrinc Lista = arreglo[arregloIndice];
            NodoListaPrinc primero = Lista.getFirst();
            while ((primero != null) && !(existe)) {
                if ((primero.getText()).equals(Nodo.getText())) {
                    JOptionPane.showMessageDialog(null, "El artículo: '" + Nodo.getTitle() + "' ya se encuentra en la base de datos.");
                    existe = true;
                }
                primero = primero.getNext();
            }
            if (!(existe)) {
                Lista.insertarFinal(Nodo);
                System.out.println("HUBO COLISION, GUARDADO");
                return true;
            }
        }
        return false;
    }

    public int getArregloIndice(NodoListaPrinc Nodo) {
        String title = Nodo.getTitle();
        int ascii = 0;
        for (int i = 0; i < title.length(); i++) {
            char caracter = title.charAt(i);
            ascii = ascii + (int) caracter;
        }
        int key = ascii % getCapacidad();
        return key;
    }

    public NodoListaPrinc Encontrar(NodoListaPrinc Nodo) {
        int arregloIndice = getArregloIndice(Nodo);
        System.out.println(arregloIndice);
        ListaPrinc Lista = arreglo[arregloIndice];
        if (!(Lista.esVacio())) {
            NodoListaPrinc primero = Lista.getFirst();
            while (primero != null) {
                if (primero.getTitle().equals(Nodo.getTitle())) {
                    System.out.println("ENCONTRADO");
                    System.out.println(primero.getTitle() + primero.getText());
                    System.out.println();
                    return primero;
                }
                primero = primero.getNext();
            }
        }
        JOptionPane.showMessageDialog(null, "El artículo: '" + Nodo.getTitle() + "', no se encuentra en la base de datos.");
        return null;
    }

    /**
     * @return the arreglo
     */
    public ListaPrinc[] getArreglo() {
        return arreglo;
    }

    /**
     * @param arreglo the arreglo to set
     */
    public void setArreglo(ListaPrinc[] arreglo) {
        this.arreglo = arreglo;
    }

    /**
     * @return the capacidad
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * @param capacidad the capacidad to set
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * @return the tamaño
     */
    public int getTamaño() {
        return tamaño;
    }

    /**
     * @param tamaño the tamaño to set
     */
    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

}
