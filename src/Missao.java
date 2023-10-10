import java.util.ArrayList;
import java.util.List;

public class Missao {

    public String titulo;
    public String descricao;
    public List<Item> recompensas;
    public String objetivos;

    public Missao(String titulo, String descricao,  String objetivos) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.recompensas = new ArrayList<>();
        this.objetivos = objetivos;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Item> getRecompensas() {
        return recompensas;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void iniciarMissao(Personagem personagem){
        System.out.println("A missão " + titulo + " foi iniciada por " + personagem.getNome() + "," + " seu objetivo é: " + descricao);
    }
    public void completar(Personagem personagem) {
        for (Item item : recompensas) {
            System.out.println(personagem.getNome() + " recebeu o item: " + item.getNome());
        }
        System.out.println("A Missão " + this.titulo + " foi completada por " + personagem.getNome());
    }
}