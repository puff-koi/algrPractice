package thread;

public class RunnableThread implements Runnable {
    private String name; //thread name
    public RunnableThread(){
    }

    public RunnableThread(String name){
        this.name = name;
    }
    //override run method
    public void run(){
        for (int i=0; i< 20; i++){
            System.out.println(name + "run, i = " + i);
        }
    }
}
