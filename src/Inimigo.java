import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Inimigo {
    private String nome;
    private int nivel;
    private int energia;
    private int saude;
    private List<Habilidade> habilidadesDeCombate;

    public Inimigo(String nome, int nivel, int energia, int saude) {
        this.nome = nome;
        this.nivel = nivel;
        this.energia = energia;
        this.saude = saude;
        this.habilidadesDeCombate = new ArrayList<>();
    }

    public int getSaude() {
        return saude;
    }

    public String getNome() {
        return nome;
    }

    public int getNivel() {
        return nivel;
    }

    public void setSaude(int saude) {
        this.saude = saude;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getEnergia() {
        return energia;
    }

    public List<Habilidade> getHabilidadesDeCombate() {
        return habilidadesDeCombate;
    }

    public void morrer() {
        System.out.println(" ");
    }

    public void atacar(Personagem personagem, Habilidade habilidade) {
        personagem.setSaude(personagem.getSaude() - habilidade.getDano());
        System.out.println("O inimigo " + nome + " contra-atacou o personagem " + personagem.getNome() + " com " + habilidade.getNome() + " causando " + habilidade.getDano() + " de dano. Agora ele possui " + personagem.getSaude() + " de vida!!");
        this.energia -= habilidade.getCustoEnergia();
        System.out.println("Agora o inimigo está com " + energia + " de energia.");

    }

    private static final Random random = new Random();

    public void escolherHabilidadeEAtacarInimigo(Personagem personagem) {
        List<Habilidade> habilidadesDisponiveis = getHabilidadesDeCombate();

        int indiceHabilidadeEscolhida = random.nextInt(habilidadesDisponiveis.size());

        Habilidade habilidadeEscolhida = habilidadesDisponiveis.get(indiceHabilidadeEscolhida);

        atacar(personagem, habilidadeEscolhida);
    }
}