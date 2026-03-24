import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);

            Scanner sc = new Scanner(System.in);

            System.out.print("Base: ");
            String base = sc.nextLine();

            System.out.print("Altura: ");
            String altura = sc.nextLine();

            String mensagem = base + "," + altura;

            OutputStream os = socket.getOutputStream();
            os.write(mensagem.getBytes());

            InputStream is = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int lidos = is.read(buffer);

            String resposta = new String(buffer, 0, lidos);
            System.out.println(resposta);

            socket.close();
        } catch (Exception e) {
            System.out.println("Erro na conexão");
        }
    }
}
