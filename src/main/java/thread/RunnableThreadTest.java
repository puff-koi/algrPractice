package thread;

public class RunnableThreadTest {
    public static void main(String[] args){
        RunnableThread rt1 = new RunnableThread("Thread A ");
        RunnableThread rt2 = new RunnableThread("Thread B ");
        Thread t1 = new Thread(rt1);
        Thread t2 = new Thread(rt2);
        t1.start();
        t2.start();
    }
}
