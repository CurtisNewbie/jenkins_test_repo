package com.curtisnewbie;

public class Task {

    public static boolean verifyAdmin(String username) {
        return username.equalsIgnoreCase("admin");
    }

    public static int sum(int[] nums) {
        int sum = 0;
        // TODO: intended
//        for (int n : nums)
//            sum += n;
        return sum;
    }

    public static String author(){
        return "yongjie";
    }
}
