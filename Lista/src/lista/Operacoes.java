package lista;
public interface Operacoes<Tipo>{
    public void adicionaInicio(Tipo elemento);
    public void adicionaFim(Tipo elemento);
    public void adicionaPosicao(int posicao, Tipo elemento);
    public void removeInicio();
    public void removePosicao(int posicao);
    public void removeFim();
    public boolean removerElemento(Tipo elemento);
    public boolean eVazia();
    public void limpar();
    public boolean contem(Tipo elemento);
    public boolean contemTodos(Tipo elementos[]);
    public Tipo pegaElemento(int posicao);
    public Tipo pegaPrimeiroElemento();
    public Tipo pegaUltimoElemento();
    public int tamanho();
}
