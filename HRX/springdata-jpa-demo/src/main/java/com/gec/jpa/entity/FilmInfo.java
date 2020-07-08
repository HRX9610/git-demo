package com.gec.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="filminfo")
public class FilmInfo implements Serializable {


     private Integer id;
     private String filmName;
     private String actor;
     private String director;
     private Double ticketprice;


     private FilmType filmType;   //一方的映射


     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     public Integer getId() {
               return id;
      }

     public void setId(Integer id) {
           this.id = id;
     }

      public String getFilmName() {
          return filmName;
      }


       public void setFilmName(String filmName) {
           this.filmName = filmName;
       }


       public String getActor() {
            return actor;
       }


       public void setActor(String actor) {
           this.actor = actor;
       }


       public String getDirector() {
           return director;
        }


       public void setDirector(String director) {
            this.director = director;
       }


       public Double getTicketprice() {
           return ticketprice;
      }


      public void setTicketprice(Double ticketprice) {
          this.ticketprice = ticketprice;
      }


       @ManyToOne
       @JoinColumn(name = "type_id") //filminfo表的外键列的名称
       public FilmType getFilmType() {
            return filmType;
        }


       public void setFilmType(FilmType filmType) {
           this.filmType = filmType;
        }
}
