package design.factoryMethod.normal;

import design.factoryMethod.normal.Sender;

public class SmsSender implements Sender {
    public void Send() {
        System.out.println("Sms!");
    }
}
