package design;

public class BuilderUser {
    private String username;
    private String password;
    private Integer id;

    @Override
    public String toString() {
        return "BuilderUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }

    public BuilderUser(String username, String password, Integer id){
        this.username = username;
        this.password = password;
        this.id = id;
    }

    public static class UserBuilder{
        private String username;
        private String password;
        private Integer id;

        //设计技巧：返回值是该内部类对象为了调用时候实现链式编程
        public UserBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public BuilderUser build() {
            return new BuilderUser(this.username, this.password, this.id);
        }

    }
}
