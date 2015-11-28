package com.vavi.classloader;

public class ClassInitSeq {
	static int a = 0; // 1)如果不赋值呢？ 2)如果这一句与上一句位置互换？
	static {
		a = 1;
	}

	public static void main(String[] args) {
		System.out.println(ClassInitSeq.a);

		while (true) {

		}
	}
}
