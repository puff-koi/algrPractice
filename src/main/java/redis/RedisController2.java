package redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("RedisStoreValueTest")
public class RedisController2 {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * set集合数据：存数据
     */
    @PostMapping("/setDataOfSet")
    public String setDataOfSet() {
        Set<String> set = new HashSet<String>();
        set.add("TestSetData1");
        set.add("TestSetData2");
        set.add("TestSetData3");

        //存入Set集合数据
        redisTemplate.opsForSet().add("setData", set);
        return "ok";
    }

    /**
     * set集合数据：取数据
     */
    @GetMapping("/getDataOfSet")
    public Set<Object> getDataOfSet() {
        //获取Set集合数据
        Set<Object> resultSet = redisTemplate.opsForSet().members("setData");
        return resultSet;
    }

    /**
     * Map集合数据操作：存数据
     */
    @PostMapping("/setDataOfMap")
    public String setDataOfMap() {
        Map<String, String> map1 = new HashMap<>();
        map1.put("key1", "map1-test1");
        map1.put("key2", "map1-test2");
        //方法一，这里使用字符串的格式存储，还可以设置过期时间为60秒
        redisTemplate.opsForValue().set("mapData_1", map1, 60, TimeUnit.SECONDS);

        Map<String, String> map2 = new HashMap<>();
        map2.put("key1", "map2-test1");
        map2.put("key2", "map2-test2");
        //方法二，以map形式存进去，这种情况过期时间默认调的是配置文件里面的
        redisTemplate.opsForHash().putAll("mapData_2", map2);
        return "ok";
    }

    /**
     * Map集合数据操作：取数据
     */
    @GetMapping("/getDataOfMap")
    public String getDataOfMap() {
        //方法一：对应上面存的方法一，把map数据（这里是String格式）取出来，赋予给Object，可以转换json对象
        Object mapData1 = redisTemplate.boundValueOps("mapData_1").get();
        String json = JSON.toJSONString(mapData1);

        //方法二：对应上面存的方法二，这里的取值就是操作map
        Map<Object, Object> mapData2 = redisTemplate.opsForHash().entries("mapData_2");
        Set<Object> resultMapSet = redisTemplate.opsForHash().keys("mapData_2");
        List<Object> resultMapList = redisTemplate.opsForHash().values("mapData_2");
        String value = (String) redisTemplate.opsForHash().get("mapData_2", "key1");
        System.out.println("mapData2:" + mapData2);
        System.out.println("通过Set集合方式取Key值resultMapSet:" + resultMapSet);
        System.out.println("通过List方式取Value值resultMapList:" + resultMapList);
        System.out.println("通过单一的key1去取对应的值value:" + value);
        return json;
    }

    /**
     * List集合数据操作：存数据
     */
    @PostMapping("/setDataOfList")
    public String setDataOflist() {
        List<String> list1=new ArrayList<>();
        list1.add("list1测试值a1");
        list1.add("list1测试值a2");
        list1.add("list1测试值a3");

        List<String> list2=new ArrayList<>();
        list2.add("list2测试值b1");
        list2.add("list2测试值b2");
        list2.add("list2测试值b3");

        /**
         * 从左往右入栈，存入列表（用作堆栈，先进后出）
         * lpush: 1 --> 2 --> 3
         * lrange 3 --> 2 --> 1
         */
        redisTemplate.opsForList().leftPush("listData1",list1);

        /**
         * 从右往左入从栈底入栈，存入列表（用作队列，先进先出）
         * rpush: 1 --> 2 --> 3
         * rrange 1 --> 2 --> 3
         */
        redisTemplate.opsForList().rightPush("listData2",list2);

        return "ok";
    }

    /**
     * List集合数据操作：取数据
     */
    @GetMapping("/getDataOfList")
    public Map<String,Object> getDataOfList() {
        //弹出最左边元素
        List<String> resultList1= (List<String>) redisTemplate.opsForList().leftPop("listData1");
        System.out.println(resultList1);
        //弹出最右边元素
        List<String> resultList2= (List<String>) redisTemplate.opsForList().rightPop("listData2");
        System.out.println(resultList2);
        Map<String,Object> map = new HashMap<>();
        map.put("listData1",resultList1);
        map.put("listData2",resultList2);
        return map;
    }


    /**
     * 普通key-value值操作
     */
    @GetMapping("setDataOfKeyValue")
    public String setDataOfKeyValue() {
        redisTemplate.opsForValue().set("key_value_1","value1");
        redisTemplate.opsForValue().set("key_value_2","value2");
        String result1=redisTemplate.opsForValue().get("key_value_1").toString();
        String result2=redisTemplate.opsForValue().get("key_value_2").toString();
        System.out.println("result："+result1+"  "+result2+"   ");
        return result1+result2;
    }

    /**
     * stringRedisTemplate对字符串值得存与取
     * @return
     */
    @GetMapping("stringRedisTemplate")
    public String stringRedisTemplate() {
        stringRedisTemplate.opsForValue().set("String","stringRedisTemplate");
        String result= stringRedisTemplate.opsForValue().get("String");
        return result;
    }

}
