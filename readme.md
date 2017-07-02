# Spring项目 + Maven多模块实战

## 参考
1. [Spring+Spring MVC+Mybatis+Maven搭建多模块项目(一)](http://blog.csdn.net/kity9420/article/details/53292084)
2. [Spring+Spring MVC+Mybatis+Maven搭建多模块项目(二)](http://blog.csdn.net/kity9420/article/details/53314037)
3. [Maven多模块布局实例详解](https://my.oschina.net/ydsakyclguozi/blog/412156)


## 搭建MAVEN多模块开发环境
1. 创建父项目

Eclipse创建普通maven项目，然后修改该项目下的pom.xml文件的打包类型为pom，修改后的内容如下所示：

    <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
        <modelVersion>4.0.0</modelVersion>
    
        <groupId>com.xiao</groupId>
        <artifactId>root</artifactId>
        <version>0.0.1-SNAPSHOT</version>
        <packaging>pom</packaging>
    
        <name>root</name>
        <url>http://maven.apache.org</url>
    
        <dependencies>
        </dependencies>
    
        <build>
            <finalName>bug.root</finalName>
            <plugins>
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-compiler-plugin</artifactId>
                    <version>2.3.2</version>
                    <configuration>
                        <source>1.7</source>
                        <target>1.7</target>
                    </configuration>
                </plugin>
            </plugins>
        </build>
    </project>


2. 创建model子模块

Eclipse依据向导创建maven module，父项目选择步骤1生成的root项目，其他配置如步骤1，生成后的model模块的pom.xml内容如下：

    <?xml version="1.0"?>
    <project
        xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd"
        xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
        <modelVersion>4.0.0</modelVersion>
        <parent>
            <groupId>com.xiao</groupId>
            <artifactId>root</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </parent>
        <artifactId>model</artifactId>
        <name>model</name>
        <url>http://maven.apache.org</url>
        <properties>
            <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        </properties>
        <dependencies>
    
        </dependencies>
    </project>

3. 采用相同的方式，依次创建dao，service模块。

4. 创建web模块

Eclipse依据向导创建maven web模块，其他步骤跟其他子模块的配置类似；


4. 最终父项目的pom.xml自动添加model的内容，内容变为如下所示：
    
    <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
        <modelVersion>4.0.0</modelVersion>
    
        <groupId>com.xiao</groupId>
        <artifactId>root</artifactId>
        <version>0.0.1-SNAPSHOT</version>
        <packaging>pom</packaging>
    
        <name>root</name>
        <url>http://maven.apache.org</url>
        <modules>
            <module>model</module>
            <module>service</module>
            <module>common</module>
            <module>dao</module>
            <module>web</module>
        </modules>
    
        <dependencies>
        </dependencies>
    
        <build>
            <finalName>bug.root</finalName>
            <plugins>
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-compiler-plugin</artifactId>
                    <version>2.3.2</version>
                    <configuration>
                        <source>1.7</source>
                        <target>1.7</target>
                    </configuration>
                </plugin>
            </plugins>
        </build>
    </project>


参考：
1. [MAVEN多项目管理小结](http://blog.csdn.net/whuslei/article/details/7989102)
2. [.....]()

## 搭建Spring Java版本的Hello World

1. 父项目中引入Spring需要的依赖，如下所示：

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <spring.version>4.0.6.RELEASE</spring.version>
        <mybatis.version>3.2.7</mybatis.version>
        <mysql.version>5.1.29</mysql.version>
        <shiro.version>1.3.2</shiro.version>
    </properties>
    <dependencies>
        <!-- Spring包 -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context-support</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-tx</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aspects</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <!-- mybatis驱动包 -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>${mybatis.version}</version>
        </dependency>
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>1.2.2</version>
        </dependency>
        <!-- mysql驱动包 -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>${mysql.version}</version>
        </dependency>
        <!-- dbcp数据源 -->
        <dependency>
            <groupId>commons-dbcp</groupId>
            <artifactId>commons-dbcp</artifactId>
            <version>1.4</version>
        </dependency>
        <dependency>
            <groupId>commons-pool</groupId>
            <artifactId>commons-pool</artifactId>
            <version>1.6</version>
        </dependency>
        <dependency>
            <groupId>commons-collections</groupId>
            <artifactId>commons-collections</artifactId>
            <version>3.2.1</version>
        </dependency>
        <!-- junit测试包 -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.11</version>
            <scope>test</scope>
        </dependency>
        <!-- https://mvnrepository.com/artifact/com.alibaba/fastjson -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <version>1.2.8</version>
        </dependency>
        <!-- log4j日志包 -->
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.14</version>
        </dependency>
        <dependency>
            <groupId>org.apache.shiro</groupId>
            <artifactId>shiro-core</artifactId>
            <version>${shiro.version}</version>
        </dependency>
        <dependency>
            <groupId>org.apache.shiro</groupId>
            <artifactId>shiro-web</artifactId>
            <version>${shiro.version}</version>
        </dependency>
        <dependency>
            <groupId>org.apache.shiro</groupId>
            <artifactId>shiro-spring</artifactId>
            <version>${shiro.version}</version>
        </dependency>
        <dependency>
            <groupId>org.apache.shiro</groupId>
            <artifactId>shiro-ehcache</artifactId>
            <version>${shiro.version}</version>
        </dependency>
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>3.0.1</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>javax.servlet.jsp</groupId>
            <artifactId>jsp-api</artifactId>
            <version>2.1</version>
            <scope>provided</scope>
        </dependency>
        <!-- jstl 标签库 -->
        <dependency>
            <groupId>jstl</groupId>
            <artifactId>jstl</artifactId>
            <version>1.2</version>
        </dependency>
        <dependency>
            <groupId>taglibs</groupId>
            <artifactId>standard</artifactId>
            <version>1.1.2</version>
        </dependency>
    </dependencies>



创建Person.java的实体类

    public class Person {
        public String name;
        public String age;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getAge() {
            return age;
        }
        public void setAge(String age) {
            this.age = age;
        }
    }

编写applicationContext.xml

    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context"
        xmlns:util="http://www.springframework.org/schema/util"
        xsi:schemaLocation="http://www.springframework.org/schema/beans     
        http://www.springframework.org/schema/beans/spring-beans-2.5.xsd
        http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.0.xsd
        http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util-2.5.xsd">
        <bean id="person" class="com.xiao.entity.Person">
            <property name="name" value="zhangsan"></property>
            <property name="age" value="12"></property>
        </bean>
    </beans>

添加test类，并执行main方法

    public class Test {
    public static void main(String[] args) {
        BeanFactory bf = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person p = (Person) bf.getBean("person");
        System.out.println(p.getName());
    }
    }


#web版的hello world
1. 修改pom.xml，添加如下的dependency



2. web.xml
    
        <?xml version="1.0" encoding="UTF-8"?>
        <web-app version="2.4" xmlns="http://java.sun.com/xml/ns/j2ee"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee 
        http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd">
        
        <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
        </listener>
        
        <servlet>
        <servlet-name>exam</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        </servlet>
        
        <servlet-mapping>
        <servlet-name>exam</servlet-name>
        <url-pattern>/</url-pattern>
        </servlet-mapping>
        
        <welcome-file-list>
        <welcome-file>index.jsp</welcome-file>
        </welcome-file-list>
        </web-app>


3. 


## 集成logback

## 集成Druid

## 集成Mybatis
[mybatis-generator 代码自动生成工具（maven方式）](http://www.cnblogs.com/JsonShare/p/5521901.html)

## 缓存


## 添加Shiro功能
[SpringMVC整合Shiro权限框架](http://blog.csdn.net/donggua3694857/article/details/52157313)




完整的项目代码请参考[https://github.com/zhaoleoboy/spring_maven](https://github.com/zhaoleoboy/spring_maven)
