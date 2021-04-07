package elasticSearch;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import java.io.Serializable;

/**
 * @author: liziqiang
 * @description: SysUser
 * @date: 2021/3/2 上午11:27
 */
@Data
@Document(indexName = "user_index",type = "user")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;

    @ApiModelProperty(value = "账号")
    @Field(type = FieldType.Keyword)
    private String username;

    @ApiModelProperty(value = "密码")
    @Field(type = FieldType.Keyword)
    private String password;


    @ApiModelProperty(value = "昵称")
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String nickname;

    @ApiModelProperty(value = "邮箱")
    @Field(type = FieldType.Keyword)
    private String email;

    @ApiModelProperty(value = "状态（0：锁定，1：解锁）")
    @Field(type = FieldType.Integer)
    private Integer status;

    @ApiModelProperty(value = "创建人")
    @Field(type = FieldType.Keyword)
    private String createUser;

    @ApiModelProperty(value = "更新人")
    @Field(type = FieldType.Keyword)
    private String updateUser;

    @ApiModelProperty(value = "年龄")
    @Field(type = FieldType.Double)
    private Double age;


}