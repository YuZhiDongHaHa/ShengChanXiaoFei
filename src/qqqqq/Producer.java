package qqqqq;

import java.math.BigDecimal;
import java.util.List;

public class Producer extends Thread {

	private List<BaoZi> list;
	private Object obj;
	BaoZi baozi1 = new BaoZi("牛肉", new BigDecimal(1.5));
	BaoZi baozi2 = new BaoZi("猪肉", new BigDecimal(2));
	BaoZi baozi3 = new BaoZi("大葱", new BigDecimal(1));

	public Producer(List<BaoZi> arr,Object obj) {
		this.list = arr;
		this.obj = obj;
	}

	@Override
	public void run() {
		while (true) {

			synchronized (obj) {
				if (list.size() < 3) {
					list.add(baozi1);
					System.out.println("包子已做好");
				} else {
					System.out.println("仓库满了，过来吃");
					try {
						obj.notify();
						obj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					};
				}
			}
		}
	}
}
