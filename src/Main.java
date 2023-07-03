import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\hung1\\OneDrive\\Desktop\\git.txt");
//        kiểm tra 1 file có tồn tại không
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        File userFile = new File("user.txt");
        System.out.println(userFile.exists());
        System.out.println(userFile.isDirectory());
        System.out.println(userFile.isFile());
        System.out.println("Absolute Path : "+userFile.getAbsolutePath());
        System.out.println(userFile.getParent());
        // Trà về độ dài nội dung của file đấy
        System.out.println("Dộ dài của nội dung trong file là "+userFile.length() + " byte");
        File resource = new File("resource");
        if(resource.isDirectory()){
            File[] listChild = resource.listFiles();
            for (File f:listChild
                 ) {
                System.out.println(f.getName());
            }
        }

        // thêm mới 1 đối tượng file
        File createFile = new File("book.txt");
        if(!createFile.exists()){
            createFile.createNewFile();
        }
        if(createFile.exists()){
            createFile.delete();
        }

//        writeToFile();
        // gọi phương thức đọc dữ liệu
        String result = (String) readFromFile();
        System.out.println(result);

    }
    // ghi ra 1 file dưới dạng text
    // FileWriter
    public static void writeToFile(){
        String path = "C:\\Users\\hung1\\OneDrive\\Desktop\\Sessionn16-IOFile\\user.txt";
        String word = "rikkei_academy";
        try {
            FileWriter fw =new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            fw.write(word);
            fw.flush();// Đây các dữ liệu luwuw trong bộ nhớ đệm ra file
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // đọc từ 1 file
    public static Object readFromFile() {
        String path = "C:\\Users\\hung1\\OneDrive\\Desktop\\Sessionn16-IOFile\\user.txt";
        String result = "";
        try {
            FileReader fw = new FileReader(path);
            BufferedReader br = new BufferedReader(fw);
            String line = "";
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                result+= line;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    // đọc ghi file nhị phân // đọc ghi các dư liệu dạng object

}