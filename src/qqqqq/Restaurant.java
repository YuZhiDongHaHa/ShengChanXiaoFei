package qqqqq;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Restaurant {
	
	public static void main(String[] args) {
		Object obj =new Object();
		List<BaoZi> list =new ArrayList();
		Producer p1 =new Producer(list,obj);
		Customer c = new Customer(list,obj);
		p1.start();
		c.start();
	}
}
