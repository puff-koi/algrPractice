package thread;

public class JoinThreadTest {
    public static void main(String args[]){
        RunnableThread rt1 = new RunnableThread("RT1 Join ");
        Thread t = new Thread(rt1);
        t.start();
        for (int i = 0; i < 20; i++) {
            if (i>10){
                try {
                    t.join();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println("main" + i);
        }
    }
}
