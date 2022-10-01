package tarefa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import lista.ListaEncadeada;
import object.*;
import validacao.Validacao;

public class Pesquisa {
    private static SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
    
    public static void contem(ListaEncadeada<Cliente> lista) throws ParseException{
        Cliente cli;
        System.out.println("\nCliente\n");
        String nome = Validacao.texto("Nome Completo: ",3);
        int idade = (int) Validacao.num("Idade: ", 1, 100);
        String dataReg = Validacao.texto("Data do Registo [dd/MM/yyyy]: ",4);
        var data = dataFormatada.format(dataFormatada.parse(dataReg));
        
        cli = new Cliente(nome, idade, data);
        
        if(lista.contem(cli))
            System.out.println("\nELEMENTO ENCONTRADO");
        else
            System.out.println("\nELEMENTO NAO ENCONTRADO");
     }
    
    public static void contemTodos(ListaEncadeada<Cliente> lista) throws ParseException{
        System.out.println("\nCliente\n");
        
        System.out.println("Quantos Elementos Deseja Verificar?: ");
        int nrEl = (int) Validacao.num("R.: ", 1, 999999);
        
        Cliente cli[] = new Cliente[nrEl];
        
        for(int i = 0; i < nrEl; i++){
            System.out.println("\nCLIENTE: "+(1+i));
            String nome = Validacao.texto("Nome Completo: ",3);
            int idade = (int) Validacao.num("Idade: ", 1, 100);
            String dataReg = Validacao.texto("Data do Registo [dd/MM/yyyy]: ",4);
            var data = dataFormatada.format(dataFormatada.parse(dataReg));
            
            cli[i] = new Cliente(nome, idade, data);
        }
        
        if(lista.contemTodos(cli))
            System.out.println("\nELEMENTO ENCONTRADO");
        else
            System.out.println("\nELEMENTO NAO ENCONTRADO");
     }
  
}
