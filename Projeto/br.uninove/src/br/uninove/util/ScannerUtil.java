package br.uninove.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScannerUtil {

    public static void mostrar(String mensagem) {
        System.out.println(mensagem);

    }

    public static String getString(String mensagem) {
        Scanner leitor = new Scanner(System.in);
        System.out.print(mensagem);
        String result = leitor.nextLine();
        return result;

    }

    public static int getInt() {
        Scanner leitor = new Scanner(System.in);
        int result = leitor.nextInt();
        return result;
    }

    public static boolean confirm(String mensagem) {
        Scanner leitor = new Scanner(System.in);
        System.out.print(mensagem);
        String result = leitor.nextLine();
        return "S".equalsIgnoreCase(result);
    }
    
    public static Date getDate(String mensagem){
        
        try {
            
            Scanner leitor = new Scanner(System.in);
            SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
            
            System.out.print(mensagem);
            Date result = formatDate.parse(leitor.nextLine());
            
            return result;
            
        } catch (ParseException ex) {
            return null;
        }finally{
            
        }
    }

}
