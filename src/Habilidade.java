public class Habilidade {
    public String nome;
    public String descricao;
    public int custoEnergia;
    public int dano;
    public Habilidade(String nome, String descricao, int custoEnergia,int dano) {
        this.nome = nome;
        this.descricao = descricao;
        this.custoEnergia = custoEnergia;
        this.dano = dano;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCustoEnergia() {
        return custoEnergia;
    }

    public void setCustoEnergia(int custoEnergia) {
        this.custoEnergia = custoEnergia;
    }


    public void ativarHabilidade(Personagem personagem) {
        System.out.println("A habilidade " + nome + " foi ativada");
        personagem.gastarEnergia(custoEnergia);
    }

}
