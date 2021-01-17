import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.Scanner;

public class Cript {

	static byte[] encoder;
	static byte[] decoder;
	static int opcao = 0;

	public static void main(String[] args) throws IOException {

		File arquivo = new File("c:/pasta/arq.txt");
		String textoDoArquivo = null;
		Scanner input = new Scanner(System.in);

		while (true) {

			System.out.println("Bem vindo ao seu criptografador de arquivos");
			System.out.println("O que deseja fazer");
			System.out.println("1 - Gerar arquivo plano");
			System.out.println("2 - Criptografar arquivo");
			System.out.println("3 - Decriptografar arquivo");
			System.out.println("4 - Sair");
			opcao = input.nextInt();

			switch (opcao) {

			case 1:

				input.nextLine();
				FileWriter fw = new FileWriter(arquivo.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);

				System.out.println("O que deseja escrever no arquivo?");
				textoDoArquivo = input.nextLine();

				bw.write(textoDoArquivo);
				bw.close();
				fw.close();
				System.out.println("Arquivo plano gerado e salvo em C:/pasta");

				break;
			case 2:

				byte[] bytes = Files.readAllBytes(arquivo.toPath());
				encoder = Base64.getEncoder().encode(bytes);
				textoDoArquivo.toCharArray();

				FileOutputStream arquivoDeSaidaCodificado = new FileOutputStream("c:/pasta/arq.txt");
				arquivoDeSaidaCodificado.write(encoder);
				arquivoDeSaidaCodificado.close();

				System.out.println("Arquivo criptografado gerado e salvo na pasta C:/pasta");
				break;

			case 3:
				decoder = Base64.getDecoder().decode(encoder);

				FileOutputStream arquivoDeSaidaDecodificado = new FileOutputStream("c:/pasta/arq.txt");
				arquivoDeSaidaDecodificado.write(decoder);
				arquivoDeSaidaDecodificado.close();

				System.out.println("Arquivo decriptografado gerado e salvo na pasta C:/pasta");
				break;

			case 4:
				System.exit(opcao);

			default:
				System.out.println("Opção inválida! Digite novamente.");
			}

		}
	}
}
