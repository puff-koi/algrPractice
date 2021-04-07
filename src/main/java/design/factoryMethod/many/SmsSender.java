package design.factoryMethod.many;

public class SmsSender implements Sender {
    public void Send() {
        System.out.println("Sms!");
    }
}
