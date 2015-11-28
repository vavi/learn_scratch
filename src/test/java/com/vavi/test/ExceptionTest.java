package com.vavi.test;

import org.junit.Test;

public class ExceptionTest {
    @Test
    public void xxx() {
        System.out.println(Integer.MAX_VALUE);
Integer i = Integer.parseInt("2147484002");
//                            2,147,483,647
//	System.out.println(this.exception());
    }
    
    public int exception() {
	int x = 0;
	try {
	    x = 1;
	    return x;
	} catch (Exception e) {
	    x = 2;
	    return x;
	} finally {
	    x = 3;
	}
    }
}
