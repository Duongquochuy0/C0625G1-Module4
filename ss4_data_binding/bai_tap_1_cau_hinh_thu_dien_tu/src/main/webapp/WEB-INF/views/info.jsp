<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Information</title></head>
<body>
<h2>Updated Email Settings</h2>
<p><strong>Language:</strong> ${updatedSetting.language}</p>
<p><strong>Page size:</strong> ${updatedSetting.pageSize}</p>
<p><strong>Spams filter:</strong> ${updatedSetting.spamsFilter ? "Enabled" : "Disabled"}</p>
<p><strong>Signature:</strong><br/> <pre>${updatedSetting.signature}</pre></p>

<a href="/settings">Back to settings</a>
</body>
</html>
