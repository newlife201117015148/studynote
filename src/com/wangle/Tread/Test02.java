package com.wangle.Tread;

import javax.swing.JPanel;
/*
 * 哲学家用餐的问题:五个哲学家一人一根筷子，吃饭用两个筷子，一人借用下一个人的筷子
 */
public class Test02 {

	public static void main(String[] args) {
		new Thread(){
			@Override
			public void run() {
				Zxj.main(null);
			}
		}.start();
		Kuaizi k1 = new Kuaizi();
		Kuaizi k2 = new Kuaizi();
		Kuaizi k3 = new Kuaizi();
		Kuaizi k4 = new Kuaizi();
		Kuaizi k5 = new Kuaizi();

		Zhexuejia z1 = new Zhexuejia("张飞", k1, k2,Zxj.张飞);
		Zhexuejia z2 = new Zhexuejia("王朗", k2, k3,Zxj.王朗);
		Zhexuejia z3 = new Zhexuejia("刘备", k3, k4,Zxj.刘备);
		Zhexuejia z4 = new Zhexuejia("曹操", k4, k5,Zxj.曹操);
		Zhexuejia z5 = new Zhexuejia("关羽", k5, k1,Zxj.关羽);
		
		z1.start();
		z2.start();
		z3.start();
		z4.start();
		z5.start();
	}

}
