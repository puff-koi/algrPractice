package design.factoryMethod.staticFactory;

public class MailSender implements Sender {

    public void Send() {
        System.out.println("mail!");
    }
}
