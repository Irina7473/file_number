package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class TH1 extends Thread{
    private Path dir;

    public TH1(Path dir) {
        this.dir = dir;
    }

    @Override
    public  void run(){
        Random rnd = new Random(System.currentTimeMillis());
        try{
            BufferedWriter writer = Files.newBufferedWriter(dir, StandardCharsets.UTF_8);
            for (int i=0; i<1000; i++) {
                writer.write(rnd.nextInt(10) + " ");
                writer.flush();
            }
        } catch (Exception e){
            new RuntimeException(e);
        }

    }
}
