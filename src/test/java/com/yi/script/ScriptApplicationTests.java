package com.yi.script;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScriptApplicationTests {

	@Test
	public int contextLoads() {
//		int[] arr = new int[]{3,6,4,8,8};
		int[] arr = new int[]{1,7,3,2,2};
		int ret = 0;

		for (int i = 0; i < arr.length; i++) {
			int num = arr[i];
			for (int j = 0; j < arr.length; j++) {
				num += arr[j];
				for (int k = 0; k < arr.length; k++) {
					num += arr[k];
					if (num / 10 != 0){
						System.out.println("可以整除");
						for (int n = 0; n < arr.length; n++) {
							if (n != i && n != j && n != k){
								ret += arr[n];
							}
						}
						return ret;
					}else {
						num = 0;
					}
				}
			}
		}

		return -1;
	}

	@Test
	public void sort() {
		Integer num = 1556034;
		String s = String.valueOf(num);
		String replace = s.replace("5", "89").replace("6", "94").replace("3", "7").
				replace("0", "24");

		Arrays.sort(replace.getBytes());

		System.out.println(replace);
	}
}
