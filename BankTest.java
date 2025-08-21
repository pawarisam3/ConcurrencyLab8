import java.util.ArrayList;

public class BankTest {
    public static void main(String[] args) {
        BankAccount a = new BankAccount();
        ArrayList<Thread> t = new ArrayList<>();
        int NUM_DEPOSITOR = 3;
        int NUM_WITHDRAWER = 0;
        int VALUE = 100;
        int ROUND = 10000;
        //สร้างคนฝาก
        for(int i =0 ; i<NUM_DEPOSITOR;i++){
            Thread x =new Thread(new Depositor(a, VALUE, ROUND));
            t.add(x);
        }
        for(int i = 0 ; i<NUM_WITHDRAWER ; i++){
            Thread x = new Thread(new Withdrawer(a, VALUE, ROUND));
            t.add(x);
        }
        //สั่งทำงาน
        for(Thread thread: t){
            thread.start();
        }
        //ทำงานจนเสร็จ
        try {
            for(Thread thread : t){
                thread.join();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Excected value : "+((NUM_DEPOSITOR*VALUE*ROUND)-(NUM_WITHDRAWER*VALUE*ROUND)));
        System.out.println("Real value : "+a.getBalance());
    }
}
