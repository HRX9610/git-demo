package com.gec.redis.junit;

import com.gec.redis.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TestRedis {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testSet(){
        stringRedisTemplate.boundValueOps("msg").set("this is springboot redis message.");
        System.out.println("保存完成");
    }

    @Test
    public void testGet(){
        String msg = stringRedisTemplate.boundValueOps("msg").get();
        System.out.println(msg);
    }

    //对象序列化
    @Test
    public void testSetObj(){
        //设置redis的序列化器
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        Person person = new Person();
        person.setAge(20);
        person.setName("Mike");
        redisTemplate.boundValueOps("person1").set(person);
        System.out.println("保存完成");
    }

    @Test
    public void testGetObj(){
        //设置redis的序列化器
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        Person person = (Person) redisTemplate.boundValueOps("person1").get();
        System.out.println(person.getName());
        System.out.println(person.getAge());
    }

    /*
    * Map
    *   key
    *     - list
    *         k1 list1
    *         k2 list2
    * */
    @Test
    public void testSetMap(){
        List<String> list1 = new ArrayList<>();
        list1.add("mike");
        list1.add("chen");
        list1.add("li");

        List<String> list2 = new ArrayList<>();
        list2.add("apple");
        list2.add("banana");
        list2.add("pear");

        redisTemplate.boundHashOps("list").put("names",list1);
        redisTemplate.boundHashOps("list").put("fruits",list2);

        System.out.println("保存完成");
    }

    @Test
    public void testGetMap(){

        List<String> list2 =  (List<String>) redisTemplate.boundHashOps("list").get("fruits");

        for (String fruit: list2) {
            System.out.println(fruit);
        }
    }
}




















