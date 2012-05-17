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

//package baralho;
//import baralho.*;
import java.util.*;


/**
 *  @file Baralho.java
 *
 *  @brief Implementa os metodos definidos da Biblioteca Baralho.java presente no arquivo "baralho.jar"
 */


/**
 *  @class Baralho
 *
 *  @author Diessica Goulart 2813193, Laraine Ramos 2813143
 *  @since 15/05/2012
 *  @version 1.0
 */
public class Baralho{
    public static int possiveis[] ={1,2,3,4,5,6,7,8,9,10,11,12,13};
    public  List<Carta> baralho;
    public  List<Carta> descarte;

    /**
     *  Metodo Baralho() cria as castas dos naipes presentes em um baralho.
     *  @param baralho
     *  @param descarte
     */
    public Baralho(){
        baralho = new ArrayList<Carta>();
        descarte = new ArrayList<Carta>();
        for(int i=0; i < possiveis.length; i++){
            Carta novaCarta1 = new Carta(possiveis[i], "ouros");
            baralho.add(novaCarta1);
            Carta novaCarta2 = new Carta(possiveis[i], "copas");
            baralho.add(novaCarta2);
            Carta novaCarta3 = new Carta(possiveis[i], "espadas");
            baralho.add(novaCarta3);
            Carta novaCarta4 = new Carta(possiveis[i], "bastos");
            baralho.add(novaCarta4);
        }
    }
    /**
     *  Metodo getBaralho retorna um vetor de lista com o baralho.
     *  @return baralho
     */
    public List<Carta> getBaralho(){
	return baralho;
    }

    /**
     *  Metodo embaralhar() aplica a propriedade de embaralhar as cartas.
     */
    public void embaralhar(){
        Collections.shuffle(baralho);
    }

    /**
     *  Metodo mostraBaralho() exibe as cartas presentes no baralho.
     */
    public void mostraBaralho(){
        for(int i = 0; i < baralho.size(); i++){
            System.out.println(baralho.get(i).toString());
        }
    }

    /**
     * Metodo cortaBaralho() recebe um valor que eh usado para indicar em que posicao o baralho deve ser cortado.
     * @param posicao local onde o baralho deve ser cortado.
     */
    public void cortaBaralho(int posicao){
        List<Carta> aux = new ArrayList<Carta>();
        if(posicao < baralho.size() ){
            for(int i = posicao; i < baralho.size(); i++){
                aux.add(baralho.get(i));
            }
            for(int j = 0; j < posicao; j++){
                aux.add(baralho.get(j));
            }
        }
        baralho = aux;
    }


    /**
     *  Metodo getCartaTopo() retorna a carta que encontra-se no topo do vetor.
     *  @return Carta - esta no topo do baralho.
     */
    public Carta getCartaTopo(){
        Carta aux = baralho.get(baralho.size()-1);
        baralho.remove(baralho.size()-1);
        return aux;
    }

    /**
     *  Metodo getCartaBaixo() retorna a carta que encontr-se na ultima posicao do baralho, ou seja, em baixo.
     *  @return Carta - ultima carta do baralho.
     */
    public Carta getCartaBaixo(){
        Carta aux = baralho.get(0);
        baralho.remove(0);
        return aux;
    }

    /**
     *  Metodo que retira uma carta do topo do baralho e insere a mesma no final.
     *
     */
    public void BeginToEnd(){
        List<Carta> aux = new ArrayList<Carta>();
        aux.add(this.getCartaTopo());
        for(int i = 0; i < baralho.size(); i++){
            aux.add(baralho.get(i));
        }
        baralho = aux;
    }

    /**
     *  Metodo descartar() adiciona a carta recebida ao monte de descarte.
     *  @param Carta c - o descarte do baralho.
     */
    public void descartar(Carta c){
        descarte.add(c);
    }

    /**
     *  Moetod verDescarte() exibe as cartas presentes no monte de descarte.
     */
    public void verDescarte(){
        for (int i = 0; i < descarte.size(); i++){
            System.out.println(descarte.get(i).toString());
        }
    }

    /**
     *  Metodo getTamanho() retorna o tamanho do baralho.
     *  @return baralho.size
     */
    public int getTamanho(){
        return baralho.size();
    }
}
