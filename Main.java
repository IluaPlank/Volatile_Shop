public class Main {


    public static void main(String[] args) throws InterruptedException {
        Shop shop = new Shop();
        Thread thread1 = new Thread(null, shop::sumMoney, "1 магазин");
        Thread thread2 = new Thread(null, shop::sumMoney, "2 магазин");
        Thread thread3 = new Thread(null, shop::sumMoney, "3 магазин");

        thread1.start();
        thread2.start();
        thread3.start();

        thread3.join();
        thread2.join();
        thread1.join();

        System.out.println("\nБаланс после всех переводов: " + shop.getCurrent());
    }
}
