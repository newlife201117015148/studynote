package com.wangle;
/**
 * 
   * @�� ���� Test7
   * @���������� ���ж�̬�ľ����������
   * @������Ϣ�� wangle
   * @����ʱ�䣺 2019��4��2������11:56:02
   * @�޸ı�ע��
 */
public class Test7 {
//    ������������������ԣ���װ���̳С���̬��
//
//    ��װ����������ڲ�ʵ�ֻ��ƣ������ڲ�Ӱ��ʹ�õ�����¸ı�����ڲ��ṹ��ͬʱҲ���������ݡ��������������ڲ�ϸ�������صģ�
//    ��¶������ֻ�����ķ��ʷ�����
//
//    �̳���Ϊ�����ø�����롣������������IS-A�Ĺ�ϵ�Ϳ���ʹ�ü̳С���ͬʱ�̳�ҲΪʵ�ֶ�̬�����̵档
//
//    ��ν��̬����ָ�����ж�������ñ�����ָ��ľ������ͺ�ͨ�������ñ��������ķ��������ڱ��ʱ����ȷ���������ڳ��������ڼ��ȷ����
//    ��һ�����ñ������׻�ָ���ĸ����ʵ�����󣬸����ñ��������ķ������õ������ĸ�����ʵ�ֵķ������������ɳ��������ڼ���ܾ�����
//    ��Ϊ�ڳ�������ʱ��ȷ��������࣬�����������޸�Դ������룬�Ϳ��������ñ����󶨵����ֲ�ͬ����ʵ���ϣ��Ӷ����¸����õ��õľ��巽����֮�ı䣬
//    �����޸ĳ������Ϳ��Ըı��������ʱ���󶨵ľ�����룬�ó������ѡ��������״̬������Ƕ�̬�ԡ�
	
	
//	    ָ������ĸ���������������ת���ˣ���ֻ�ܷ��ʸ�����ӵ�еķ��������ԣ������������д��ڶ������в����ڵķ������������ǲ���ʹ�õģ�
//	    ���������ظ÷�������������д�˸����е�ĳЩ�������ڵ��ø�Щ������ʱ�򣬱ض���ʹ�������ж������Щ��������̬���ӡ���̬���ã���
//
//    �������������ѣ���̬��Ϊ����ʱ��̬������ʱ��̬�����б���ʱ��̬�Ǿ�̬�ģ���Ҫ��ָ���������أ����Ǹ��ݲ����б�Ĳ�ͬ�����ֲ�ͬ�ĺ�����
//    ͨ���༭֮�����������ͬ�ĺ�����������ʱ̸���϶�̬��������ʱ��̬�Ƕ�̬�ģ�����ͨ����̬����ʵ�ֵģ�Ҳ����������˵�Ķ�̬��
	
//	��̬��ʵ�ֻ�����ѭһ��ԭ�򣺵�����������ñ��������������ʱ�������ö�������Ͷ��������ñ��������;����˵���˭�ĳ�Ա������
//	������������õķ����������ڳ����ж�����ģ�Ҳ����˵�����า�ǵķ�����
	
//	     ��Java����������ʽ����ʵ�ֶ�̬���̳кͽӿڡ�
	
//	��ʵ�ڼ̳����ж��󷽷��ĵ��ô���һ�����ȼ���this.show(O)��super.show(O)��this.show((super)O)��super.show((super)O)��
//	this����������ñ�����super����������ñ����ĸ��ࡣ(super)O��ָO�ĸ��ࡣ
	public class A {
		    public String show(D obj) {
		        return ("A and D");
		    }

		    public String show(A obj) {
		        return ("A and A");
		    } 
		    
		    public String show(C obj){
				return ("A and C");
			}
		}

		public class B extends A{
		    public String show(B obj){
		        return ("B and B");
		    }
		    
		    public String show(A obj){
		        return ("B and A");
		    } 
		}

		public class C extends B{
			public String show(B obj){
				return ("C and B");
			}
			
			public String show(C obj){
				return ("C and C");
			}
		}

		public class D extends B{

		}

		    public static void main(String[] args) {
		    	Test7 t = new Test7();
		        A a1 = t.new A();
		        A a2 = t.new B();
		        B b = t.new B();
		        C c = t.new C();
		        B c1 = t.new C();
		        D d = t.new D();
		        B d1 = t.new D();
		        //���ñ������ͺ����ö������Ͷ���A��
		        System.out.println("1--" + a1.show(b));//this.show(obj)��A����show(B b)û��-->super.show(obj);A������û��show(B b)-->this.show((super)O),(super)OΪA�࣬����show(A a);
		        System.out.println("2--" + a1.show(c));//A����show(C c)û��-->C�ĸ���B��show(B b)û��-->B�ĸ���A��show(A a);
		        System.out.println("3--" + a1.show(d));//A����show(D d);
		        //���ñ���������A�࣬���ö���������B��
		        System.out.println("4--" + a2.show(b));//this.show(obj);A����show(B b)û��-->super.show(obj);A������û��show(B b)-->this.show((super)O),(super)OΪA��;A����show(A a);���ֱ�������д�����Ե���B���е�show(A a);
		        System.out.println("5--" + a2.show(c));//this.show(obj);A����show(B b)û��-->super.show(obj);A������û��show(B b)-->this.show((super)O),(super)OΪB�ࡢA��;A����show(A a);���ֱ�������д�����Ե���B���е�show(A a);
		        System.out.println("6--" + a2.show(d));//this.show(obj);A����show(D d);
		        //���ñ���������B�࣬���ö���������B��
		        System.out.println("7--" + b.show(b));//B���У�show(B b)
		        System.out.println("8--" + b.show(c));//B���У�show(C c)û��-->super.show(obj);A��.show(C c)û��-->this.show((super)O),B��.show(B b);
		        System.out.println("9--" + b.show(d));//B���У�show(D d)û��-->super.show(obj);A��.show(D d);
		        
		        System.out.println("10--"+ c.show(a1));
		        System.out.println("11--"+ c1.show(c));
		        System.out.println("12--"+ d1.show(c));
		        
		        String aa= "abcd";
		        String bb = "ab";
		        String cc = bb + "cd";
		        String dd = "ab" + "cd";
		        System.out.println(aa==cc);
		        System.out.println(aa==dd);
		        System.out.println(cc==dd);
		    
		    }
		    //�ܽ᣺��� ���ࣨ�ӿڣ�   p = new ����();��ΪA���ͣ���  L = new ��();��ΪB���ͣ������������Ͷ�����ѭ��
		    //this.show(O)��super(...һֱ������).show(O)��this.show((super(...һֱ������))O)��super(...һֱ������).show((super(...һֱ������))O)���򣬵���A����ʱ��
		    //���ͨ�������жϳ����õ��ǳ���ķ�����ͬʱ�÷��������ö�����������д�ˣ���ô���յ��õ������ö��������еķ���������÷���û�б����ö���������д�������Ǳ��̳�ͬһ�������������д�ˣ�
		    //���ջ��ǵ��ó����еķ�����
	
}
