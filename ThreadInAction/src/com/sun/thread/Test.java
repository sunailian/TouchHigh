/**
 * 
 */
package com.sun.thread;

import java.util.UUID;

/**
 * @Package com.guozha.oms.web.controller.user
 * @Description: TODO
 * @author sunhanbin
 * @date 2016-1-22下午12:54:48
 */
public class Test {
	
	public static void main(String[] args){
		System.out.println(System.currentTimeMillis());
		System.out.println(System.currentTimeMillis()/1000);
		System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
	}

}
