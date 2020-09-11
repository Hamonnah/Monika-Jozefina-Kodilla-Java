package com.kodilla.testing.forum.statistics;

public class ForumStatistics {

    double avgPostPerUser;
    double avgCommentPerUser;
    double avgCommentPerPost;
    int usersCount;
    int postsCount;
    int commentsCount;

    public void calculateAdvStatistics(Statistics statistics) {
        avgPostPerUser = statistics.postsCount() / (double)statistics.usersNames().size();
        avgCommentPerUser = statistics.commentsCount() / (double)statistics.usersNames().size();
        avgCommentPerPost = statistics.commentsCount() / (double)statistics.postsCount();
        usersCount = statistics.usersNames().size();
        postsCount = statistics.postsCount();
        commentsCount = statistics.commentsCount();
    }

    public void showStatistics() {
        System.out.println("Average number of posts: " + avgPostPerUser);
        System.out.println("Average number of comments: " + avgCommentPerUser);
        System.out.println("Average number comments per post: " + avgCommentPerPost);
        System.out.println("Number of users: " + usersCount);
        System.out.println("Number of posts: " + postsCount);
        System.out.println("Number of comments: " + commentsCount);
    }

}
