package tarefa;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import lista.*;
import object.Cliente;
import validacao.Validacao;

public class Remover {
    private static SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
    
    public static void removerClientePos(ListaEncadeada<Cliente> lista) throws IOException {
        System.out.println();
        lista.visualizar();
        
        System.out.println("\n\tELIMINAR CLIENTE:\n");
        int id =(int) Validacao.num("ID: ", 1, lista.tamanho());
        
        if(lista.pegaElemento(id) ==  null) {
            System.out.println("\nCLIENTE NAO ENCONTRADO\n");
            return;
        }
        
        byte conf =(byte) Validacao.num("\nConfirmacao da elimanacao\n1 - SIM\t"
                + "2 - NAO\nR.: ",1,2);
        if(conf == 1){
            lista.removePosicao(id);
            System.out.println("\nREMOVIDO COM SUCESSO!\n");
        }
    }
    
    public static void removerClienteFim(ListaEncadeada<Cliente> lista) throws IOException {
        System.out.println();
        lista.visualizar();
        
        System.out.println("\n\tELIMINAR CLIENTE:\n");
        
       byte conf =(byte) Validacao.num("\nConfirmacao da elimanacao\n1 - SIM\t"
                + "2 - NAO\nR.: ",1,2);
        if(conf == 1){
            lista.removeFim();
            System.out.println("\nREMOVIDO COM SUCESSO!\n");
        }
    }
    
    public static void removerClienteInicio(ListaEncadeada<Cliente> lista) throws IOException {
        System.out.println();
        lista.visualizar();
        
        System.out.println("\n\tELIMINAR CLIENTE:\n");
        
        byte conf =(byte) Validacao.num("\nConfirmacao da elimanacao\n1 - SIM\t"
                + "2 - NAO\nR.: ",1,2);
        if(conf == 1){
            lista.removeInicio();
            System.out.println("\nREMOVIDO COM SUCESSO!\n");
        }
    }
    
    public static void removerClientePesquisa(ListaEncadeada<Cliente> lista) throws IOException, ParseException {
        System.out.println();
        lista.visualizar();
        System.out.println("\n\tELIMINAR CLIENTE:\n");
        System.out.println();
        String nome = Validacao.texto("Nome Completo: ",3);
        int idade = (int) Validacao.num("Idade: ", 1, 100);
        String dataReg = Validacao.texto("Data do Registo [dd/MM/yyyy]: ",4);
        var data = dataFormatada.format(dataFormatada.parse(dataReg));
        var cliente = new Cliente(nome, idade, data);
        
        if(!lista.contem(cliente)) {
            System.out.println("\nCLIENTE NAO ENCONTRADO\n");
            return;
        }
        
        byte conf =(byte) Validacao.num("\nConfirmacao da elimanacao\n1 - SIM\t"
                + "2 - NAO\nR.: ",1,2);
        if(conf == 1){
            lista.removerElemento(cliente);
            System.out.println("\nREMOVIDO COM SUCESSO!\n");
        }
    }
}
