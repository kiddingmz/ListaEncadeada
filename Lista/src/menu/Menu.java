package menu;
import Armazenamento.Armazenar;
import java.io.*;
import java.text.ParseException;
import validacao.Validacao;
import object.Cliente;
import lista.ListaEncadeada;
import tarefa.*;

public class Menu {
    byte opc;
    private static ListaEncadeada<Cliente> cliente;

    public Menu() {
        cliente = Armazenar.LerDadosDoFichObj("cliente");
    }
    
    public static void save() {
        Armazenar.GravarFichObj(cliente,"cliente");
    }
    public static void menu() throws ParseException, IOException {
        byte opc;
        do{
            System.out.print("\n\n\tGestao de Clientes\n");
            System.out.print("\n1 - Cliente");
            System.out.print("\n2 - Pesquisar");
            System.out.print("\n3 - Visualizar");
            System.out.print("\n4 - Limpar");
            System.out.print("\n0 - Sair");
            opc = (byte) Validacao.num("\nR: ",0,4);
            switch(opc){
                case 1:
                    menuCliente(); break;
                case 2:
                     if(cliente.eVazia())
                        System.out.println("\nNAO EH POSSIVEL PESQUISAR, LISTA VAZIA");
                     else
                         menuPesquisar(); break;
                case 3:
                     if(cliente.eVazia())
                        System.out.println("\nNAO EH POSSIVEL VISUALIZAR, LISTA VAZIA");
                     else
                        menuVisualizar(); break;
                case 4:
                    limpar(); break;
            }
        }while(opc != 0);
    }
    
    public static void menuCliente() throws IOException, ParseException {
        byte opc;
        do{
            System.out.print("\n\tCliente:");
            System.out.print("\n1 - Visualizar");
            System.out.print("\n2 - Inserir");
            System.out.print("\n3 - Atualizar");
            System.out.print("\n4 - Eliminiar");
            System.out.print("\n0 - Voltar");
            opc = (byte) Validacao.num("\nR: ",0,4);
            switch(opc){
                case 1:
                     if(cliente.eVazia())
                        System.out.println("\nNAO EH POSSIVEL VISUALIZAR, LISTA VAZIA");
                     else
                        cliente.visualizar();
                    break;
                case 2:
                  subMenuCliInser();
                    break;
                case 3:
                     if(cliente.eVazia())
                        System.out.println("\nNAO EH POSSIVEL ATUALIZAR, LISTA VAZIA");
                     else
                         Atualizar.atualizar(cliente);
                    break;
                case 4:
                     if(cliente.eVazia())
                        System.out.println("\nNAO EH POSSIVEL ELIMINAR, LISTA VAZIA");
                     else
                        subMenuCliRemov(); 
                    break;
            }
        }while(opc != 0);
    }
    
    
   public static void subMenuCliInser() throws IOException, ParseException {
        byte opc;
        do{
            System.out.print("\n\tINSERIR:");
            System.out.print("\n1 - Inicio");
            System.out.print("\n2 - Meio");
            System.out.print("\n3 - Fim");
            System.out.print("\n0 - Voltar");
            opc = (byte) Validacao.num("\nR: ",0,3);
            switch(opc){
                case 1:
                    Inserir.addClienteI(cliente);
                    break;
                case 2:
                    Inserir.addClienteM(cliente);
                    break;
                case 3:
                    Inserir.addClienteF(cliente);
                    break;
            }
        }while(opc != 0);
    }
   
   public static void subMenuCliRemov() throws IOException, ParseException {
        byte opc;
        do{
            System.out.print("\n\tREMOVER:");
            System.out.print("\n1 - Posicao");
            System.out.print("\n2 - Inicio");
            System.out.print("\n3 - Fim");
            System.out.print("\n4 - Elemento");
            System.out.print("\n0 - Voltar");
            opc = (byte) Validacao.num("\nR: ",0,4);
            switch(opc){
                case 1:
                    Remover.removerClientePos(cliente);
                    break;
                case 2:
                    Remover.removerClienteInicio(cliente);
                    break;
                case 3:
                    Remover.removerClienteFim(cliente);
                    break;
                case 4:
                    Remover.removerClientePesquisa(cliente);
                    break;
            }
        }while(opc != 0);
    }
    
    private static void menuPesquisar() throws ParseException {
        byte opc;
        do{
            System.out.print("\n\tPesquisar:\n\tClientes");
            System.out.print("\n1 - Um");
            System.out.print("\n2 - Varios");
            System.out.print("\n0 - Voltar");
            opc = (byte) Validacao.num("\nR: ",0,2);
            switch(opc){
                case 1:
                    Pesquisa.contem(cliente);
                    break;
                case 2:
                    Pesquisa.contemTodos(cliente);
                    break;   
            }
        }while(opc != 0);
    }
    
    private static void menuVisualizar() throws ParseException, IOException {
        byte opc;
        do{
            System.out.print("\n\tVisualizar:");
            System.out.print("\n1 - Primeiro");
            System.out.print("\n2 - Ultimo");
            System.out.print("\n3 - Posicao");
            System.out.print("\n4 - Todos");
            System.out.print("\n0 - Voltar");
            opc = (byte) Validacao.num("\nR: ",0,4);
            switch(opc){
                case 1:
                    Visualizar.visualInicio(cliente);
                    break;
                case 2:
                   Visualizar.visualFim(cliente);
                   break;
                case 3:
                    Visualizar.visualPosicao(cliente);
                    break;
                case 4:
                   cliente.visualizar();
                   break;
            }
        }while(opc != 0);
    }
   
    private static void limpar(){
        switch (Tarefa.limpar(cliente)) {
            case 1 -> System.out.println("\nLISTA LIMPADA");
            case -1 -> System.out.print("");
            default -> System.out.println("\nNAO FOI POSSIVEL LIMPAR, LISTA VAZIA");
        }
    }
    
}

