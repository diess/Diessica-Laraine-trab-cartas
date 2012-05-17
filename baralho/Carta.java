/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * Este trabalho esta licenciado sob a Licenca Creative Commons 
 * Attribution-ShareAlike 3.0 Brazil da Creative Commons.
 *
 * Para ver uma c�pia desta licenca, visite
 * http://creativecommons.org/licenses/by-sa/3.0/br/ 
 * ou envie uma carta para Creative Commons, 444 Castro
 * Street, Suite 900, Mountain View, California, 94041, USA.
 * 
 */
 
//package baralho;
//import baralho.*;

/**
 *  @file Carta.java
 *
 *  @brief Implementa os metodos definidos da Biblioteca Carta.java presente no arquivo "baralho.jar"
 */

/**
 *  @class Carta
 *  
 *  @author Diessica Goulart 2813193, Laraine Ramos 2813143
 *  @since 15/05/2012
 *  @version 1.0
 */
 
public class Carta {
    public int valor;
    public String naipe;

	public Carta(){
	}
    /**
     *  Metodo Carta() seta os valores recebidos da carte e o naipe.
     *  @param valor
     *  @param naipe
     */
    public Carta(int v, String n){
        valor = v;
        naipe = n;
    }
	
    /**
     *  Metodo getNaipe() retorna o naipe da carta do baralho.
     *  @return naipe - que armazena o naipe da carta.
     */
    public String getNaipe(){
        return naipe;
    }

    /**
     *  Metodo getValor() retorna o valor da carta.
     *  @return String valor
     */
    public int getValor(){
        return valor;
    }

    /**
     *  Metodo setValor() recebe o valor da carta que deve ser armazenado.
     *  @param String v
     */
    public void setValor(int v){
        valor = v;
    }

    /**
     *  Metodo setNaipe() recebe o naipe da carta que deve ser armazenado.
     *  @param String n
     */
    public void setNaipe(String n){
        naipe = n;
    }
	
    /**
     *  Metodo toString transforma o valor recebido na carta que deve ser exibida.
     *  @return String valor da carta.
     */
    @Override
    public String toString(){
        if(valor == 1){
            return "A de " + naipe;
        }else if(valor == 11){
            return "J de " + naipe;
        }else if(valor == 12){
            return "Q de " + naipe;
        }else if(valor == 13){
            return "A de " + naipe;
        }
        return valor+ " de "+ naipe;
    }

}
