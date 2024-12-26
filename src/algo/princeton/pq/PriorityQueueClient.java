package algo.princeton.pq;

import algo.util.ScannerUtil;

import java.util.List;

public class PriorityQueueClient {

    public static void main(String[] args) {
        clientPQUnorderedBF();
    }

    public static void clientPQUnorderedBF() {
        // keep max N numbers in pq
        PQUnorderedBF<Integer> q = new PQUnorderedBF<>(5);
        List<Integer> list = ScannerUtil.readIntegers("src/algo1/princeton/pq/PQInput.txt");
        list.forEach(i -> {
            q.insert(i);
            System.out.println("Inserted " + i + ". Queue: " + q.toString());
        });
    }
}
