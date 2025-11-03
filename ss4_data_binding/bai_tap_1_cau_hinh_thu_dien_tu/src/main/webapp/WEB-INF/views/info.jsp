<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Information</title></head>
<body>
<h2>Updated Email Settings</h2>
<p><strong>Language:</strong> ${setting.language}</p>
<p><strong>Page size:</strong> ${setting.pageSize}</p>
<p><strong>Spams filter:</strong> ${setting.spamsFilter ? "Enabled" : "Disabled"}</p>
<p><strong>Signature:</strong><br/> <pre>${setting.signature}</pre></p>

<a href="/setting">Back to settings</a>
</body>
</html>
