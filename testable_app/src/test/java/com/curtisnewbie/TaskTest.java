package com.curtisnewbie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TaskTest {

    @Test
    public void shouldVerifyAdmin() {
        assertTrue(Task.verifyAdmin("admin"));
        assertFalse(Task.verifyAdmin("yongjie"));
    }

    @Test
    public void shouldCalSum(){
        int[] nums = new int[]{1,3,5,7,9};
        assertEquals(Task.sum(nums), 1 + 3 + 5 + 7 + 9);
    }

    @Test
    public void shouldReturnAuthor(){
        assertNotNull(Task.author());
        assertEquals(Task.author(), "yongjie");
    }
}
