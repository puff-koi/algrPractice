package design;

public class SingletonLazy {
    //懒汉
    private SingletonLazy(){}
    //创建对象不实例化
    private static SingletonLazy singletonLazy = null;
    //外部获取对象方法
    public synchronized static SingletonLazy getInstance(){
        if (singletonLazy == null){
            singletonLazy = new SingletonLazy();
        }
        return singletonLazy;
    }

}
