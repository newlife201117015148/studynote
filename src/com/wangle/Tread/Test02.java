package com.wangle.Tread;

import javax.swing.JPanel;
/*
 * ��ѧ���ò͵�����:�����ѧ��һ��һ�����ӣ��Է����������ӣ�һ�˽�����һ���˵Ŀ���
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

		Zhexuejia z1 = new Zhexuejia("�ŷ�", k1, k2,Zxj.�ŷ�);
		Zhexuejia z2 = new Zhexuejia("����", k2, k3,Zxj.����);
		Zhexuejia z3 = new Zhexuejia("����", k3, k4,Zxj.����);
		Zhexuejia z4 = new Zhexuejia("�ܲ�", k4, k5,Zxj.�ܲ�);
		Zhexuejia z5 = new Zhexuejia("����", k5, k1,Zxj.����);
		
		z1.start();
		z2.start();
		z3.start();
		z4.start();
		z5.start();
	}

}
