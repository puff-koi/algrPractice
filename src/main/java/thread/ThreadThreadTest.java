package thread;

public class ThreadThreadTest {
    public static void main(String[] args){
        ThreadThread tt1 = new ThreadThread("Thread A ");
        ThreadThread tt2 = new ThreadThread("Thread B ");
        tt1.start();
        tt2.start();

    }
}
