package com.developwiki.kuki.basic.utils;

import org.junit.Test;

public class TestMd5Utils {

	@Test
	public void testEncodeByMD5(){
		Md5Utils.encodePassword("wangxd");
	}

}
