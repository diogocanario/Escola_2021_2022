
import java.time.LocalDate;
import java.time.Period;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diogo
 */
public class Pessoa{
    String nome;
    String morada;
    LocalDate DataDeNascimento;

    public Pessoa(String nome, String morada, LocalDate datanascimento) 
    {
        this.nome = nome;
        this.morada = morada;
        this.DataDeNascimento = DataDeNascimento;
    }
    
    
    public int getIdade()
    {
    
        LocalDate agora;
        agora = LocalDate.now();
        int anos = Period.between(DataDeNascimento, agora).getYears();
        return anos;
    }

    @Override
    public String toString() {
        return "nome:" + this.nome + " / idade: " + this.getIdade() + " anos"; //To change body of generated methods, choose Tools | Templates.
    }
    
}