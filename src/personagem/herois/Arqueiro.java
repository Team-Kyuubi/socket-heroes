package personagem.herois;

public class Arqueiro extends Heroi {

    public Arqueiro(int ataque, int vida, int defesa) {
        super(ataque, vida, defesa);
    }

    @Override
    public String toString() {
        return "Você é um arqueiro." +
                "\nVida: " + getVidaAtual() +
                "\nAtaque: " + getAtaqueAtual() +
                "\nDefesa: " + getDefesaAtual() +
                "\n";
    }

    @Override
    public String classeHeroi() {
        return "Arqueiro";
    }
}