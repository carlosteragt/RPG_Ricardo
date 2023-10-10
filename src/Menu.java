import java.util.Scanner;

public class Menu {
    public static int menuInicial() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao Jogo RPG!");
        System.out.println("Escolha uma opção:");
        System.out.println("1. Iniciar jogo");
        System.out.println("2. Sair");
        System.out.print("Opção: ");
        return scanner.nextInt();
    }
    public static int mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha uma ação:");
        System.out.println("1. Iniciar Missão");
        System.out.println("2. Mover para cima");
        System.out.println("3. Mover para baixo");
        System.out.println("4. Mover para a esquerda");
        System.out.println("5. Mover para a direita");
        System.out.println("6. Pegar item");
        System.out.println("7. Usar item");
        System.out.println("8. Atacar inimigo");
        System.out.println("9. Completar Missão");
        System.out.println("0. Sair");
        System.out.print("Opção: ");
        return scanner.nextInt();
    }
}