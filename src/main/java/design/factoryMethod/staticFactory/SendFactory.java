package design.factoryMethod.staticFactory;

public class SendFactory {
    //大多数情况下，我们会选用第三种——静态工厂方法模式。
    public static Sender produceMail(){
        return new MailSender();
    }

    public static Sender produceSma(){
        return new SmsSender();
    }
}
