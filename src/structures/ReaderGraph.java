package structures;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class ReaderGraph {
    
    public static BufferedReader getReader(File f){
        BufferedReader br = null;

        try{
            br = new BufferedReader(new FileReader(f));
            
        }catch(IOException e){
            System.out.println("Erro ao tentar ler o arquivo");

        }finally{
            try {
                br.close();
            } catch (IOException e) {
                System.out.println("Erro ao fechar arquivo");
            }
            
        }
        return br;
    }

    public void reader (String file){
        File f = new File(file);
        BufferedReader br = getReader(f);
    }

}
