<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Máy tính</title>
  <style>
    body { font-family: Arial; text-align: center; margin-top: 50px; }
    input, select { padding: 5px; margin: 5px; }
    .error { color: red; }
    .result { color: green; font-weight: bold; }
  </style>
</head>
<body>
<h2>Máy tính</h2>

<form action="calculate" method="get">
  <input type="number" name="num1" step="any" value="${num1}" required>
  <select name="operator">
    <option value="+" ${operator == '+' ? 'selected' : ''}>+</option>
    <option value="-" ${operator == '-' ? 'selected' : ''}>-</option>
    <option value="*" ${operator == '*' ? 'selected' : ''}>×</option>
    <option value="/" ${operator == '/' ? 'selected' : ''}>÷</option>
  </select>
  <input type="number" name="num2" step="any" value="${num2}" required>
  <button type="submit">Tính</button>
</form>

<c:if test="${not empty error}">
  <p class="error">${error}</p>
</c:if>

<c:if test="${not empty result}">
  <p class="result">Kết quả: ${result}</p>
</c:if>

</body>
</html>
