package proyecto2;

/**
 *
 * @author Santiago Urdaneta
 */
public class HashTableSecun {

    private ListaSecun[] arreglo;
    private int capacidad;
    private int tamaño;

    /**
     * @author: Santiago Urdaneta
     * @deprecated: constructor de la Tabla de Dispersión
     */
    public HashTableSecun() {
        this.capacidad = 401;
        arreglo = new ListaSecun[capacidad];
        this.tamaño = 0;
    }

    /**
     * @return booleano
     * @author: Santiago Urdaneta
     * @deprecated: conocer si la TablaHash está vacía
     * @return: booleano
     */
    public boolean EsVacio() {
        return tamaño == 0;
    }

    /**
     * @author Santiago Urdaneta & Roy Martin
     * @param object elemento con el que se rellenará la HashTable
     * @param title título del artículo científico que se agregará
     * @deprecated: se agrega el nodo a la TablaHash en el key correspondiente
     * mediante el uso de una lista simple enlazada
     */
    public void Agregar(String object, String title) {
        int arregloIndice = getArregloIndice(object);
        if (arreglo[arregloIndice] == null) {
            arreglo[arregloIndice] = new ListaSecun();
            ListaSecun Lista = arreglo[arregloIndice];
            NodoListaSecun Nodo1 = new NodoListaSecun(object);
            NodoListaString elemento = new NodoListaString(title);
            Nodo1.elementos.insertarFinal(elemento);
            Lista.insertarFinal(Nodo1);
            tamaño++;
            System.out.println("PRIMER ELEMENTO GUARDADO");
        } else {
            boolean existe1 = false;
            ListaSecun Lista = arreglo[arregloIndice];
            NodoListaSecun auxiliar = Lista.getFirst();
            while ((auxiliar != null) && !(existe1)) {
                if ((auxiliar.getObject()).equals(object)) {
                    System.out.println("El dato ya fue añadido anteriormente");
                    boolean existe2 = false;
                    ListaString titulo0 = auxiliar.elementos;
                    NodoListaString titulo = titulo0.getFirst();
                    while ((titulo != null) && !(existe2)) {
                        if ((titulo.getElemento()).equals(title)) {
                            System.out.println("El dato: '" + object + "' y el título: '" + title + "' ya se encuentran vinculados.");
                            existe2 = true;
                        }
                        titulo = titulo.getNext();
                    }
                    if (!(existe2)) {
                        NodoListaString elemento = new NodoListaString(title);
                        titulo0.insertarFinal(elemento);
                        System.out.println("El título: '" + title + "' fue vinculado al dato: '" + object + "'");
                    }
                    existe1 = true;
                }
                auxiliar = auxiliar.getNext();
            }
            if (!(existe1)) {
                NodoListaSecun Nodo1 = new NodoListaSecun(object);
                NodoListaString elemento = new NodoListaString(title);
                Nodo1.elementos.insertarFinal(elemento);
                Lista.insertarFinal(Nodo1);
                System.out.println("HUBO COLISION, GUARDADO");
            }
        }
    }

    /**
     * @author Santiago Urdaneta
     * @param title al cual se quiere conocer su posición (key) en la TablaHash
     * @return entero
     * @deprecated: evalua el título del artículo científico y realiza la
     * función Hash (función modular) con el valor de la sumatoria ASCII del
     * título
     * @return: valor de posición del nodo (key) en la TablaHash
     */
    public int getArregloIndice(String title) {
        int ascii = 0;
        for (int i = 0; i < title.length(); i++) {
            char caracter = title.charAt(i);
            ascii = ascii + (int) caracter;
        }
        int key = ascii % capacidad;
        return key;
    }

    /**
     * @author Santiago Urdaneta & Roy Martin
     * @param object elemento el cual se quiere encontrar
     * @deprecated: encuentra el nodo accediendo a la key correspondiente y
     * buscandolo en la lista simple enlazada
     * @return info del nodo a encontrar
     */
    public String Encontrar(String object) {
        int arregloIndice = getArregloIndice(object);
        ListaSecun Lista = arreglo[arregloIndice];
        if (!(Lista.esVacio())) {
            NodoListaSecun auxiliar = Lista.getFirst();
            while (auxiliar != null) {
                if (auxiliar.getObject().equals(object)) {
                    NodoListaString datos = auxiliar.elementos.getFirst();
                    String cadena = "";
                    while (datos != null) {
                        cadena += datos.getElemento();
                        cadena += ",";
                        datos = datos.getNext();
                    }
                    return cadena;
                }
                auxiliar = auxiliar.getNext();
            }
        }
        System.out.println("El dato: '" + object + "', no se encuentra en la base de datos.");
        return null;
    }

    /**
     * @return the arreglo
     */
    public ListaSecun[] getArreglo() {
        return arreglo;
    }

    /**
     * @param arreglo the arreglo to set
     */
    public void setArreglo(ListaSecun[] arreglo) {
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
