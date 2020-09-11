package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Forum {

   public static List<ForumUser> getUserList() {

       final List<ForumUser> forumUserList = new ArrayList<>();
       forumUserList.add(new ForumUser(1, "Adam", 'M', LocalDate.of(1987, Month.APRIL, 29),101));
       forumUserList.add(new ForumUser(2, "Ada", 'K', LocalDate.of(1993, Month.OCTOBER, 12),1));
       forumUserList.add(new ForumUser(3, "Adela", 'K', LocalDate.of(1942, Month.FEBRUARY, 22),10));
       forumUserList.add(new ForumUser(4, "Adrian", 'M', LocalDate.of(1999, Month.MARCH, 1),34));
       forumUserList.add(new ForumUser(5, "Adelajda", 'K', LocalDate.of(1987, Month.SEPTEMBER, 4),645));
       forumUserList.add(new ForumUser(6, "Alojzy", 'M', LocalDate.of(2001, Month.OCTOBER, 19),55));
       forumUserList.add(new ForumUser(7, "Andzelika", 'K', LocalDate.of(1998, Month.JANUARY, 19),85));
       forumUserList.add(new ForumUser(8, "Anastazja", 'K', LocalDate.of(2003, Month.JUNE, 13),43));
       forumUserList.add(new ForumUser(9, "Aleksander", 'M', LocalDate.of(2003, Month.JULY, 23),74));
       forumUserList.add(new ForumUser(10, "Adolf", 'M', LocalDate.of(1985, Month.MARCH, 31),0));
       return new ArrayList<>(forumUserList);
   }

}
