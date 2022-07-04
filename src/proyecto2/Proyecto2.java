/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto2;

/**
 *
 * @author Radenixlol
 */
public class Proyecto2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        HashTablePrinc table = new HashTablePrinc();
        table.Inicio();
        
        String[] keywords1 = {"rapido", "eficiente"};
        String[] autores1 = {"luis", "juan"};
        NodoListaPrinc p1 = new NodoListaPrinc("ejemplo", "text", autores1, keywords1);
        
        String[] keywords2 = {"fast", "aaaaa"};
        String[] autores2 = {"andres", "ernesto"};
        NodoListaPrinc p2 = new NodoListaPrinc("taCan saodi ho", "aaaa", autores2, keywords2);

        String[] keywords3 = {"practicidad", "lento"};
        String[] autores3 = {"diego"};
        NodoListaPrinc p3 = new NodoListaPrinc("Canta oh diosa", "muchas palabras", autores3, keywords3);

        String[] keywords4 = {"eficiencia"};
        String[] autores4 = {"carlos, christian"};
        NodoListaPrinc p4 = new NodoListaPrinc("diosa oh Canta", "resumen del articulo", autores4, keywords4);
        
        table.Agregar(p1);
        table.Agregar(p2);
        table.Agregar(p3);
        table.Agregar(p3);
        table.Agregar(p4);
        
        System.out.println(table.Tamaño());
        
        table.Encontrar(p1);
        table.Encontrar(p2);
        table.Encontrar(p3);
        table.Encontrar(p4);
        
        

//        
//        
//        Ventana1 v = new Ventana1();
//        v.setVisible(true);
//        Backup archivo = new Backup();
//        archivo.lectura_nueva();        
    }

}
