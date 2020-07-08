package com.gec.jpa.junit;

import com.gec.jpa.dao.UserRepository;
import com.gec.jpa.entity.User;
import com.gec.jpa.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class TestUser {


      @Resource  //官方
      //@Autowired //spring
      private UserRepository userRepository;

      @Resource
      private UserService userService;

      @Test
      public void testQuery01() {
           List<User> list = userRepository.findAll();
           for (User user:list) {
             System.out.println(user);
           }
      }
      @Test
      public void testQuery02() {
           List<User> list = userRepository.findByUserNameLike("%n%");
           for (User user: list ) {
                   System.out.println(user);
               }
      }

       @Test
       public void testQuery03(){
           int pageNum = 0; //页码从零开始
            int pageSize = 3;
            Page<User> page = userService.findByPage(pageNum,pageSize);
            List<User> list = page.getContent();
            for (User user: list) {
                  System.out.println(user);
            }
            System.out.println(page.getNumber());
            System.out.println(page.getTotalPages());
            System.out.println(page.getTotalElements());
        }

        @Test
        @Transactional
        @Rollback(value = false) //在springboot的单元测试中默认是回滚。
        public void testAdd() {
              User user = new User("Alex","888888",new Date(),2);
              userRepository.save(user);
        }
}
