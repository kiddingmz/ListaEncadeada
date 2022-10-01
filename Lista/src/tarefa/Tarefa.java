package tarefa;

import lista.ListaEncadeada;
import object.Cliente;
import validacao.Validacao;

public class Tarefa {
    public static byte limpar(ListaEncadeada<Cliente> lista){
        if(lista.eVazia())
            return 0;
        
        byte vali = (byte) Validacao.num("\nDeseja Limpar a Lista? [1 - SIM | 2 - NAO]\nR.:  ", 1, 2);
        if(vali == 1){
            lista.limpar();
            return 1;
        }
        return -1;
    }
} 

