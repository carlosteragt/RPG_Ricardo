import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Personagem {
    public int posicaoX;

    public int posicaoY;
    public String nome;
    public int nivel;
    public int saude;
    public int energia;
    public List<Habilidade> habilidades;
    public List<Item> itens;

    public Personagem(String nome, int nivel, int saude, int energia) {
        super();
        this.nome = nome;
        this.nivel = nivel;
        this.saude = saude;
        this.energia = energia;
        this.habilidades = new ArrayList<>();
        this.itens = new ArrayList<>();
        this.posicaoX = 0;
        this.posicaoY = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getSaude() {
        return saude;
    }

    public void setSaude(int saude) {
        this.saude = saude;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public List<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidade> habilidades) {
        this.habilidades = habilidades;
    }

    public List<Item> getItens() {
        return itens;
    }

    public int getPosicaoX() {
        return posicaoX;
    }

    public int getPosicaoY() {
        return posicaoY;
    }

    public void gastarEnergia(int custoEnergia) {
        energia -= custoEnergia;
    }

    public void atacarInimigo(Inimigo inimigo,Habilidade habilidade){
        if (inimigo.getSaude() <= 0) {
            System.out.println("O inimigo " + inimigo.getNome() + " já está derrotado.");
            return;
        }
        inimigo.setSaude(inimigo.getSaude() - habilidade.getDano());
        System.out.println("Você atacou o inimigo " + inimigo.getNome() + " com " + habilidade.getNome() + " causando " + habilidade.getDano() + " de dano. Agora ele possui " + inimigo.getSaude() + " de vida!!");
        this.energia -= habilidade.getCustoEnergia();
        System.out.println("Agora você está com " + energia + " de energia.");
        if (inimigo.getSaude() <= 0) {
            System.out.println("Você derrotou o inimigo " + inimigo.getNome() + "!");
        } else {
            if (this.getSaude() <= 0) {
                System.out.println("Você foi derrotado pelo inimigo " + inimigo.getNome() + ".");
            }
        }
    }

    public void pegarItem(Item item){
        System.out.println("Você pegou o item "+ item.getNome());
        itens.add(item);
    }
    public void usarItem(Item item){
        for (Item i : itens) {
            if (i.getNome().equals(item.getNome())) {
                item.usarItem(item);
            }
        }
    }

    public void moverPersonagem(int deltaX, int deltaY) {
        int novaPosX = posicaoX + deltaX;
        int novaPosY = posicaoY + deltaY;

        if (novaPosX >= 0 && novaPosY >= 0) {
            posicaoX = novaPosX;
            posicaoY = novaPosY;
            System.out.println("Personagem movido para (X = " + posicaoX + ", Y = " + posicaoY + ")");
        } else {
            System.out.println("Alerta: Você não pode sair para uma posição fora dos limites!");
        }
    }
    public void escolherHabilidadeEAtacar(Inimigo inimigo) {
        Scanner scanner = new Scanner(System.in);
        List<Habilidade> habilidadesDoPersonagem = this.getHabilidades();
        for (int i = 0; i < habilidadesDoPersonagem.size(); i++) {
            Habilidade habilidade = habilidadesDoPersonagem.get(i);
            System.out.println((i + 1) + ". " + habilidade.getNome()); // Exibir o nome da habilidade
        }
        if(inimigo.getSaude()<= 0){
            System.out.println(" ");
        }
        System.out.print("Escolha uma habilidade para usar: ");
        int escolhaHabilidade = scanner.nextInt();

        if (escolhaHabilidade >= 1 && escolhaHabilidade <= habilidadesDoPersonagem.size()) {
            Habilidade habilidadeEscolhida = habilidadesDoPersonagem.get(escolhaHabilidade - 1);

            this.atacarInimigo(inimigo, habilidadeEscolhida);
        } else {
            System.out.println("Opção inválida. Escolha novamente.");
        }
    }

}