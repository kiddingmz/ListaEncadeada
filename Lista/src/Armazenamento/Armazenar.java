package Armazenamento;

import java.io.*;
import lista.ListaEncadeada;
import object.Tabela;
public class Armazenar{
    
    public static <Tipo extends Tabela> void GravarFichObj(ListaEncadeada<Tipo> vec, String obj) {
        try {
            FileOutputStream ff = new FileOutputStream(obj + ".dat");
            ObjectOutputStream ss = new ObjectOutputStream(ff);
            ss.writeObject(vec);
            ss.close();
        } catch (IOException xx) {
            System.out.println(xx.toString());
        }
    }

    public static <Tipo extends Tabela> ListaEncadeada<Tipo> LerDadosDoFichObj(String obj) {
        var vec = new ListaEncadeada<Tipo>();
        try {
            FileInputStream ii = new FileInputStream(obj + ".dat");
            ObjectInputStream tt = new ObjectInputStream(ii);
            vec = (ListaEncadeada<Tipo>) tt.readObject();
            tt.close();

        } catch (FileNotFoundException ff) {
            System.out.println("Ficheiro de obj nao encontrado!");
        } catch (ClassNotFoundException cc) {
            System.out.println("Verifique a existencia da classe " + obj);
        } catch (IOException pp) {
            System.out.println("Problemas no leitura do ficheiro!");
        }
        return vec;
    }
}
