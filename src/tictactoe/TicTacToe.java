package tictactoe;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    
    static ArrayList<Integer>giliranKita = new  ArrayList<Integer>();
    static ArrayList<Integer>giliranBot = new  ArrayList<Integer>();
    
    static boolean main = true;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        while (main) {
            System.out.println("SELAMAT DATANG DI GAME TIC TAC TOE!");
            System.out.println("1. Play ");
            System.out.println("2. Quit ");    
            System.out.print("Pilih: ");
            int pilihan = s.nextInt();
        
        switch (pilihan){
            case 1:
                play();
                break;
            case 2:
                System.out.println("Goodbye!");
                main = false;
                break;
            default:
                break;
            }    
            
        }
  
    }
    
    public static void play () {
        Scanner s = new Scanner(System.in);
        
        char [][] board = { {' ', '|', ' ', '|', ' '} , 
            {'-', '+', '-', '+', '-'}, 
            {' ', '|', ' ', '|', ' '}, 
            {'-', '+', '-', '+', '-'}, 
            {' ', '|', ' ', '|', ' '} };
        
        papanBermain(board);
        
        while (true){
            System.out.print("Masukkan pilihan (1-9): ");
            int pilih = s.nextInt();
            while(giliranKita.contains(pilih) || giliranBot.contains(pilih)){
            System.out.println("gabisa ngambil posisi ini, tolong pilih yang lain: ");
            pilih = s.nextInt();
        }
            
            taruh(board, pilih, "player");
            
            String result = pemenang();
            if(result.length() > 0) {
                papanBermain(board);
                System.out.println(result);
                main = false;
            break;
            }
        
            Random r = new Random();
            int pilih2 = r.nextInt(9) + 1;
            while(giliranKita.contains(pilih2) || giliranBot.contains(pilih2)){
//                System.out.println("gabisa bot");
            pilih2 = r.nextInt(9) + 1;
        }
            taruh(board, pilih2, "bot");
        
            papanBermain(board);
            
            result = pemenang(); 
            if(result.length() > 0) {
                papanBermain(board);
                System.out.println(result);
                main = false;
                break;
            }
        }
        
    }
    
    public static void papanBermain(char[][] board){
        for(char[] row : board){
            for(char c : row){
                System.out.print(c);
            }
            System.out.println("");
        }
    }
    
    public static void taruh(char[][] board, int pilih, String user){
        
        char symbol = ' ';
        
        if (user.equals("player")) {
            symbol = 'X';
            giliranKita.add(pilih);
        }else if(user.equals("bot")){
            symbol = 'O';
            giliranBot.add(pilih);
        }
        
        switch(pilih){
            case 1:
                board [0][0] = symbol;
                break;
            case 2:
                board [0][2] = symbol;
                break;
            case 3:
                board [0][4] = symbol;
                break;
            case 4:
                board [2][0] = symbol;
                break;
            case 5:
                board [2][2] = symbol;
                break;
            case 6:
                board [2][4] = symbol;
                break;
            case 7:
                board [4][0] = symbol;
                break;
            case 8:
                board [4][2] = symbol;
                break;
            case 9:
                board [4][4] = symbol;
                break;
            default:
                break;
        }
    }
    
    public static String pemenang(){
        List barisAtas = Arrays.asList(1, 2, 3);
        List barisTengah = Arrays.asList(4, 5, 6);
        List barisBawah = Arrays.asList(7, 8, 9);
        List tiangKiri = Arrays.asList(1, 4, 7);
        List tiangTengah = Arrays.asList(2, 5, 8);
        List tiangKanan = Arrays.asList(3, 6, 9); 
        List mereng1  = Arrays.asList(1, 5, 9);
        List mereng2 = Arrays.asList(7, 5, 3);
        
        List<List>winning = new ArrayList<List>();
        winning.add(barisAtas);
        winning.add(barisTengah);
        winning.add(barisBawah);
        winning.add(tiangKiri);
        winning.add(tiangTengah);
        winning.add(tiangKanan);
        winning.add(mereng1);
        winning.add(mereng2);
        
        for(List l : winning) {
            if(giliranKita.containsAll(l)){
                return "Hoki";
            }else if(giliranBot.containsAll(l)) {
                return "Skill issue";
            }else if(giliranKita.size() + giliranBot.size() ==9){
                return"Bruh!";
            }
           
        
    }
        return"";
}
}
    

