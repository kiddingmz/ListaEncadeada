package object;

import java.io.Serializable;

public class Cliente implements Tabela, Serializable{
    private String nome;
    private int idade;
    private String diaReg;

    public Cliente() {}
    
    public Cliente(String nome, int idade, String diaReg) {
        this.nome = nome;
        this.idade = idade;
        this.diaReg = diaReg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getDiaReg() {
        return diaReg;
    }

    public void setDiaReg(String diaReg) {
        this.diaReg = diaReg;
    }

    @Override
    public String toString() {
        return  "nome = " + nome + ", idade = " + idade + ", diaReg = " + diaReg;
    }
    
    @Override
    public void headerTabela() {
        System.out.printf("\n%-10s %-30s %-7s %-20s"," __________","______________________________","________", "____________________ ");
        System.out.printf("\n%-10s %-30s %-7s %-20s |","| ID","| Nome ","| Idade ", "| Data de Registo");
        System.out.printf("\n%-10s %-30s %-7s %-20s"," __________","______________________________","________", "____________________ ");
    }

    @Override
    public String toString(int id) {
        return String.format("\n%s %-9s| %-29s| %-7s| %-19s%s", "|", id,this.nome,this.idade,this.diaReg,"|");
    }
    
    @Override
    public void footerTabela() {
        System.out.printf("\n%-10s %-30s %-7s %-20s"," __________","______________________________","________", "____________________ ");
    }
}
