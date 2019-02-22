##  mango的中文名是“芒果”，它是一个极速分布式ORM框架。  
###  官网：http://mango.jfaster.org/index.html   

##  特性:   
####   •	超高性能，响应速度接近直接使用JDBC    
####   •	采用接口与注解的形式定义DAO，完美结合db与cache操作    
####   •	支持动态sql，可以构造任意复杂的sql语句     
####   •	支持多数据源，分表，分库，事务      
####   •	提供拦截器功能，利用拦截器可为mango框架扩展各种自定义插件     
####   •	独创“函数式调用”功能，能将任意复杂的对象，映射到数据库的表中       
####   •	高效详细的实时统计系统，方便开发者随时了解自己的系统      
####   •	独立jar包，不依赖其它jar包       
####   •	提供便捷的spring插件，与spring无缝集成       


####  添加依赖：    
    <dependency>
        <groupId>org.jfaster</groupId>
        <artifactId>mango</artifactId>
        <version>1.6.1</version>
    </dependency>
    


###  构造数据源并初始化mango对象：   
mango框架对java标准数据源 javax.sql.DataSource 进行了简单实现，所以这里构造数据源不需要引入第三方jar包。
### 初始化数据源需要4个参数:    
#####   •	driverClassName: 驱动程序类名，这里我们使用MySQL驱动，所以类名是 com.mysql.jdbc.Driver 。
#####   •	url: 连接数据库的url，这里我们将连接到本地MySQL的mango_example库，所以地址为 jdbc:mysql://localhost:3306/mango_example 。
#####   •	username: 数据库用户名，这里我们使用root作为用户名。
#####   •	password: 用户名所对应的密码，这里我们使用root作为密码。

###  更新
更新主要包含insert，delete与update这三种操作。     
通常情况化更新操作支持四种类型的返回值：     
1、void或java.lang.Void：不返回值    
2、int或java.lang.Integer：返回有多少行数据受到了影响     
3、long或java.lang.Long：返回有多少行数据受到了影响     
4、boolean或java.lang.Boolean：false表示没有数据受到影响，true表示有一到多行数据受到影响      

###  批量更新
批量更新主要包含insert，delete与update这三种操作。        
批量更新的输入只能有一个参数，参数的类型必须是List或Set或Array。          
批量更新的输出支持三种类型的返回值：       
1、void或java.lang.Void：不返回值          
2、int或java.lang.Integer：返回累计有多少行数据受到了影响          
3、int[]或java.lang.Integer[]：返回每条更新语句影响到了多少行数据           


