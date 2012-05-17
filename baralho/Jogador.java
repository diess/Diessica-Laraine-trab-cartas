/*
 * Este trabalho esta licenciado sob a Licenca Creative Commons 
 * Attribution-ShareAlike 3.0 Brazil da Creative Commons.
 *
 * Para ver uma copia desta licenca, visite
 * http://creativecommons.org/licenses/by-sa/3.0/br/ 
 * ou envie uma carta para Creative Commons, 444 Castro
 * Street, Suite 900, Mountain View, California, 94041, USA.
 * 
 */

 /**
 *  @file Jogador.java
 *
 *  @brief Implementa os metodos para criar o jogador.
 */
 
//package baralho;
//import baralho.*;

/**
 *  @class Jogador
 *	@author Diessica Goulart 2813193, Laraine Ramos 2813143
 *	@since 15/05/2012
 *	@version 1.0
 */
public class Jogador {
    private  String nome;
    private  int pontos;
    private  Baralho deck;

	/**
	 *  Metodo Jogador() seta o nome e bontuação do jogador
	 *  @param nome - digitado pelo jogador
	 *  @param pontos - atribuidos ao jogador
	 */
    public Jogador(String n){
        nome = n;
        pontos = 0;
        deck = new Baralho();
    }
	
	/**
	 *  Metodo getNome() retorna o nome do jogador.
	 *  @return nome - do jogador.
	 */
    public String getNome(){
        return nome;
    }

	/**
	 *  Metodo getPontos() - retorna os pontos obtidos pelo jogador.
	 *  @return pontos - obtidos pelo jogador.
	 */
    public int getPontos(){
        return pontos;
    }

	/**
	 *  Metodo getBaralho() retorna o baralho.
	 *  @return deck - baralho.
	 */
    public Baralho getBaralho(){
        return deck;
    }

	/**
	 *  Metodo setNome() recebe o nome do jogador.
	 *  @param nome - do jogador.
	 */
    public void setNome(String n){
        nome = n;
    }

	/**
	 *  Metodo aumentaPontos() recebe a pontuacao obtida na rodada da partida.
	 *  @param pontos - pontos obtidos.
	 */
    public void aumentaPontos(int p){
        pontos += p;
    }
}

