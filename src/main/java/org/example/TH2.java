package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class TH2 extends  Thread{

    private Path dir1;
    private Path dir2;

    public TH2(Path dir1, Path dir2) {

        this.dir1 = dir1;
        this.dir2 = dir2;
    }

    @Override
    public void run(){
        try{
            BufferedReader reader = Files.newBufferedReader(dir1, StandardCharsets.UTF_8);
            BufferedWriter writer = Files.newBufferedWriter(dir2, StandardCharsets.UTF_8);
            String[] str = reader.readLine().split(" ");
            for (String s : str) {
                int i = Integer.valueOf(s);
                int f = Factorial(i);
                writer.write(f + ";");
                writer.flush();
                System.out.print(f + ";");
            }
        } catch (Exception e){
            new RuntimeException(e);
        }
    }

    private  int Factorial(int num){
        int f=1;
        if(num>1)
            for (int i = 1; i <= num; i++) f *= i;
        return f;
    }
}
