package design.factoryMethod.staticFactory;

public class SmsSender implements Sender {
    public void Send() {
        System.out.println("Sms!");
    }
}
