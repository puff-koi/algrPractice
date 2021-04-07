package thread;

public class ThreadThread extends Thread{
    private String name;
    public ThreadThread(String name){
        this.name = name;
    }

    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println(name + "run, i = " + i);
        }
    }

}
