import java.io.*;
import java.util.Properties;

public class TestProperties {
    public static void main1(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("zh", "everything is gonging on");
        properties.setProperty("sh", "everything is gonging on");
        System.out.println(properties.getProperty("zh"));
        System.out.println(properties.getProperty("ph"));
        System.out.println(properties.getProperty("ph", "PH是世界上最好"));


    }

    //将属性输出到文件
    public static void main2(String[] args) {
        File file = new File("C:\\Users\\Lenovo\\IdeaProjects\\Collection\\src\\Hello.properties");
        Properties properties = new Properties();
        try (FileReader fileReader = new FileReader(file)) {
            properties.load(fileReader);
            System.out.println(properties.getProperty("nihao"));
            System.out.println(properties.getProperty("python"));
            System.out.println(properties.getProperty("javascript", "JavaScript和Java是兄弟"));
            properties.setProperty("python", "世界幻化");
            try (FileWriter writer = new FileWriter(file)) {
                properties.store(writer, "Add properties");
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    //通过属性文件读取内容
    public static void main(String[] args) {
        Properties properties = new Properties();
        try (InputStream in = TestProperties.class.getClassLoader().getResourceAsStream("Hello.properties")) {
            properties.load(in);
            properties.list(System.out);  //通过list方法打印到控制台
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
