package design;

public class SingletonUltra {
    private SingletonUltra(){}
    //这里使用静态内部类，因为静态内部类只会在类被调用时候加载一次
    //后面就不会加载，所以可以保证线程是安全的
    // 而且也替代了锁机制，减少了资源浪费。
    private static class inner{
        private static final SingletonUltra singletonUltra = new SingletonUltra();
    }

    public static SingletonUltra getInstance(){
        return inner.singletonUltra;
    }

}
