package tarefa;

import java.io.IOException;
import java.text.ParseException;
import lista.Elemento;
import lista.ListaEncadeada;
import object.Cliente;
import validacao.Validacao;

public class Visualizar {
    private static final Cliente t = new Cliente();
    
    public static void visualInicio(ListaEncadeada<Cliente> lista) throws IOException, ParseException {
        t.headerTabela();
        System.out.println(lista.pegaPrimeiroElemento().toString(1));
        t.footerTabela();
    }
    
    public static void visualFim(ListaEncadeada<Cliente> lista) throws IOException, ParseException {
        t.headerTabela();
        System.out.println(lista.pegaUltimoElemento().toString(1));
        t.footerTabela();
    }
     
    public static void visualPosicao(ListaEncadeada<Cliente> lista) throws IOException, ParseException {
        int id = (int) Validacao.num("ID [1 - "+lista.tamanho()+"]: ", 1, lista.tamanho());
        t.headerTabela();
        System.out.println(lista.pegaElemento(id).toString(1));
        t.footerTabela();
    }
    
    
}
