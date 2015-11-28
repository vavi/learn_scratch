package com.vavi.annatation;

public class User {

	@RequestMapping("name")
	public String add(String name) {
		return "add";
	}
}
