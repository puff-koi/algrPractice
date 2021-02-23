package design.factoryMethod.staticFactory;

public class FactoryTest {
    public static void main(String[] args){
        Sender sender = SendFactory.produceMail();
        sender.Send();
    }
}
