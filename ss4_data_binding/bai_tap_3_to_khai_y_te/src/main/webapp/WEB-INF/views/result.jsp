<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
  <meta charset="UTF-8">
  <title>Kết quả tờ khai y tế</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f3f4f6;
      margin: 0;
      padding: 0;
    }
    .container {
      width: 700px;
      background-color: #fff;
      margin: 40px auto;
      padding: 30px 40px;
      border-radius: 12px;
      box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }
    h2 {
      text-align: center;
      color: #2563eb;
      margin-bottom: 25px;
    }
    .info p {
      font-size: 16px;
      line-height: 1.6;
      margin: 6px 0;
    }
    .info b {
      color: #111827;
      width: 180px;
      display: inline-block;
    }
    .section {
      margin-top: 20px;
    }
    .button-group {
      text-align: center;
      margin-top: 25px;
    }
    a.button {
      background-color: #2563eb;
      color: white;
      padding: 10px 20px;
      text-decoration: none;
      border-radius: 6px;
      font-weight: bold;
    }
    a.button:hover {
      background-color: #1e40af;
    }
  </style>
</head>
<body>
<div class="container">
  <h2>KẾT QUẢ TỜ KHAI Y TẾ</h2>

  <div class="info">
    <p><b>Họ và tên:</b> ${toKhaiYTe.fullName}</p>
    <p><b>Năm sinh:</b> ${toKhaiYTe.yearOfBirth}</p>
    <p><b>Giới tính:</b> ${toKhaiYTe.gender}</p>
    <p><b>Quốc tịch:</b> ${toKhaiYTe.nationality}</p>
    <p><b>Số CMND/CCCD:</b> ${toKhaiYTe.idCard}</p>
    <p><b>Phương tiện:</b> ${toKhaiYTe.vehicle}</p>
    <p><b>Số hiệu phương tiện:</b> ${toKhaiYTe.vehicleNumber}</p>
    <p><b>Ngày khởi hành:</b> ${toKhaiYTe.departureDay}</p>
    <p><b>Ngày kết thúc:</b> ${toKhaiYTe.endDay}</p>
    <p><b>Địa chỉ:</b> ${toKhaiYTe.address}</p>
    <p><b>Điện thoại:</b> ${toKhaiYTe.phone}</p>
    <p><b>Email:</b> ${toKhaiYTe.email}</p>
  </div>

  <div class="section">
    <h3>Triệu chứng (14 ngày qua)</h3>
    <ul>
      <c:if test="${toKhaiYTe.fever}"><li>Sốt</li></c:if>
      <c:if test="${toKhaiYTe.cough}"><li>Ho</li></c:if>
      <c:if test="${toKhaiYTe.soreThroat}"><li>Đau họng</li></c:if>
      <c:if test="${toKhaiYTe.shortnessOfBreath}"><li>Khó thở</li></c:if>
      <c:if test="${!toKhaiYTe.fever && !toKhaiYTe.cough && !toKhaiYTe.soreThroat && !toKhaiYTe.shortnessOfBreath}">
        <li>Không có triệu chứng</li>
      </c:if>
    </ul>
  </div>

  <div class="section">
    <h3>Lịch sử tiếp xúc</h3>
    <ul>
      <c:if test="${toKhaiYTe.contactWithPatient}"><li>Tiếp xúc với người nhiễm bệnh</li></c:if>
      <c:if test="${toKhaiYTe.contactWithFeverPerson}"><li>Tiếp xúc với người có biểu hiện sốt, ho</li></c:if>
      <c:if test="${toKhaiYTe.contactWithForeign}"><li>Tiếp xúc với người từ vùng dịch</li></c:if>
      <c:if test="${!toKhaiYTe.contactWithPatient && !toKhaiYTe.contactWithFeverPerson && !toKhaiYTe.contactWithForeign}">
        <li>Không có tiếp xúc nguy cơ</li>
      </c:if>
    </ul>
  </div>

  <div class="button-group">
    <a href="edit" class="button">Chỉnh sửa tờ khai</a>
  </div>
</div>
</body>
</html>
