package dslkdonDao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LinkDao {

    public void ghiFile(Link first) {
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;
        try {

            fout = new FileOutputStream("D:\\Code\\phuoc_tap_lap_trinh\\javahdt\\section01\\CTDLVAGT\\src\\vinhhoanhao.txt");
            oos = new ObjectOutputStream(fout);
            oos.writeObject(first);

            System.out.println("Xong rồi!");
        } catch (IOException ex) {
        } finally {
            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e) {
                }
            }

            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                }
            }
        }
    }

    public Link docFile(String filename) {

        Link first = new Link();

        FileInputStream fin = null;
        ObjectInputStream ois = null;
        try {
            fin = new FileInputStream(filename);
            ois = new ObjectInputStream(fin);
            first = (Link) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
        } finally {
            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
                }
            }

            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                }
            }

        }
        return first;
    }

}
