package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
/*  Задание 2
Пользователь с клавиатуры вводит путь к файлу. После чего запускаются три потока.
Первый поток заполняет файл случайными числами. Два других потока ожидают заполнения.
Когда файл заполнен оба потока стартуют. Первый поток находит факториал каждого числа в файле,
второй поток переписывает числа из файла с добавлением /.
Результаты каждый поток должен записать в новый файл.
В методе main необходимо отобразить статистику выполненных операций
*/
        File file = new File("dirtext", "text1.txt");
        Path path1 = Path.of(file.getAbsolutePath());
        File file1 = new File("dirtext", "text2.txt");
        Path path2 = Path.of(file1.getAbsolutePath());
        TH1 th1= new TH1(path1);
        th1.start();
        th1.join();
        TH2 th2 =new TH2(path1, path2);
        th2.start();
        TH3 th3 =new TH3(path1, path2);
        th3.start();
    }
}