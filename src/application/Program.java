package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.LogEntry;

public class Program {

    public static void main(String[] args) {
        
        // Cria um objeto Scanner para leitura de entrada do usuário.
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter file full path: ");
        // Lê o caminho completo do arquivo fornecido pelo usuário.
        String path = sc.nextLine();
        
        // Tenta abrir e ler o arquivo especificado pelo caminho.
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            
            // Cria um conjunto (Set) para armazenar os registros de log únicos.
            Set<LogEntry> set = new HashSet<>();
            
            // Lê a primeira linha do arquivo.
            String line = br.readLine();
            while(line != null) {                
                // Divide a linha em campos, onde o primeiro é o nome de usuário e o segundo é o momento.
                String[] fields = line.split(" ");
                String username = fields[0];
                Date moment = Date.from(Instant.parse(fields[1]));
                
                // Adiciona um novo objeto LogEntry ao conjunto.
                set.add(new LogEntry(username, moment));
                
                // Lê a próxima linha do arquivo.
                line = br.readLine();
            }
            
            // Exibe o número total de usuários únicos lidos do arquivo.
            System.out.println("Total users: " + set.size());
            
        } catch (IOException e) {
            // Trata exceções de I/O e exibe uma mensagem de erro.
            System.out.println("Error: " + e.getMessage());
        }
        
        // Fecha o objeto Scanner.
        sc.close();

    }

}
