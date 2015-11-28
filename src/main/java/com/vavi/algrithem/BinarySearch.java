package com.vavi.algrithem;

public class BinarySearch {
	public static int binarySearch(int arr[], int target) {
		if (null == arr || 0 == arr.length) { // 0.参数校验
			return -1;
		}

		int low = 0;
		int high = arr.length - 1;// 1.数组长度-1
		while (low <= high) {
			int mid = low + ((high - low) >> 1);// 2. 逻辑右移；3.避免high + low 溢出
			if (target > arr[mid]) { // 4.不要先判断= mid，减少分支预判
				low = mid + 1;
			} else if (target < arr[mid]) {
				high = mid - 1;
			} else {
				return mid;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 3 };
		int b[] = {};
		System.out.println(binarySearch(null, 4));
		System.out.println(binarySearch(b, 4));
		System.out.println(binarySearch(a, 4));
		System.out.println(binarySearch(a, 1));
		System.out.println(binarySearch(a, 2));
		System.out.println(binarySearch(a, 3));
		System.out.println(binarySearch(a, 0));
	}
}
