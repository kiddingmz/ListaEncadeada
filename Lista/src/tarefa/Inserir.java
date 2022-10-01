package tarefa;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import lista.*;
import object.Cliente;
import validacao.Validacao;

public class Inserir {
    private static SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
    private static Date dataAtual = new Date();
    
    public static void addClienteI(ListaEncadeada<Cliente> lista) throws IOException, ParseException {
        System.out.println("\nCliente\n");
        String nome = Validacao.texto("Nome Completo: ",3);
        int idade = (int) Validacao.num("Idade: ", 1, 100);
        var dataReg = dataFormatada.format(dataAtual);
        Cliente cliente = new Cliente(nome, idade, dataReg);
        lista.adicionaInicio(cliente);
    }
    
    public static void addClienteM(ListaEncadeada<Cliente> lista) throws IOException, ParseException {
        
        System.out.println("\nCliente\n");
        int pos = (int) Validacao.num("Informe a posicao [ 1 - "+lista.tamanho()+" ]: ", 1, lista.tamanho());
        String nome = Validacao.texto("Nome Completo: ",3);
        int idade = (int) Validacao.num("Idade: ", 1, 100);
        var dataReg = dataFormatada.format(dataAtual);
        Cliente cliente = new Cliente(nome, idade, dataReg);
        lista.adicionaPosicao(pos, cliente);
    }
    
    public static void addClienteF(ListaEncadeada<Cliente> lista) throws IOException, ParseException {
        System.out.println("\nCliente\n");
        String nome = Validacao.texto("Nome Completo: ",3);
        int idade = (int) Validacao.num("Idade: ", 1, 100);
        var dataReg = dataFormatada.format(dataAtual);
        Cliente cliente = new Cliente(nome, idade, dataReg);
        lista.adicionaFim(cliente);
    }
}
