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

    public void Agregar(String object, String title) {
        int arregloIndice = getArregloIndice(object);
        ListaSecun cabeza = arreglo[arregloIndice];
        if (cabeza.esVacio()) {
            NodoListaSecun Nodo1 = new NodoListaSecun(object);
            NodoListaString elemento = new NodoListaString(title);
            Nodo1.elementos.insertarFinal(elemento);
            cabeza.insertarFinal(Nodo1);
            tamaño++;
            System.out.println("PRIMER ELEMENTO GUARDADO");
        } else {
            boolean existe1 = false;
            NodoListaSecun primero = cabeza.getFirst();
            while ((primero != null) && !(existe1)) {
                if ((primero.getObject()).equals(object)) {
                    System.out.println("El dato ya fue añadido anteriormente");
                    boolean existe2 = false;
                    ListaString titulo0 = primero.elementos;
                    NodoListaString titulo = titulo0.getFirst();
                    while ((titulo != null) && !(existe2)) {
                        if ((titulo.getElemento()).equals(title)) {
                            JOptionPane.showMessageDialog(null, "El dato: '" + object + "' y el título: '" + title + "' ya se encuentran vinvulados.");
                            existe2 = true;
                        }
                        titulo = titulo.getNext();
                    }
                    if (!(existe2)) {
                        NodoListaString elemento = new NodoListaString(title);
                        titulo0.insertarFinal(elemento);
                        JOptionPane.showMessageDialog(null, "El título: '" + title + "' fue vinculado al dato: '" + object + "'");
                    }
                    existe1 = true;
                }
                primero = primero.getNext();
            }
            if (!(existe1)) {
                NodoListaSecun Nodo1 = new NodoListaSecun(object);
                NodoListaString elemento = new NodoListaString(title);
                Nodo1.elementos.insertarFinal(elemento);
                cabeza.insertarFinal(Nodo1);
                System.out.println("HUBO COLISION, GUARDADO");
            }
        }
    }

    public int getArregloIndice(String title) {
        int ascii = 0;
        for (int i = 0; i < title.length(); i++) {
            char caracter = title.charAt(i);
            ascii = ascii + (int) caracter;
        }
        int key = ascii % capacidad;
        return key;
    }

    public String Encontrar(String object) {
        int arregloIndice = getArregloIndice(object);
        ListaSecun cabeza = arreglo[arregloIndice];
        if (!(cabeza.esVacio())) {
            NodoListaSecun primero = cabeza.getFirst();
            while (primero != null) {
                if (primero.getObject().equals(object)) {
                    NodoListaString datos = primero.elementos.getFirst();
                    String cadena = "";
                    while (datos != null) {
                        cadena += datos.getElemento();
                        cadena += ",";
                        datos = datos.getNext();
                    }
                    return cadena;
                }
                primero = primero.getNext();
            }
            JOptionPane.showMessageDialog(null, "El dato: '" + object + "', no se encuentra en la base de datos.");
            return null;
        }
        JOptionPane.showMessageDialog(null, "El dato: '" + object + "', no se encuentra en la base de datos.");
        return null;
    }
}
