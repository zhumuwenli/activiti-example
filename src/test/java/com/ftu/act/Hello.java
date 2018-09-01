package com.ftu.act;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hello {
    private static final Logger logger = LoggerFactory.getLogger(Hello.class);
    
    @Test
    public void hello() {
        logger.debug("hello");
        
        System.out.println("hello");
    }
    
    
}
