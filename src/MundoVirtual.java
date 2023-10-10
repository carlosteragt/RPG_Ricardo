import java.util.ArrayList;
import java.util.List;
public class MundoVirtual {
    private List<Missao> missoesAtivas;
    private List<Inimigo> inimigos;
    private int largura;
    private int altura;

    public int posicaoX;

    public int posicaoY;

    public MundoVirtual(int largura, int altura) {
        this.largura = Math.min(10, largura);
        this.altura = Math.min(10, altura);
        this.missoesAtivas = new ArrayList<>();
        this.inimigos = new ArrayList<>();
        this.posicaoX = 0;
        this.posicaoY = 0;
    }

    public List<Missao> getMissoesAtivas() {
        return missoesAtivas;
    }

    public List<Inimigo> getInimigos() {
        return inimigos;
    }

    public void inicarMissao(Missao missao, Personagem personagem) {
        missao.iniciarMissao(personagem);
    }
    public void completarMissao(Missao missao, Personagem personagem) {
        missao.completar(personagem);
    }
    public void ataquePersonagem(Personagem personagem, Habilidade habilidade, Inimigo inimigo) {
        personagem.atacarInimigo(inimigo,habilidade);
    }
    public void ataqueInimigo(Inimigo inimigo,Personagem personagem, Habilidade habilidade){
        inimigo.atacar(personagem,habilidade);
    }
    public void caminhar(Personagem personagem, int deltaX, int deltaY){
        personagem.moverPersonagem(deltaX,deltaY);
    }
    public void pegarItemPersonagem(Personagem personagem, Item item) {
        personagem.pegarItem(item);
    }
    public void usarItemPersonagem(Personagem personagem, Item item) {
        personagem.usarItem(item);
    }
    public void morrerInimigo(Inimigo inimigo){
        inimigo.morrer();
    }
    public void escolherHabilidadePersonagem(Personagem personagem,Inimigo inimigo){
        personagem.escolherHabilidadeEAtacar(inimigo);
    }
    public void escolherHabilidadeInimigo(Inimigo inimigo,Personagem personagem){
        inimigo.escolherHabilidadeEAtacarInimigo(personagem);
    }
}
