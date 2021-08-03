package com.example.gloden.server;

import com.example.gloden.annotation.Default;
import com.example.gloden.annotation.Extend;
import com.example.gloden.model.Person;
import com.example.gloden.model.School;
import org.reflections.Reflections;

import java.io.InputStream;
import java.util.*;

/**
 * 创建一个Bean对象的工厂
 * Bean：在计算机英语中被定义为可重用组件
 * JavaBean: 用java语言编写的可重用组件，它就是创建我们的service和dao对象
 * javaBean > 实体类
 * 如何创建javaBean：
 * 第一步需要一个配置文件来配置我们的service和dao
 *      配置内容：唯一标识=全限定类名（key=value）
 * 第二步通过配置文件中配置的内容，反射创建对象
 * 配置文件可以是xml也可以是properties
 */
public class BeanFactory {
    //定义一个properties对象
    private static Properties properties;
    //定义一个容器
    private static Map<String,Object> beans;
    //使用静态代码块为Properties对象赋值 静态代码块只会随着类的加载仅加载一次
    static{
        //通过配置文件的方式来配置反射的全限定名
        try {
            //实例化properties对象
            properties=new Properties();
            //从properties中获取流对象
            InputStream inputStream = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            //读取流
            properties.load(inputStream);
            //实例化容器
            beans= new HashMap<>();
            //取出配置文件中的所有key
            Enumeration<Object> keys = properties.keys();
            //遍历枚举
            while (keys.hasMoreElements()){
                //取出每个key
                String key = keys.nextElement().toString();
                //根据key获取beanPath
                String beanPath = properties.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //将对象保存到beans容器中
                beans.put(key,value);
            }

            // Extend注解自动注入类
            // 要扫描的包
            String packageName = "com.example.gloden.model";
            Reflections f = new Reflections(packageName);
            // 获取扫描到的标记注解的集合
            Set<Class<?>> set = f.getTypesAnnotatedWith(Extend.class);
            for (Class<?> c : set) {
                // 循环获取标记的注解
                Extend annotation = c.getAnnotation(Extend.class);

            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失败!");
        }
    }

    public static void setBean(String key,String beanPath){
        if (beans.get(key)!=null){
            System.out.println(beanPath+"===已实例化！");
        }
        try {
            //反射创建对象
            Object value = Class.forName(beanPath).newInstance();
            //将对象保存到beans容器中
            beans.put(key,value);
        }catch (Exception e) {
            throw new ExceptionInInitializerError("自动注解类失败！");
        }
    }
    /**
     * 根据beans容器获取对象 获取到的都是同一个对象
     * @param beanName 配置的类对应的key
     * @return Object对象
     */
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }

    /**
     * 根据beans容器获取对象 使用类Class对象与配置类名key的方式
     * @param beanName 配置的类对应的key
     * @param <T> Class类
     * @return 转型后的实力对象
     */
    public static <T> T getBean(String beanName, Class<T> requiredType){
        Object bean =  beans.get(beanName);
        // Check if required type matches the type of the actual bean instance.
        if (requiredType != null && bean != null && !requiredType.isInstance(bean)) {
            System.out.println("error");
        }
        return (T) bean;
    }

    /**
     * 根据beans容器获取对象 使用类Class对象匹配方式
     * @param <T> Class类
     * @return 转型后的实力对象
     */
    public static <T> T getBean(Class<T> requiredType){
        Enumeration<Object> keys = properties.keys();
        //遍历枚举
        while (keys.hasMoreElements()){
            //取出每个key
            String key = keys.nextElement().toString();
            Object bean = beans.get(key);
            if (requiredType.isInstance(bean)){
                return (T) bean;
            }
        }
        return null;
    }

    public static int getBeanCount(){
        return beans.size();
    }

    public static void main(String[] args) {
//        System.out.println(BeanFactory.getBeanCount());
//        School school = new School();
//        school.test();
//        System.out.println(BeanFactory.getBeanCount());
//        Person person = (Person) BeanFactory.getBean("person");
//        //Person person1 = BeanFactory.getBean("person", Person.class);
//        //School person2 = BeanFactory.getBean(School.class);
//        System.out.println(BeanFactory.getBeanCount());

    }
}
