package com.gec.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity  //当前实体是一个可持久化的类
@Table(name = "t_user")  //orm映射的表
public class User implements Serializable {
     @Id  //对象的唯一标识
     @GeneratedValue(strategy = GenerationType.IDENTITY)  //自增产生id
     private Integer id;
     @Column(name = "user_name",length = 20)
     private String userName;
     @Column(name = "password",length = 20)
     private String password;
     @Column(name = "last_login_time")
     private Date lastLoginTime;
     @Column(name = "sex")
     private Integer sex;

      public User() {
      }
      public User(String userName,String password,Date lastLoginTime,Integer sex) {
               this.userName=userName;
               this.password=password;
               this.lastLoginTime=lastLoginTime;
               this.sex=sex;
      }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getUserName() {
                return userName;
        }

        public void setUserName(String userName) {
                this.userName = userName;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public Date getLastLoginTime() {
                return lastLoginTime;
        }

        public void setLastLoginTime(Date lastLoginTime) {
                this.lastLoginTime = lastLoginTime;
        }

        public Integer getSex() {
                return sex;
        }

        public void setSex(Integer sex) {
                this.sex = sex;
        }

        @Override
        public String toString() {
                return "User{" +
                        "id=" + id +
                        ", userName='" + userName + '\'' +
                        ", password='" + password + '\'' +
                        ", lastLoginTime=" + lastLoginTime +
                        ", sex=" + sex +
                        '}';
        }
}
