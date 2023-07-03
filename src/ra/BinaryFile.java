package ra;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BinaryFile {
    public static void main(String[] args) {

//        List<String> list = new ArrayList<>();
//        list.add("Hùng");
//        list.add("Nam");
//        list.add("Phước");
        List<Book> list = new ArrayList<>();
        list.add(new Book(1,"Doremon"));
        list.add(new Book(2,"Pikachu"));
        list.add(new Book(3,"Hello Kirty"));
        list.add(new Book(4,"Tom and Jerry"));
//        writeToFile(list);
        for (Book b:readFromFile()) {
            System.out.println(b.getName());
        }
    }
    public  static void writeToFile(List<Book> list){
        try {
            FileOutputStream fos = new FileOutputStream("book.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  static List<Book> readFromFile(){
        try {
            FileInputStream fis = new FileInputStream("book.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
           return  (List<Book>)ois.readObject();
        }catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
