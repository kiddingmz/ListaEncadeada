package lista;

import java.io.Serializable;

public class Elemento<Tipo> implements Serializable{
    public Tipo obj;
    public Elemento<Tipo> proximo;
}