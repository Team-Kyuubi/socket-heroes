package multiplayer;

import prompt.Jogo;

import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    private final int porta;
    private Socket jogadorConectado;
    private Jogo jogo;

    public static void main(String[] args) {
        Servidor servidor = new Servidor();
        servidor.iniciar_servidor();
        servidor.getJogo().iniciarJogo();
    }

    public Servidor() {
        this.porta = 4200;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void iniciar_servidor() {
        try(ServerSocket serverSocket = new ServerSocket(porta)) {
            System.out.println("[SERVER] Servidor iniciado");
            System.out.println("[SERVER] Aguardando usuários...");
            while(jogadorConectado == null) {
                Socket userSocket = serverSocket.accept();
                jogadorConectado = userSocket;
                System.out.printf("[SERVER] Usuário (port: %d) conectado\n", userSocket.getPort());
                System.out.printf("[SERVER] Usuário (local port: %d) conectado\n", userSocket.getLocalPort());
            }
            this.jogo = new Jogo(this.jogadorConectado);
        } catch(Exception exception) {
            exception.printStackTrace();
        }
    }
}
