package dslkdoiDao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DoubleLinkDAO {
    public void writeFile(DoubleLinkDAO first) {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get("/Users/admin/Documents/JAVA PROJECT/Data Structure and Algorithms/CTDLK21/src/ctdl_gt/dslkdoi/savefiledoubleLink")))) {
            oos.writeObject(first);
            System.out.println("Ghi DoubleLinkedList vào file thành công.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public DoubleLinkDAO readFile(String filename){
        DoubleLinkDAO first = new DoubleLinkDAO();
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(filename)))) {
            first = (DoubleLinkDAO) ois.readObject();
            System.out.println("Đọc LinkedList từ file thành công.");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return first;
    }
}
