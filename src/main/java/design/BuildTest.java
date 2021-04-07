package design;

public class BuildTest {
    public static void main(String[] args){
        BuilderUser user = new BuilderUser.UserBuilder().password("sss").username("sss").id(123).build();
        System.out.println(user);
    }
}
