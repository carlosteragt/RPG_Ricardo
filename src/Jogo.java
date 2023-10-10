import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Jogo {
    public static void iniciarJogo() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean jogoAtivo = true;

        Item i1 = new Item("besta", "arma que atira", "longo alcance", "Sangramento");
        Item i3 = new Item("Poção de velocidade", "Poções", "Rapida", "Velocidade anormal");
        Inimigo troll = new Inimigo("troll", 10, 100, 100);
        Missao m1 = new Missao("Investida troll", "Mate 1 troll que está se aproximando da cidade", "Mate 1 troll");
        Habilidade h2 = new Habilidade("Disparo Perfurante", "Atravessa armadura", 10, 40);
        Habilidade h1 = new Habilidade("Rugir", "Som alto", 5, 10);
        Habilidade h3 = new Habilidade("Machadada violenta","machadada forte",10,13);
        Habilidade h4 = new Habilidade("Bola de Fogo", "Lança uma bola de fogo", 15, 55);
        Habilidade h5 = new Habilidade("Veneno Mortal", "Envenena o alvo", 8, 20);
        Habilidade h7 = new Habilidade("Ataque Duplo", "Realiza dois ataques em sequência", 12, 30);
        Habilidade h8 = new Habilidade("Soco poderoso","um soco bem forte",30,10);

        troll.getHabilidadesDeCombate().add(h2);
        troll.getHabilidadesDeCombate().add(h3);
        troll.getHabilidadesDeCombate().add(h1);
        Personagem personagem = null;

        MundoVirtual mundo = new MundoVirtual(10, 10);

        mundo.getInimigos().add(troll);
        mundo.getMissoesAtivas().add(m1);


        System.out.println("Bem-vindo ao Jogo de RPG!");
        System.out.println("1. Iniciar Jogo");
        System.out.println("0. Sair");

        int escolhaMenuInicial = scanner.nextInt();

        if (escolhaMenuInicial == 1) {

            personagem = new Personagem("Ricardo",123,200,100);
            System.out.print("O nome do personagem é  " + personagem.getNome() + ", ");
            personagem.getHabilidades().add(h4);
            personagem.getHabilidades().add(h5);
            personagem.getHabilidades().add(h7);
            System.out.println(" Posição Inicial: (" + personagem.getPosicaoX() + ", " + personagem.getPosicaoY() + ")");
        } else if (escolhaMenuInicial == 0) {

            System.out.println("Obrigado por jogar!");
            jogoAtivo = false;
        } else {
            System.out.println("Opção inválida. O jogo será encerrado.");
            jogoAtivo = false;
        }


        while (jogoAtivo) {

            int escolha = Menu.mostrarMenu();


            switch (escolha) {
                case 1:
                    mundo.inicarMissao(m1, personagem);
                    break;
                case 2:
                    mundo.caminhar(personagem, 0, -1);
                    break;
                case 3:
                    mundo.caminhar(personagem, 0, 1);
                    break;
                case 4:
                    mundo.caminhar(personagem, -1, 0);
                    break;
                case 5:
                    mundo.caminhar(personagem, 1, 0);
                    break;
                case 6:
                    personagem.getItens().add(i1);
                    mundo.pegarItemPersonagem(personagem, i1);
                    break;
                case 7:
                    personagem.getItens().add(i3);
                    mundo.usarItemPersonagem(personagem, i3);
                    break;
                case 8:
                    mundo.escolherHabilidadePersonagem(personagem,troll);
                    if (troll.getSaude() <= 0) {
                        mundo.morrerInimigo(troll);
                    } else {
                        mundo.escolherHabilidadeInimigo(troll,personagem);
                    }
                    break;
                case 9:
                    mundo.completarMissao(m1, personagem);
                    m1.getRecompensas().add(new Item("Poção de cura", "Poção que restaura a vida.", "Poção", "Cura"));
                    System.out.println("Recompensa: Poção de cura");
                    break;
                case 0:

                    System.out.println("Obrigado por jogar!");
                    jogoAtivo = false;
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
                    break;
            }
            System.out.println("Posição Atual: (" + personagem.getPosicaoX() + ", " + personagem.getPosicaoY() + ")");
        }
        scanner.close();
    }
}

