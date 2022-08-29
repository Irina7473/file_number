package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class TH3 extends  Thread{
    private Path dir1;
    private Path dir2;

    public TH3(Path dir1, Path dir2) {

        this.dir1 = dir1;
        this.dir2 = dir2;
    }

    @Override
    public  void run(){
        try{
            BufferedReader reader = Files.newBufferedReader(dir1, StandardCharsets.UTF_8);
            BufferedWriter writer = Files.newBufferedWriter(dir2, StandardCharsets.UTF_8);
            String[] str = reader.readLine().split(" ");
            for (String s : str) {
                writer.write(s + "/");
                writer.flush();
                System.out.print(s + "/");
            }
        } catch (Exception e){
            new RuntimeException(e);
        }

    }

}
