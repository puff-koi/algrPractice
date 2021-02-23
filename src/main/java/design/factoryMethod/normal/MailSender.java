package design.factoryMethod.normal;

public class MailSender implements Sender {

    public void Send() {
        System.out.println("mail!");
    }
}
