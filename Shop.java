import java.util.ArrayList;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

public class Shop {
    LongAdder money = new LongAdder();
    final int SIZE_MAS = 20;

    public synchronized void sumMoney() {
        System.out.println(Thread.currentThread().getName() + " считает деньги");
        ArrayList<Long> list = profit(SIZE_MAS);
        IntStream.range(0, list.size()).forEach(i -> money.add(list.get(i)));
    }

    public long getCurrent() {
        return money.sum();
    }

    public ArrayList<Long> profit(int size) {
        ArrayList<Long> money = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            money.add(i, (long) (1 + Math.random() * 500));
        }
        return money;
    }
}
