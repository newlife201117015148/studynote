package com.wangle.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
/**
 * 
   * @类 名： Test4
   * @功能描述： 反射应用中的容易出错的地方
   * @作者信息： wangle
   * @创建时间： 2019年5月8日下午5:37:59
   * @修改备注：
 */
public class Test4 {

	public static void main(String[] args) throws Exception {

		String a = (String) Test4.execute("com.wanngle.reflect.Test4", "method", new Object[]{3,2});
		System.out.println(a);
	}

	public String method(int a, int b) {
		return "method is called;parameter are "+a+" , "+b;
	}

//	//制作一个执行方法的方法
//	public static Object execute(String className, String methodName, Object[] args) throws Exception {
//		// 获取类的字节码文件对象
//		Class cls = Class.forName(className);
//		// 获取方法调用的参数的Class对象
//		Class[] paramsCls = new Class[args.length];
//		for (int i = 0; i < args.length; i++) {
//			paramsCls[i] = args[i].getClass();//如果是基本数据类型会自动生成其包装类，可能导致找不到方法
//		}
//		// 获取方法对象
//		Method method = cls.getDeclaredMethod(methodName, paramsCls);
//		Object obj = cls.newInstance();
//		return method.invoke(obj,args);
//	}
	   public static Object execute(String className, String methodName, Object args[]) throws Exception {
	        Class cls = Class.forName(className);
	        Method[] methods = cls.getMethods();
	        Object obj = cls.newInstance();
	        for (Method method : methods) {
	            // 获取方法所需要参数的Class对象数组
	            Class[] types = method.getParameterTypes();
	            
	            // 判断methodName是否和方法名一致，若一致，再判断传递的参数个数是否一致。参数个数一致后再判断参数类型是否一致
	            if (method.getName().equals(methodName) && args.length == types.length
	                    && isEqualParamAndTypes(args, types)) {
	                // 都一致 执行该方法
	                return method.invoke(obj, args);
	            }
	        }
	        System.out.println("没有这个方法或参数不匹配");
	        return null;
	    }
	/**
     * 判断参数数组的类型是否与方法所需要的参数类型是否一致
     * @param args 方法调用参数
     * @param types 方法所需要的参数类型
     * @return true代表一致，false不一致
     */
    private static boolean isEqualParamAndTypes(Object[] args, Class[] types) {
        boolean flag = false;
        for (int i = 0; i < args.length; i++) {
            String clsName = args[i].getClass().toString();
            String typeName = types[i].toString();
            // 上面获取参数的Class对象的字符串表示形式，是为了更好的去判断参数是否为基本数据类型。
            // 这里还需要去判断方法参数是否为基本数据类型。 如果是，那么照样是可以通过的
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
     * 判断字节码文件对象的字符串表示形式是否为基本数据类型的包装类型，若是，则返回基本数据类型的class对象的字符串表示形式
     * @param clsName 字节码文件(Class)对象的字符串表示形式
     * @return 若是包装类型，返回对应类型的基本数据类型的class对象表示形式，若不是，则返回该字符串本身
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
