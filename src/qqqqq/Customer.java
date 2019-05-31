package qqqqq;

import java.util.List;

//消费者
public class Customer extends Thread {
	private List<BaoZi> list;
	 private Object obj;
	
	
	public Customer(List<BaoZi> arr,Object obj) {
		this.list = arr;
		this.obj = obj;
	}


	@Override
	public void run() {
		while(true) {

			synchronized (obj) {
				if(list.size()>=1) {
					list.remove(0);
					System.out.println("包子被吃掉");
				}else {
					System.out.println("老板出来做包子");
					try {
						obj.notify();
						obj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
