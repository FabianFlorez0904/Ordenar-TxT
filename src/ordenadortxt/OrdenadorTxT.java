
package ordenadortxt;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
public class OrdenadorTxT {
    public static long[] OrdenadorBurbuja(long[] A) {
        int i, j;
        long aux;
        for (i = 0; i < A.length - 1; i++) {
            for (j = 0; j < A.length - i - 1; j++) {
                if (A[j + 1] < A[j]) {
                    aux = A[j + 1];
                    A[j + 1] = A[j];
                    A[j] = aux;
                }
            }
        }
        return A;
    }
    public static void main(String[] args) {
        Archivo a = new Archivo();
        JOptionPane.showMessageDialog(null,"Bienvenido al ordenador de números\nDesarrollado por:\nFabian Dario Florez\nJuan Sebastian Arias\nJersson Andres Garzon\nPresiona Aceptar para continuar","Ordenador",1);
        do{
            JOptionPane.showMessageDialog(null,"A continuación seleccioné el documento que desea ordenar");
            String texto= a.abrirArchivo();
            System.out.println(texto);
            long[] numerosTxtArray = a.separadorVariables(texto);
            numerosTxtArray = OrdenadorBurbuja(numerosTxtArray);
            String numerosOrdenados="";
            for(int i=0; i< numerosTxtArray.length; i++){
                numerosOrdenados+=numerosTxtArray[i] + "\n";
            }
            JOptionPane.showMessageDialog(null,"El documento está siendo ordenado\nPresione Aceptar para guardar el documento ordenado","Cargando...",1);
            JFileChooser file=new JFileChooser();
            file.showSaveDialog(null);
            file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            /**abrimos el archivo seleccionado*/
            File archivo=file.getSelectedFile();
            String nombre = file.getSelectedFile().getName()+".txt";
            System.out.println(nombre);
            a.guardarFichero(numerosOrdenados, nombre, archivo);
            int opcion=JOptionPane.showConfirmDialog(null,"¿Desea ordenar otro documento?","ordenar",1);
            System.out.println(opcion);
            if(opcion==2||opcion==1){
                JOptionPane.showMessageDialog(null,"Cerrando programa","Cerrando",1);
                break;
            }
        }while(true);
        
    }
}
