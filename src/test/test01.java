/*
    *You are designing a compiler for a program and need to check that braces in any given file are balanced. 
    *Braces in a string are considered to be balanced if the following criteria are met: All braces must be closed. 
    *Braces come in pairs of the form (), {} and []. 
    *The left brace opens the pair, and the right one closes it. 
 */
package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author RANGGA
 */
public class test01 {
    //private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int valuesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] values = new String[valuesCount];

        for (int i = 0; i < valuesCount; i++) {
            String valuesItem = scanner.nextLine();
            values[i] = valuesItem;
        }

        String[] res = braces(values);

        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(res[i]);

            if (i != res.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();*/
        
        /*String[] values = {"{[()]}","{[(])}","{{[[(())]]}}"};
        
        braces(values);*/
        
        String[] myList = getValue().split("_");
        System.out.println("test.test01.main()");
    }
    
    public static String getValue(){
        String str = "";
        FileInputStream fis = null;
        BufferedReader reader = null;
      
        try{
            fis = new FileInputStream("test/test01/input003.txt");
            reader = new BufferedReader(new InputStreamReader(fis));
          
            String line = reader.readLine();
            while(line != null){                
                str += str.length() > 0 ? "_" : "";
                str += line;
                line = reader.readLine();
            }           
          
        }catch(Exception e){
            
        }
        
        return str;
    }
    
    static String[] braces(String[] values) {
        String[] arr = new String[values.length];
        
        Boolean ch = true;
        String trys = "";
        for(int a = 0; a < values.length; a++){   
            trys += trys == "" ? "" : "|";
            
            String isKurung = "";
            String isKurawal = "";
            String isSiku = "";
            
            int x = ((values[a].length()) / 2) -1;
            int y = 0;
            for(int b = 0; b < values[a].length();b++){
                String str = String.valueOf(values[a].charAt(b));                 
                        
                if(str.equals("(")){
                    isKurung += isKurung == "" ? "" : "|";
                    isKurung += x - b;
                }else if(str.equals("{")){
                    isKurawal += isKurawal == "" ? "" : "|";
                    isKurawal += x - b;
                }else if(str.equals("[")){
                    isSiku += isSiku == "" ? "" : "|";
                    isSiku += x - b;
                }
            }
            
            ch = cek(values, a, isKurung, x, ")");
            if(ch)  ch = cek(values, a, isKurawal, x, "}");
            if(ch)  ch = cek(values, a, isSiku, x, "]");
            
            
            trys += ch? "YES": "NO";            
        }
        System.out.println(trys);
        String[] ars = trys.split("\\|");
        return ars;
    }
    
    static Boolean cek(String[] values, int a, String st, int x, String ck) {
        String tr = "";        
        int ty = 0;
        int zx = 0;
        
        for(int b = 0; b < values[a].length();b++){
            String str = String.valueOf(values[a].charAt(b));

            if(str.equals(ck)){
                String[] arrKurung = st.split("|"); 
                zx = arrKurung.length > 1 ? arrKurung.length -1 : arrKurung.length;
                        
                for(int c = 0; c < arrKurung.length; c++){
                    if(!arrKurung[c].equals("|")
                            && b == ((x + 1) + Integer.valueOf(arrKurung[c]))){
                        ty += 1;
                    }
                }
            }
        }
        return ty == zx ? true : false;
    }
}
