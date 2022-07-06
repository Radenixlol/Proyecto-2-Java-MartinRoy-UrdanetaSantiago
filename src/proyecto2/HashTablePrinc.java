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
     * @return booleano
     */
    public boolean EsVacio() {
        return tamaño == 0;
    }

    /**
     * @author Santiago Urdaneta
     * @param Nodo el cual se agregará a la TablaHash
     * @return booleano
     * @deprecated: se agrega el nodo a la TablaHash en el key correspondiente
     * mediante el uso de una lista simple enlazada
     */
    public boolean Agregar(NodoListaPrinc Nodo) {
        int arregloIndice = getArregloIndice(Nodo.getTitle());
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
            NodoListaPrinc auxiliar = Lista.getFirst();
            while ((auxiliar != null) && !(existe)) {
                if ((auxiliar.getText()).equals(Nodo.getText())) {
                    JOptionPane.showMessageDialog(null, "El artículo: '" + Nodo.getTitle() + "' ya se encuentra en la base de datos.");
                    existe = true;
                }
                auxiliar = auxiliar.getNext();
            }
            if (!(existe)) {
                Lista.insertarFinal(Nodo);
                System.out.println("HUBO COLISION, GUARDADO");
                return true;
            }
        }
        return false;
    }

    /**
     * @author Santiago Urdaneta
     * @param title al cual se quiere conocer su posición (key) en la TablaHash
     * @deprecated: evalua el título del artículo científico y realiza la
     * función Hash (función modular) con el valor de la sumatoria ASCII del
     * título
     * @return valor de posición del nodo (key) en la TablaHash
     */
    public int getArregloIndice(String title) {
        int ascii = 0;
        for (int i = 0; i < title.length(); i++) {
            char caracter = title.charAt(i);
            ascii = ascii + (int) caracter;
        }
        int key = ascii % getCapacidad();
        return key;
    }

    /**
     * @author Santiago Urdaneta
     * @param Nodo el cual se quiere encontrar
     * @deprecated: encuentra el nodo accediendo a la key correspondiente y
     * buscandolo en la lista simple enlazada
     * @return nodo a encontrar
     */
    public NodoListaPrinc Encontrar(NodoListaPrinc Nodo) {
        int arregloIndice = getArregloIndice(Nodo.getTitle());
        System.out.println(arregloIndice);
        ListaPrinc Lista = arreglo[arregloIndice];
        if (!(Lista.esVacio())) {
            NodoListaPrinc auxiliar = Lista.getFirst();
            while (auxiliar != null) {
                if (auxiliar.getText().equals(Nodo.getText())) {
                    System.out.println("ENCONTRADO");
                    System.out.println(auxiliar.getTitle() + auxiliar.getText());
                    System.out.println();
                    return auxiliar;
                }
                auxiliar = auxiliar.getNext();
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
