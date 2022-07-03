/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

/**
 * @author: Roy Martin
 * @version 1.0
 */
public class Backup {

    JFileChooser jfc = new JFileChooser();
    File archivo;

    /**
     * @author Roy Martin
     * @return 
     * @deprecated: Selecciona el archivo txt para leerlo y usar sus datos
     * posteriormente
     */
    public String Seleccionador_lectura() {
        String texto = "";
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        jfc.setFileFilter(filtro);
        int selec = jfc.showOpenDialog(null);

        if (selec == JFileChooser.APPROVE_OPTION) {
            this.archivo = jfc.getSelectedFile();
            try {
                FileReader fr = new FileReader(archivo);
                BufferedReader br = new BufferedReader(fr);
                JOptionPane.showMessageDialog(null, "Carga exitosa.");
                // Lectura del fichero
                String linea;
                while ((linea = br.readLine()) != null) {
                    texto += linea + "\n";
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error en la carga de datos.");
            }
        }
        return texto;
    }



    /**
     * @author Roy Martin
     * @deprecated: Hace una clasificación de los datos obtenidos en la lectura
     * y los asigna a los lugares respectivos del nodo
     */
    public void lectura_nueva() {
        String texto = this.Seleccionador_lectura();
        if (!"".equals(texto)) {
            String[] datos = texto.split("\n");
            boolean tt = true;
            boolean at = false;
            boolean rs = false;
            boolean cl = false;
            for (int i = 0; i < datos.length; i++) {
                if (tt) {
                    if ((!"".equals(datos[i])) && (!" ".equals(datos[i]))) {
                        String title = datos[i];
                        tt = false;
                        at = true;
                    }
                } else if (at) {
                    if (("Autores".equals(datos[i])) || ("Autor".equals(datos[i])) || ("Autora".equals(datos[i]))) {
                        i += 1;
                        String authorstemp = "";
                        while ((!"".equals(datos[i])) && (!" ".equals(datos[i]))) {
                            authorstemp += datos[i];
                            authorstemp += ";";
                            i += 1;
                        }
                        String[] authors = authorstemp.split(";");
                        at = false;
                        rs = true;
                    }
                } else if (rs) {
                    if ("Resumen".equals(datos[i])) {
                        i += 1;
                        String text = datos[i];
                        rs = false;
                        cl = true;
                    }
                } else if (cl) {
                    if ((!"".equals(datos[i])) && (!" ".equals(datos[i]))) {
                        String temp3 = "";
                        String temp = datos[i];
                        String[] temp2 = temp.replace(":", ",").split(", ");
                        for (int j = 1; j < temp2.length; j++) {
                            temp3 += temp2[j];
                            temp3 += ",";
                        }
                        String[] keys = temp3.split(",");
                    }
                }
            }
        } 
    }
    
    /**
 * @author Roy Martin
 * @deprecated: Hace una clasificación de los datos obtenidos en la lectura y los asigna a los lugares respectivos del grafo
 */
    public void lectura_data() {
        String data = this.Seleccionador_lectura();
        if (!"".equals(data)) {
            String pt = "%°%";
            String[] datos = data.split(pt);
            for (int i = 0; i < datos.length-1; i++) {
                String[] nodito;
                nodito = datos[i].split("\n\n");
                System.out.println(nodito.length);
                String title = nodito[0];
                String[] authors = nodito[1].split(";");
                String text = nodito[2];
                String[] keys = nodito[3].split(";");
                //escribir método de asignación al hash table
                System.out.println(title);
                for(int j = 0; j < authors.length; j++){
                    System.out.println(authors[j]);
                }
                System.out.println(text);
                for(int j = 0; j < keys.length; j++){
                    System.out.println(keys[j]);
                }
            }
            System.out.println("carga lista");
        }
    }
    
///**
// * @author Roy Martin
// * @deprecated: Se encarga de procesar la lista de productos de cada almacen y retornarlo
// * @param arr_productos Un arreglo de productos y cantidades
// * @param i Valor númerico para ubicar el valor del arreglo arr_productos
// * @return Retorna una lista de productos
// */
//    public ListaProd clasificacionAlm(String[] arr_productos, int i) {
//        ListaProd lista = new ListaProd();
//        String product = String.valueOf(arr_productos[i]);
//        String[] producto = (product.replace(",", " ")).split(" ");
//
//        for (int j = 2; j < producto.length; j += 2) {
//            lista.insertar(Integer.parseInt(producto[j + 1]), producto[j]);
//        }
//        return lista;
//    }
///**
// * @author Roy Martin
// * @deprecated: Carga todas las rutas del grafo
// * @param datos Arreglo de Strings con la información principal del txt
// * @param fin_alm Valor númerico para diferenciar lo que hay antes de las rutas y después de ellas
// * @param g el grafo a donde se cargarán los datos
// */
//    public void clasificacionRuta(String[] datos, int fin_alm, Grafo g) {
//        for (int i = fin_alm + 1; i < datos.length; i++) {
//            String rutas = String.valueOf(datos[i]);
//            String[] ruta = rutas.split(",");
//            g.cargarRuta((ruta[0]).charAt(0), (ruta[1]).charAt(0), Integer.parseInt(ruta[2]));
//        }
//    }
///**
// * @author: Roy Martin
// * @deprecated: Se encarga de calcular cuantas líneas hay antes de la sección de Rutas
// * @param datos Arreglo de Strings
// * @return un valor númerico
// */
//    public int final_list(String[] datos) {
//        int fin_alm;
//        for (int i = 0; i < datos.length; i++) {
//            if (datos[i].equals("Rutas;")) {
//                fin_alm = i;
//                return fin_alm;
//            }
//        }
//        return 0;
//
//    }
///**
// * @author: Roy Martin
// * @deprecated: Calcula la cantidad de almacenes que hay
// * @param texto String
// * @return un valor numérico
// */
//    public int num_alm(String texto) {
//        String[] cantidad = texto.split("Almacen");
//        return cantidad.length;
//    }
///**
// * @author: Roy Martin
// * @deprecated: Es el procedimiento de escritura de archivos, extrae todos los datos de un grafo para guardarlo en un txt para ser usado posteriormente
// * @param g Grafo del cuál se extraerán los datos a guardar
//
// */
//    public void escritura(Grafo g) {
//        String info = "";
//        ListaAlm Almacenes = g.getAlmacenes();
//        if (!Almacenes.esVacio()) {
//            info += "Almacenes;" + "\n";
//            Almacen almacen = Almacenes.getPfirst();
//            int i = 0;
//            while (almacen != null) {
//                info += "Almacen " + (char)(i+65) + ":" + "\n";
//                ListaProd productos = almacen.getProductos();
//                Producto producto = productos.getPfirst();
//                Producto producto_final = productos.getPlast();
//                while (producto != null) {
//                    if (producto == producto_final) {
//                        String nombre = producto.getNombre();
//                        int cantidad_num = producto.getCantidad();
//                        String cantidad = String.valueOf(cantidad_num);
//                        info += nombre + "," +cantidad + ";" + "\n";
//                        producto = producto.getNext();
//                        System.out.println("almacen");
//                    } else {
//                        String nombre = producto.getNombre();
//                        int cantidad_num = producto.getCantidad();                      
//                        info += nombre + "," +cantidad_num + "\n";
//                        producto = producto.getNext();
//                        System.out.println("almacen");
//                    }
//                }
//                almacen = almacen.getNext();
//                i++;
//            }
//            int[][] rutas = g.getRutas();
//            info += "Rutas;" + "\n";
//            for (int j = 0; j < g.getMax(); j++){
//                for (int k = 0; k < g.getMax(); k++){
//                    if((rutas[j][k])!=0){
//                        System.out.println(rutas[j][k]);
//                        info += (char)(j+65) + "," + (char)(k+65) + "," + rutas[j][k] + "\n";
//                    }
//                }
//            }
//        }
//        try{
//            PrintWriter pw = new PrintWriter(archivo);
//            pw.print(info);
//            pw.close();
//            JOptionPane.showMessageDialog(null, "Guardado exitoso.");
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, "Error en el guardado de datos.");
//        }
//        
//    }
//    
}
