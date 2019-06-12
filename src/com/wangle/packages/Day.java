package com.wangle.packages;
import java.lang.annotation.*;

//注解就相当于接口，只定义方法，具体实现是在用的时候实现的。


//@Target(ElementType.ANNOTATION_TYPE) 注解可以写在注解上
//@Target(ElementType.CONSTRUCTOR)  构造器上
//@Target(ElementType.FIELD)  属性上
//@Target(ElementType.LOCAL_VARIABLE) 变量上
//@Target(ElementType.METHOD) 方法上
//@Target(ElementType.PACKAGE) 包上
//@Target(ElementType.PARAMETER) 参数上
//@Target(ElementType.TYPE) 类上
@Target(value={ElementType.TYPE,ElementType.ANNOTATION_TYPE,ElementType.FIELD,ElementType.CONSTRUCTOR,ElementType.LOCAL_VARIABLE,ElementType.METHOD,ElementType.PACKAGE})
//@Target({ElementType.ANNOTATION_TYPE,ElementType.FIELD}) 也可以不写value
//@Retention(RetentionPolicy.CLASS) //在类中保留
//@Retention(RetentionPolicy.RUNTIME)//运行时保留
//@Retention(RetentionPolicy.SOURCE)//源码中保留
@Retention(value=RetentionPolicy.CLASS) //默认是RetentionPolicy.CLASS
public @interface Day {
	
}
