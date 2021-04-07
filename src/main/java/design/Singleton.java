package design;

public class Singleton {
    //饿汉式
    private Singleton(){}
    //内部创建对象
    private final static  Singleton singleton = new Singleton();
    //外部获取方法
    public static Singleton getInstance(){
        return singleton;
    }
}
