package design.factoryMethod.many;

public class MailSender implements Sender {

    public void Send() {
        System.out.println("mail!");
    }
}
