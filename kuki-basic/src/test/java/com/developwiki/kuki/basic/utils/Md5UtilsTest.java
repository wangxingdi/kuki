package com.developwiki.kuki.basic.utils;

import org.junit.Test;

import com.youyanpai.kuki.basic.util.Md5Utils;

/**
 * ������
 * @author wangxd
 */
public class Md5UtilsTest {

	@Test
	public void testEncodeByMD5(){
		Md5Utils.encodePassword("wangxd");
	}

}
