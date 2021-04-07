package redis;

import java.io.Serializable;
import java.util.Date;

public class UserEntity implements Serializable{
    private Long id;
    private String guid;
    private String name;
    private String age;
    private Date createTime;
}
