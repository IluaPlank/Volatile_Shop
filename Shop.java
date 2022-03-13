import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class Shop {
    AtomicLong money = new AtomicLong(0);
    private long sumShop;
    final int SIZE_MAS = 20;

    public synchronized void sumMoney() {
        System.out.println(Thread.currentThread().getName() + " считает деньги");
        ArrayList<Long> list = profit(SIZE_MAS);

        for (int i = 0; i < list.size(); i++) {
            sumShop += list.get(i);
        }
        System.out.println("выручка " + Thread.currentThread().getName() + "а составляет: " + sumShop);
        money.addAndGet(sumShop);
    }

    public long getCurrent() {
        return money.get();
    }

    public ArrayList<Long> profit(int size) {
        ArrayList<Long> money = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            money.add(i, (long) (1 + Math.random() * 500));
        }
        return money;
    }
}
