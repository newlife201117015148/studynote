package com.wangle.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
/**
 * 
   * @�� ���� Test4
   * @���������� ����Ӧ���е����׳���ĵط�
   * @������Ϣ�� wangle
   * @����ʱ�䣺 2019��5��8������5:37:59
   * @�޸ı�ע��
 */
public class Test4 {

	public static void main(String[] args) throws Exception {

		String a = (String) Test4.execute("com.wanngle.reflect.Test4", "method", new Object[]{3,2});
		System.out.println(a);
	}

	public String method(int a, int b) {
		return "method is called;parameter are "+a+" , "+b;
	}

//	//����һ��ִ�з����ķ���
//	public static Object execute(String className, String methodName, Object[] args) throws Exception {
//		// ��ȡ����ֽ����ļ�����
//		Class cls = Class.forName(className);
//		// ��ȡ�������õĲ�����Class����
//		Class[] paramsCls = new Class[args.length];
//		for (int i = 0; i < args.length; i++) {
//			paramsCls[i] = args[i].getClass();//����ǻ����������ͻ��Զ��������װ�࣬���ܵ����Ҳ�������
//		}
//		// ��ȡ��������
//		Method method = cls.getDeclaredMethod(methodName, paramsCls);
//		Object obj = cls.newInstance();
//		return method.invoke(obj,args);
//	}
	   public static Object execute(String className, String methodName, Object args[]) throws Exception {
	        Class cls = Class.forName(className);
	        Method[] methods = cls.getMethods();
	        Object obj = cls.newInstance();
	        for (Method method : methods) {
	            // ��ȡ��������Ҫ������Class��������
	            Class[] types = method.getParameterTypes();
	            
	            // �ж�methodName�Ƿ�ͷ�����һ�£���һ�£����жϴ��ݵĲ��������Ƿ�һ�¡���������һ�º����жϲ��������Ƿ�һ��
	            if (method.getName().equals(methodName) && args.length == types.length
	                    && isEqualParamAndTypes(args, types)) {
	                // ��һ�� ִ�и÷���
	                return method.invoke(obj, args);
	            }
	        }
	        System.out.println("û����������������ƥ��");
	        return null;
	    }
	/**
     * �жϲ�������������Ƿ��뷽������Ҫ�Ĳ��������Ƿ�һ��
     * @param args �������ò���
     * @param types ��������Ҫ�Ĳ�������
     * @return true����һ�£�false��һ��
     */
    private static boolean isEqualParamAndTypes(Object[] args, Class[] types) {
        boolean flag = false;
        for (int i = 0; i < args.length; i++) {
            String clsName = args[i].getClass().toString();
            String typeName = types[i].toString();
            // �����ȡ������Class������ַ�����ʾ��ʽ����Ϊ�˸��õ�ȥ�жϲ����Ƿ�Ϊ�����������͡�
            // ���ﻹ��Ҫȥ�жϷ��������Ƿ�Ϊ�����������͡� ����ǣ���ô�����ǿ���ͨ����
            if (clsName.equals(typeName) || isBasicType(clsName).equals(typeName)) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }
    
    /**
     * �ж��ֽ����ļ�������ַ�����ʾ��ʽ�Ƿ�Ϊ�����������͵İ�װ���ͣ����ǣ��򷵻ػ����������͵�class������ַ�����ʾ��ʽ
     * @param clsName �ֽ����ļ�(Class)������ַ�����ʾ��ʽ
     * @return ���ǰ�װ���ͣ����ض�Ӧ���͵Ļ����������͵�class�����ʾ��ʽ�������ǣ��򷵻ظ��ַ�������
     */
    private static String isBasicType(String clsName) {
        switch (clsName) {
        case "class java.lang.Byte":
            return "byte";
        case "class java.lang.Short":
            return "short";
        case "class java.lang.Integer":
            return "int";
        case "class java.lang.Long":
            return "long";
        case "class java.lang.Float":
            return "float";
        case "class java.lang.Double":
            return "double";
        case "class java.lang.Character":
            return "char";
        case "class java.lang.Boolean":
            return "boolean";
        default:
            return clsName;
        }
    }
}
