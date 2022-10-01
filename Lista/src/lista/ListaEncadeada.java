package lista;

import java.io.Serializable;
import object.Tabela;

public class ListaEncadeada<Tipo extends Tabela> implements Operacoes<Tipo>, Serializable{
    private Elemento<Tipo> inicio;
    private int tamanho;
    
    public ListaEncadeada(){
        this.inicio = null;
        this.tamanho = 0;
    }
    
    @Override
    public boolean eVazia(){
        return (inicio == null) ? true : false;
    }
    
    @Override
    public int tamanho(){
        return tamanho;
    }
    
    @Override
    public void adicionaPosicao(int posicao, Tipo elemento){
        var novoElemento = new Elemento<Tipo>();
        
        if(elemento == null)
            throw new NullPointerException("Elemento Nulo");
        
        if(novoElemento == null){
            throw new OutOfMemoryError("Nao foi possivel alocar");
        }else{
            novoElemento.obj = elemento;
            
            if(eVazia() && (posicao - 1) == 0){
                novoElemento.proximo = null;
                inicio = novoElemento;
            }else{
                if(((posicao - 1) > (tamanho - 1))){
                    return;
                }else{
                    int i = 0;
                    var atual = inicio;
                    
                    while((atual != null) && (posicao - 1) > i){
                        atual = atual.proximo;
                        i++;
                    }
                    
                    if(atual == inicio){
                        novoElemento.proximo = inicio;
                        inicio = novoElemento;
                    }else{
                        if(atual != null){
                            novoElemento.proximo = atual.proximo;
                            atual.proximo = novoElemento;
                        }
                    }
                }
            }
        }
        
        tamanho++;
    }
    
    @Override
    public void adicionaInicio(Tipo elemento){
        var no = new Elemento<Tipo>();
        
        if(elemento == null)
            throw new NullPointerException("Elemento Nulo");
        
        if(no == null)
            throw new OutOfMemoryError("Nao foi possivel alocar");
        
        no.obj = elemento;
        
        if(inicio == null){
            no.proximo = null;
            inicio = no;
        }else{
            no.proximo = inicio;
            inicio = no;
        }
        
        tamanho++;
    }
    
    @Override
    public void adicionaFim(Tipo elemento){
        var no = new Elemento<Tipo>();
        var anterior = no;
        var aux = inicio;
        
        if(elemento == null)
            throw new NullPointerException("Elemento Nulo");
        
        if(no == null)
            throw new OutOfMemoryError("Nao foi possivel alocar");
        
        no.obj = elemento;
        
        if(eVazia()){
           no.proximo = null;
           inicio = no;
        }else{
            while(aux != null){
                anterior = aux;
                aux = aux.proximo;
            }
            anterior.proximo = no;            
        }
        
        tamanho++;
    }
    
    public void atualizar(int posicao, Tipo elemento){
        var atual = inicio;
        int i = 0;
        
        if(elemento == null)
            throw new NullPointerException("Elemento Nulo");
        
        if(eVazia() || (posicao - 1) > tamanho -1)
            throw new NullPointerException("Lista Vazia");
            

        while((atual != null) && (posicao - 1) > i){
            i++;
            atual = atual.proximo;
        }
        
        if(atual != null)
            atual.obj = elemento;
    }
    
    @Override
    public void removePosicao(int posicao){
       Elemento<Tipo> anterior = null;
       var atual = inicio;
       int i = 0;
       
       if(eVazia())
           throw new NullPointerException("Lista Vazia");
       
       while((atual != null) && (posicao - 1) > i){
           i++;
           anterior = atual;
           atual = atual.proximo;
       }
       
       if(atual == inicio)
           inicio = inicio.proximo;
       else
           anterior.proximo = atual.proximo;
       
       tamanho--;
    }
    
    @Override
    public void removeInicio(){
       var atual = inicio;
       
       if(eVazia())
           throw new NullPointerException("Lista Vazia");
       
       if(atual == inicio)
           inicio = inicio.proximo;
       
       tamanho--;
    }
    
    @Override
    public void removeFim(){
       Elemento<Tipo> anterior = null;
       var atual = inicio;
       int i = 0;
       
       if(eVazia())
           throw new NullPointerException("Lista Vazia");
       
       while((atual != null) && (tamanho -1) > i){
           i++;
           anterior = atual;
           atual = atual.proximo;
       }
       
       if(atual == inicio)
           inicio = inicio.proximo;
       else
           anterior.proximo = atual.proximo;
       
       tamanho--;
    }
    
    @Override
    public boolean removerElemento(Tipo elemento) {
        Elemento<Tipo> anterior = null;
        var atual = inicio;
        
        if(elemento == null)
            throw new NullPointerException("Elemento Nulo");
        
        if(eVazia())
            throw new NullPointerException("Lista Vazia");
            
        while((atual != null) && !atual.obj.toString().equals(elemento.toString())){
           anterior = atual;
           atual = atual.proximo;
        }
       
        if(atual != null){
            if(atual == inicio)
                inicio = inicio.proximo;
            else
                anterior.proximo = atual.proximo;
            
            tamanho--;
        }else{
            System.out.println("Elemento nao encontrado");
        }
        
        return false;
    }
    
    @Override
    public Tipo pegaElemento(int posicao){
        var aux = inicio;
        int i = 0;
        
        if(eVazia())
            throw new NullPointerException("Lista Vazia");
        
         if((posicao - 1) > tamanho -1)
            throw new NullPointerException("Posicao Invalida");
        
        while((aux != null) && (posicao - 1) > i){
            i++;
            aux = aux.proximo;
        }
        
        return aux.obj;
    }
    
    @Override
    public Tipo pegaPrimeiroElemento(){
        if(eVazia())
            throw new NullPointerException("Lista Vazia");
      
        return  inicio.obj;
    }
    
    @Override
    public Tipo pegaUltimoElemento(){
        var atual = inicio;
        int i = 0;
         
        if(eVazia())
            throw new NullPointerException("Lista Vazia");
       
        while((atual != null) && (tamanho - 1) > i){
            i++;
            atual = atual.proximo;
        }
        
        return atual.obj;
    }
    
    @Override
    public void limpar(){
        if(eVazia())
            throw new NullPointerException("Lista Vazia");
        
        while(inicio != null){
            inicio = inicio.proximo;
            tamanho--;
        }
    }
    
    @Override
    public boolean contem(Tipo elemento){
        var aux = inicio;
        
        if(elemento == null)
            throw new NullPointerException("Elemento Nulo");
        
        if(eVazia())
            throw new NullPointerException("Lista Vazia");
        
        while(aux != null){
            if(aux.obj.toString().equals(elemento.toString()))
                return true;
            
            aux = aux.proximo;
        }
        
        return false;
    }
    
    @Override
    public boolean contemTodos(Tipo elementos[]){
        int i = 0;
        
        if(elementos == null)
            throw new NullPointerException("Elemento Nulo");
        
        for(Tipo elemento : elementos){
            if(contem(elemento))
                i++;
        }
        
        if(i == elementos.length)
            return true;
        
        return false;
    }
    
    public void  visualizar(){
        var aux = inicio;
        int i = 1;
        if(eVazia())
            throw new NullPointerException("Lista Vazia");
        
        aux.obj.headerTabela();
        while((aux != null)){
            System.out.print(aux.obj.toString(i++));
            aux.obj.footerTabela();
            aux = aux.proximo;
        }
        System.out.println("");
    }  
}