package tarefa;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import lista.ListaEncadeada;
import object.Cliente;
import validacao.Validacao;

public class Atualizar {
    private static SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
    
    public static void atualizar(ListaEncadeada<Cliente> lista) throws IOException, ParseException {
        int pos;
        Cliente cli;
        
        pos = (int)Validacao.num("ID [ "+lista.tamanho()+" ]: ", 1, lista.tamanho());
        
        cli = lista.pegaElemento(pos);
        
        String nome = Validacao.texto("Nome Completo: ",3);
        int idade = (int) Validacao.num("Idade: ", 1, 100);
        String dataReg = Validacao.texto("Data do Registo [dd/MM/yyyy]: ",4);
        var data = dataFormatada.format(dataFormatada.parse(dataReg));
        
        cli.setNome(nome);
        cli.setDiaReg(data);
        cli.setIdade(idade);
     
        lista.atualizar(pos, cli);
    }
}
