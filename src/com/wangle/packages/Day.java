package com.wangle.packages;
import java.lang.annotation.*;

//ע����൱�ڽӿڣ�ֻ���巽��������ʵ�������õ�ʱ��ʵ�ֵġ�


//@Target(ElementType.ANNOTATION_TYPE) ע�����д��ע����
//@Target(ElementType.CONSTRUCTOR)  ��������
//@Target(ElementType.FIELD)  ������
//@Target(ElementType.LOCAL_VARIABLE) ������
//@Target(ElementType.METHOD) ������
//@Target(ElementType.PACKAGE) ����
//@Target(ElementType.PARAMETER) ������
//@Target(ElementType.TYPE) ����
@Target(value={ElementType.TYPE,ElementType.ANNOTATION_TYPE,ElementType.FIELD,ElementType.CONSTRUCTOR,ElementType.LOCAL_VARIABLE,ElementType.METHOD,ElementType.PACKAGE})
//@Target({ElementType.ANNOTATION_TYPE,ElementType.FIELD}) Ҳ���Բ�дvalue
//@Retention(RetentionPolicy.CLASS) //�����б���
//@Retention(RetentionPolicy.RUNTIME)//����ʱ����
//@Retention(RetentionPolicy.SOURCE)//Դ���б���
@Retention(value=RetentionPolicy.CLASS) //Ĭ����RetentionPolicy.CLASS
public @interface Day {
	
}
