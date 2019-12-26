<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="common/header.jsp">
    <jsp:param name="pageTitle" value="Main page"/>
</jsp:include>

<div>

    <c:if test="${user !=null}">
        Hello ${user}!
    </c:if>
    <c:if test="${user !=null}">
        Login button
    </c:if>





    <form action="${pageContext.request.contextPath}/controller">
        <input name="command" type="hidden">
        <input name="login" type="text">
        <input name="password" type="password">
        <input type="submit" value="login">
    </form>
</div>


<jsp:include page="common/footer.jsp"/>