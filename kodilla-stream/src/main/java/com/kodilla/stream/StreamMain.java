package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {

        Forum forum = new Forum();
        Map map = forum.getUserList().stream()
                .filter(forumUser -> forumUser.getSex() == 'M')
                .filter(forumUser -> {
                    Period period = Period.between(forumUser.getDateOfBirth(), LocalDate.now());
                    int ageOfUser = period.getYears();
                    return ageOfUser >= 20;})
                .filter(forumUser -> forumUser.getQuantityOfPublicatedPosts() >= 1)
                .collect(Collectors.toMap(ForumUser::getUniqId, ForumUser::getUserName));
                map.keySet().forEach(k -> System.out.println("uniq ID: " + k + ", user name: " + map.get(k)));
    }

}
