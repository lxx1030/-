<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path = request.getContextPath();%>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function del(id) {
            $.post("delete",
                {id:id},
                function (data) {
                    if(data>0){
                        alert("删除成功");
                        window.location.reload();
                    }
                },"json")
        }
        function upd(id) {
            window.location.href="<%=path%>/student/toupdate/?id="+id;
        }

    </script>
</head>

<body>
<form action="list" method="post">
    <input type="text" name="name">
    <input type="submit" value="查询">
</form>
<table>
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>邮箱</td>
        <td>头像</td>
        <td><a href="/toAdd">添加</a></td>
    </tr>
    <c:forEach items="${list}" var="l">
        <tr>
            <td>${l.id}</td>
            <td>${l.name}</td>
            <td>${l.email}</td>
            <td><img alt="" width="50" height="50" src="img/${l.photo}"></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
