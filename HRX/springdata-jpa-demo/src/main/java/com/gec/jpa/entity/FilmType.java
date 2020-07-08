package com.gec.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="filmtype")
public class FilmType implements Serializable {

     private Integer id;
     private String name;
     private Set<FilmInfo> filmInfos = new HashSet<>(); //多方映射

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      public Integer getId() {
              return id;
      }


       public void setId(Integer id) {
           this.id = id;
       }


       public String getName() {
             return name;
       }


       public void setName(String name) {
            this.name = name;
      }

       // 相当于hibernate的<set lazy="" cascade="" inverse="true" />
       // 双向一对多，关系的维护方如果是一方，产生多余的update的语句
      @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy="filmType")
      public Set<FilmInfo> getFilmInfos() {
             return filmInfos;
      }


      public void setFilmInfos(Set<FilmInfo> filmInfos) {
          this.filmInfos = filmInfos;
       }
}
