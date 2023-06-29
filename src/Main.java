import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        try{
            File file = new File(string);
            if(file.isFile()){
               long size =  file.length();
                System.out.println(size);
                readFormat(size);
            }else if(file.isDirectory()){
                long sum = Files.walk(Paths.get(string)).map(p -> p.toFile()).filter(File::isFile).mapToLong(s -> s.length()).sum();
                System.out.println(sum);
                readFormat(sum);
            }
        } catch (Exception e) {
           //throw new RuntimeException(e);
            System.out.println("Неверно указан путь");
            System.out.println("Ошибка");
        }

    }
    public static void readFormat(long s){
        if(s/1024/1024/1024>=1){
            System.out.printf("%.2f гигабайт",(double)s/1024/1024/1024);
            return;
        }
        if(s/1024/1024>=1){
            System.out.printf("%.2f мегабайт",(double)s/1024/1024);
            return;
        }
        if(s/1024>=1){
            System.out.printf("%.2f килобайт",(double)s/1024);

        }
        else{
            System.out.printf("%.2f байт",(double)s);

        }
//         if(s/1024/1024/1024<1){
//            if(s/1024/1024<1){
//                if(s/1024<1){
//                    System.out.println(s+" байт");
//                }else{
//                    System.out.println(s/1024+" килобайт");
//                }
//            }else{
//                System.out.println(s/1024/1024+" мегабайт");
//            }
//        }else{
//            System.out.println(s/1024/1024/1024+" гигабайт");
//        }
    }
}
