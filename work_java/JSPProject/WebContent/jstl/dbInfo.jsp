<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<sql:setDataSource  var="ds" 
  driver="com.mysql.cj.jdbc.Driver" 
  url ="jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8" 
  user="scott" password="tiger" 
/> 