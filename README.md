### maven
 - maven 测试打包：mvn clean package -Ptest（默认打包）
 - maven 生产打包：mvn clean package -Pprod  
 
### 项目目录
  开发环境启动是**src/test/java/../ApplicationDev.java**    
  
	├─bin -
	│      package_prod.bat -> maven 生产打包
	│      package_prod.sh  
	│      package_test.bat -> maven 测试打包
	│      package_test.sh
	│      
	├─src
	│  ├─main
	│  │  ├─assembly 
	│  │  │      assembly.xml -> maven assemble 生产
	│  │  │      assembly_test.xml -> maven assemble 测试
	│  │  │      
	│  │  ├─java
	│  │  │  
	│  │  │                      
	│  │  ├─resources
	│  │  │      application.properties 生产配置
	│  │  │      application_test.properties  测试配置
	│  │  │      logback.xml
	│  │  │      
	│  │  └─scripts
	│  │          run.bat
	│  │          run.sh
	│  │          
	│  └─test
	│      ├─java
	│      │  └─ApplicationDev.java  开发环境启动
	│      │              
	│      └─resources
	│              application_dev.properties 开发环境配置
	│              log4jdbc.log4j2.properties
	│              logback-test.xml
	│              
	└─readme.md


### 打包目录说明
    
	
	├─run.bat
	├─run.sh
	│  
	├─conf -> 所有配置
	│      application.properties
	│      logback.xml
	│      
	└─lib -> 所有jar包
