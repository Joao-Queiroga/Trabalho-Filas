package Estatico;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File partidas = new File("assets/partidas.txt");
        Scanner scanner = new Scanner(partidas);
        System.out.println(scanner.next());
    }
}