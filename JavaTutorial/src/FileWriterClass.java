import java.io.FileWriter;
import java.io.IOException;

public class FileWriterClass {
    public static void main(String[] args) throws IOException {

        try { // é obrigatório
            FileWriter writer = new FileWriter("poem.txt");
            writer.write("Roses are red\nViolets are blue\nBooty booty booty booty\nRockin' everywhere!");
            writer.append("\n(A poem by Pedro)"); // Adiciona
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
