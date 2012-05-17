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
 *	@mainpage Main
 *	@version 1.0
 *	@author Diessica e Laraine <br />
 *	CreateDate 15-05-2012 <br />
 *	Universidade Federal do Pampa- Unipampa <br/>
 *	Programa desenvolvido na disciplina Sistemas Distribuídos 2011/1 <br/>
 *
 *	<h2>Card Gold Game : Teste sua sorte</h2>
 *  <h3>Jogo de Cartas</h3>
 *
 *	Descrição do problema <br />
 *	Desenvolvimento de uma biblioteca que defina os metodos usados um um jogo de cartas comun, sem a necessidade de haver controle da mão do jogador. Apenas uma aplicação simples.
 *	<br />
 *	Linguagem de Programação: Java <br />
 *	Ambiente de Desenvolvimento: Windows 7 <br /><br />
 *
 *
 *	Como Executar: <br />
 *	Abra o terminal e execute o seguinte comando de inicialização da máquina Java (conforme a versão em seu PC): <br />
 *	set PATH=%PATH%;C:\Arquivos de Programas\Java\jdk1.6.0_21\bin" <br />
 *	Terminal: <br />
 *	"Javac Main.java" <br />
 *	"Java Main" <br />
 *
 *	@author Diessica Goulart 2813193, Laraine Ramos 2813143
 *	@since 20/03/2011
 *	@version 1.0
 */


//package baralho;
//import baralho.*;
import java.util.*;

/**
 *	@file Main.java
 *
 * 	@brief Implementa e Executa os principais metodos da aplicacao do trabalho com as Cartas. Mátodos definidos no arquivo de Biblioteca "baralho.jar"
 *
 *  A biblioteca de manipulacao de baralho, por padrao o tradicional de 52 cartas sem curingas,
 *  que  deve fornecer uma representacao das cartas e funcoes/metodos/etc para manipulacao das 
 *  cartas. Sao esperadas as funcoes de  embaralhar, cortar em duas partes (em uma determinada
 *  posicao e juntando em um unico baralho no final), retirar uma carta do inicio e do final,
 *  passar uma carta do inicio para o final (sem mostrar que carta eh), e a criacao de um monte
 *  de descarte do qual podemos ver qualquer carta sem remove-la (no monte de compra uma carta
 *  soh pode ser vista se for removida dele).
 *
 *  Esta aplicação apenas faz uso dos métodos implementados neste projeto, não sendo necessariamente um jogo
 *
 *  A biblioteca deve omitir do programador/usuurio como os algoritmos e funcoes/metodos sao implementados.
 *  Quem for utilizar deve apenas se preocupar em mandar embaralhar as cartas, cortar, pegar cartas
 *  do monte ou do descarte, adicionar ao descarte e com essas acoes fazer um jogo.
 *
 *	@author Diessica Goulart 2813193, Laraine Ramos 2813143
 *	@since 15/05/2012
 *	@version 1.0
 */

public class Main {

    /**
     * @brief O metodo main, responsavel por iniciar a chamada dos metodos
     *
     * Inicia a partida do jogo
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> adversarios = new ArrayList<String>();
        adversarios.add("Ares");
        adversarios.add("Medeia");
        adversarios.add("Karonte");
        Scanner entrada = new Scanner(System.in);
        System.out.println("Card Gold Game : Teste sua sorte");
        System.out.println("Qual o seu nome?");
        String nome = entrada.nextLine();
        Jogador j = new Jogador(nome);
        Jogador a = new Jogador(adversarios.get((int)(Math.random() * adversarios.size() )));
        System.out.println("Ola "+j.getNome()+ " voce vai jogar com "+a.getNome());
        
		System.out.println(">> Embaralhando as cartas....\n");
        //embaralha os dois baralhos
       j.getBaralho().embaralhar();
       a.getBaralho().embaralhar();

       //vai cortar o baralho
       int p1 = (int) (1+ (Math.random() * 52));
       System.out.println("Escolha a posicao em que quer cortar o baralho de "+a.getNome());
       int p2 = entrada.nextInt();

       j.getBaralho().cortaBaralho(p1);
       a.getBaralho().cortaBaralho(p2);

       System.out.println("voce cortou o baralho de "+a.getNome()+" na posicao "+p2);
       System.out.println(a.getNome()+" cortou o baralho de "+j.getNome()+" na posicao "+p1);
       int i = 1;
       int resp;
       while(j.getBaralho().getTamanho() != 0 || a.getBaralho().getTamanho() != 0){
           System.out.println("-----------RODADA "+i+"--------------");
           System.out.println("Pressione 1: tirar carta do topo ou 2: tirar carta de baixo");
           resp = entrada.nextInt();
            //pega uma carta de cada, compara o maior ganha pontos
           Carta cj, ca;
           if(resp == 1){
                cj = j.getBaralho().getCartaTopo();
           }else{
                cj = j.getBaralho().getCartaBaixo();
           }
           int resp2 = (int) (1+ (Math.random() * 2));
           if(resp2 == 1){
                ca = a.getBaralho().getCartaTopo();
           }else{
                ca = a.getBaralho().getCartaBaixo();
           }
           System.out.println(j.getNome()+" jogou "+cj.toString()+ " : "+a.getNome()+" jogou "+ca.toString());
           if(cj.getNaipe().equals("ouros") && !(ca.getNaipe().equals("ouros"))){
               j.aumentaPontos(cj.getValor());
               System.out.println(j.getNome()+" GOLD");
           }else if(ca.getNaipe().equals("ouros") && !(cj.getNaipe().equals("ouros"))){
               a.aumentaPontos(ca.getValor());
               System.out.println(a.getNome()+" GOLD");
           }else{
               if(cj.getValor() > ca.getValor()){
                   j.aumentaPontos(1);
               }else if(cj.getValor() == ca.getValor()){
                   
               } else {
                   a.aumentaPontos(1);
               }
           }
           System.out.println("Pontos["+j.getNome()+" : "+j.getPontos()+" | "+a.getNome()+" : "+a.getPontos()+"]");
           i++;
        }
       System.out.println("--------------------------");
       if(j.getPontos() > a.getPontos()){
           System.out.println(j.getNome()+" WINS");
       }else{
           System.out.println(a.getNome()+" WINS");
       }
        System.out.println("--------------------------");

    }

}