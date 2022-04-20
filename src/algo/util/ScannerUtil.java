package algo.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerUtil {

    public static List<Integer> readIntegers(String path) {
        Scanner scanner = null;
        List<Integer> list = new ArrayList<>();
        try {
            scanner = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return list;
        }
        while(scanner.hasNextInt()){
            list.add(scanner.nextInt());
        }
        return list;
    }
}
