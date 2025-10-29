<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head><title>Email Setting</title></head>
<body>
<h2>Settings</h2>

<form:form modelAttribute="emailSetting" action="update" method="post">
    <p>
        <label>Languages:</label>
        <form:select path="language" items="${languages}" />
    </p>
    <p>
        <label>Page Size:</label>
        Show <form:select path="pageSize" items="${pageSizes}" /> emails per page
    </p>
    <p>
        <label>Spams filter:</label>
        <form:checkbox path="spamsFilter" /> Enable spams filter
    </p>
    <p>
        <label>Signature:</label><br/>
        <form:textarea path="signature" rows="4" cols="40" />
    </p>
    <input type="submit" value="Update" />
    <input type="reset" value="Cancel" />
</form:form>
</body>
</html>
