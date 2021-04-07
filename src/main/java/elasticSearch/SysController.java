package elasticSearch;

import io.swagger.annotations.ApiOperation;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author: liziqiang
 * @description: SysController
 * @date: 2021/3/2 上午11:29
 */
@Controller
public class SysController {
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private UserRepository repository;

    @PostMapping("/createIndex")
    @ApiOperation("创建索引")
    public Boolean createIndex(@RequestParam String indexName){
        return  elasticsearchTemplate.createIndex(indexName);
    }

    @PostMapping("/createIndex")
    @ApiOperation("创建索引")
    public Boolean createIndex(){
        return  elasticsearchTemplate.createIndex(SysUser.class);
    }

    @PostMapping("/deleteIndex")
    @ApiOperation("删除索引")
    public Boolean deleteIndex(@RequestParam String indexName){
        // return elasticsearchTemplate.deleteIndex(SysUser.class);
        return  elasticsearchTemplate.deleteIndex(indexName);
    }

    /**
     * 模糊查找
     * @param userName
     * @return
     */
    @PostMapping("/fuzzyQuery")
    @ApiOperation("模糊查找根据分词去模糊，如果默认为5，输入4是没有办法模糊的")
    public Page<SysUser> fuzzyQuery(@RequestParam("username") String userName){
        NativeSearchQueryBuilder builder=new NativeSearchQueryBuilder();
        builder.withQuery(QueryBuilders.fuzzyQuery("username",userName));
        // 查找
        Page<SysUser> page = this.repository.search(builder.build());
        return page;
    }

    @PostMapping("/save")
    @ApiOperation("新增")
    public SysUser save(@RequestBody SysUser user){
        return repository.save(user);
    }

    @PostMapping("/saveAll")
    @ApiOperation("批量新增")
    public Iterable<SysUser> saveAll(@RequestBody List<SysUser> users){
        return  repository.saveAll(users);
    }

    @PostMapping("/findAllAndSort")
    @ApiOperation("查询全部并根据密码排序")
    public Iterable<SysUser> findAllAndSort(){
        return repository.findAll(Sort.by("password").ascending());
    }

    @PostMapping("/findAll")
    @ApiOperation("查询全部")
    public Iterable<SysUser> findAll(){
        return repository.findAll();
    }

    @PostMapping("/findByNickname")
    @ApiOperation("根据昵称查询用户")
    public List<SysUser> findByNickname(@RequestParam("nickname")String nickName){
        List<SysUser> list =  repository.findByNickname(nickName);
        return list;
    }

    @PostMapping("/findByNicknameOrPassword")
    @ApiOperation("根据昵称或者密码查询用户")
    public List<SysUser> findByNicknameOrPassword(@RequestParam("nickname")String nickName,@RequestParam("password")String Password){
        List<SysUser> list =  repository.findByNicknameOrPassword(nickName,Password);
        return list;
    }

    @PostMapping("/query")
    @ApiOperation("自定义查询")
    public Page<SysUser> query(@RequestParam("username")String userName){
        NativeSearchQueryBuilder builder=new NativeSearchQueryBuilder();
        builder.withQuery(QueryBuilders.matchQuery("username",userName));
        //如果实体和数据的名称对应就会自动封装，pageable分页参数
        Page<SysUser> items = this.repository.search(builder.build());
        long total = items.getTotalElements();
        System.out.println("查询数量为:"+total);
        return items;
    }

}
