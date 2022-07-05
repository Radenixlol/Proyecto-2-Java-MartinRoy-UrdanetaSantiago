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
     * @param tabla
     * @param autores
     * @param palabras
     * @deprecated: Hace una clasificación de los datos obtenidos en la lectura
     * y los asigna a los lugares respectivos del nodo
     */
    public void lectura_nueva(HashTablePrinc tabla, HashTableSecun autores, HashTableSecun palabras) {
        String texto = this.Seleccionador_lectura();
        if (!"".equals(texto)) {
            String[] datos = texto.split("\n");
            boolean tt = true;
            boolean at = false;
            boolean rs = false;
            boolean cl = false;
            String title = "";
            String[] authors = {};
            String text = "";
            String[] key_words = {};
            for (int i = 0; i < datos.length; i++) {
                if (tt) {
                    if ((!"".equals(datos[i])) && (!" ".equals(datos[i]))) {
                        title = datos[i];
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
                        authors = authorstemp.split(";");
                        at = false;
                        rs = true;
                    }
                } else if (rs) {
                    if ("Resumen".equals(datos[i])) {
                        i += 1;
                        text = datos[i];
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
                        key_words = temp3.split(",");
                        cl = false;
                    }
                }
            }
            int[] reps = new int[key_words.length];
            for (int i = 0; i < key_words.length; i++) {
                int cantidad = 0;
                for (int j = 0; j < text.length(); j++) {
                    if (text.substring(j).startsWith(key_words[i])) {
                        cantidad++;
                    }
                }
                reps[i] = cantidad;
            }

            NodoListaPrinc article = new NodoListaPrinc(title, text, authors, key_words, reps);
            boolean avaible = tabla.Agregar(article);
            if (avaible) {
                for (int i = 0; i < authors.length; i++) {
                    autores.Agregar(authors[i], title);
                }
                for (int i = 0; i < key_words.length; i++) {
                    palabras.Agregar(key_words[i], title);
                }
            }
        }
    }

    /**
     * @author Roy Martin
     * @param tabla
     * @param autores
     * @param palabras
     * @deprecated: Hace una clasificación de los datos obtenidos en la lectura
     * y los asigna a los lugares respectivos del grafo
     */
    public void lectura_data(HashTablePrinc tabla, HashTableSecun autores, HashTableSecun palabras) {
        String data = this.Seleccionador_lectura();
        if (!"".equals(data)) {
            String pt = "%°%";
            String[] datos = data.split(pt);
            for (int i = 0; i < datos.length - 1; i++) {
                String[] nodito;
                nodito = datos[i].split("\n\n");
                System.out.println(nodito.length);
                String title = nodito[0];
                String[] authors = nodito[1].split(";");
                String text = nodito[2];
                String[] key_words = nodito[3].split(";");
                //escribir método de asignación al hash table
                int[] reps = new int[key_words.length];
                for (int j = 0; j < key_words.length; j++) {
                    int cantidad = 0;
                    for (int k = 0; k < text.length(); k++) {
                        if (text.substring(k).startsWith(key_words[j])) {
                            cantidad++;
                        }
                    }
                    reps[j] = cantidad;
                }

                NodoListaPrinc article = new NodoListaPrinc(title, text, authors, key_words, reps);
                boolean avaible = tabla.Agregar(article);
                if (avaible) {
                    for (int j = 0; j < authors.length; j++) {
                        autores.Agregar(authors[j], title);
                    }
                    for (int j = 0; j < key_words.length; j++) {
                        palabras.Agregar(key_words[j], title);
                    }
                }
                System.out.println(title);
                for (int j = 0; j < authors.length; j++) {
                    System.out.println(authors[j]);
                }
                System.out.println(text);
                for (int j = 0; j < key_words.length; j++) {
                    System.out.println(key_words[j]);
                }
            }
            System.out.println("Carga completada");
        }
    }

    /**
     * @param tabla
     * @author: Roy Martin
     * @deprecated: Es el procedimiento de escritura de archivos, extrae todos
     * los datos de un grafo para guardarlo en un txt para ser usado
     * posteriormente
     *
     */
    public void Escritura(HashTablePrinc tabla) {
        String info = "";
        ListaPrinc[] arreglos = tabla.getArreglo();
        for (int i = 0; i < arreglos.length; i++) {
            if (arreglos[i] != null) {
                ListaPrinc lista = arreglos[i];
                NodoListaPrinc cabeza = lista.getFirst();
                while (cabeza != null) {
                    info += cabeza.getTitle();
                    info += "\n\n";
                    String[] autores = cabeza.getAuthors();
                    for (int j = 0; j < autores.length; j++) {
                        info += autores[j];
                        info += ";";
                    }
                    info += "\n\n";
                    info += cabeza.getText();
                    info += "\n\n";
                    String[] key_words = cabeza.getKey_words();
                    for (int j = 0; j < key_words.length; j++) {
                        info += key_words[j];
                        info += ";";
                    }
                    info += "%°%";
                    info += "\n";
                    cabeza = cabeza.getNext();
                }
            }
        }
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        jfc.setFileFilter(filtro);
        int selec = jfc.showOpenDialog(null);
        if (selec == JFileChooser.APPROVE_OPTION) {
            this.archivo = jfc.getSelectedFile();
            try {
                PrintWriter pw = new PrintWriter(archivo);
                pw.print(info);
                pw.close();
                JOptionPane.showMessageDialog(null, "Guardado exitoso.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error en el guardado de datos.");
            }
        }
    }

}
