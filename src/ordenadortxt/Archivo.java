package ordenadortxt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/*
    Clase dedicada a leer  el archivo TXT
*/
public class Archivo {
    
    public String abrirArchivo() {
        String aux="";   
            String texto = "";
        try
         {
        /**llamamos el metodo que permite cargar la ventana*/
        JFileChooser file=new JFileChooser();
        file.showOpenDialog(null);
        /**abrimos el archivo seleccionado*/
        File abre=file.getSelectedFile();

        /**recorremos el archivo, lo leemos para plasmarlo
        *en el area de texto*/
        if(abre!=null)
        {     
            FileReader archivos=new FileReader(abre);
            BufferedReader lee=new BufferedReader(archivos);
            while((aux=lee.readLine())!=null)
            {
                texto+= aux+ "-";
            }
            lee.close();
        }    
        }
        catch(IOException ex)
        {
        JOptionPane.showMessageDialog(null,ex+"" +
                "\nNo se ha encontrado el archivo",
                "ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
        }
        return texto;//El texto se almacena en el JTextArea
    }
    public void guardarFichero(String cadena, String nombre, File ruta){
        System.out.println("--------------------------\n"+cadena);
        FileWriter escribir;
        try {

            escribir = new FileWriter(ruta+".txt", true);
            escribir.write(cadena);
            escribir.close();

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar, ponga nombre al archivo");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar, en la salida");
        }
    }
    public long[] separadorVariables(String textoTxt){//direccion del archivo
        String[] numeroLineasTexto = textoTxt.split("-");
        long[] numerosTxtArray = new long[numeroLineasTexto.length];
        for (int i = 0; i < numeroLineasTexto.length; i++){
            numerosTxtArray[i]=Long.parseLong(numeroLineasTexto[i]);
        }
        return numerosTxtArray;
    }
}
