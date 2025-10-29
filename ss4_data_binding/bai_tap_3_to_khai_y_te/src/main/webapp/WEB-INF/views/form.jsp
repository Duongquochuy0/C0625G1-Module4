<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Tờ khai y tế</title>
    <style>
        body { font-family: "Segoe UI", Roboto, Arial, sans-serif; background:#f6f7fb; margin:0; padding:24px; color:#111; }
        .paper { width:900px; max-width:95%; margin:18px auto; background:#fff; padding:28px 36px; border-radius:8px; box-shadow:0 8px 30px rgba(9,30,66,0.08); }
        .title { text-align:center; }
        .title h1 { margin:0; font-size:22px; font-weight:700; color:#2563eb; }
        .title p { margin:8px 0 0; font-size:13px; color:#374151; }
        .alert { color:#b91c1c; text-align:center; margin:14px 0; font-weight:700; }
        .row { display:flex; gap:18px; margin-bottom:14px; }
        .col { flex:1; display:flex; flex-direction:column; gap:6px; }
        label { font-size:13px; color:#111827; font-weight:600; }
        .required { color:#e11d48; margin-left:4px; }
        .full { width:100%; padding:10px 12px; border-radius:6px; border:1px solid #d1d5db; font-size:14px; background:#fff; }
        .full:focus { outline:none; border-color:#2563eb; box-shadow:0 0 0 3px rgba(37,99,235,0.1); }
        .section { margin-top:20px; padding-top:10px; border-top:1px solid #e5e7eb; }
        .checkbox-row { display:flex; gap:16px; flex-wrap:wrap; margin-top:8px; }
        .checkbox-row label { display:flex; gap:6px; align-items:center; font-weight:500; font-size:13px; }
        .btn { background:#10b981; color:#fff; border:none; padding:10px 22px; border-radius:8px; font-weight:700; cursor:pointer; font-size:15px; }
        .btn:hover { background:#059669; }
        @media(max-width:768px){ .row{flex-direction:column;} .paper{padding:18px;} }
    </style>
</head>
<body>
<div class="paper">
    <div class="title">
        <h1>TỜ KHAI Y TẾ</h1>
        <p>THÔNG TIN CỦA ANH/CHỊ SẼ ĐƯỢC SỬ DỤNG PHỤC VỤ PHÒNG CHỐNG DỊCH</p>
    </div>

    <div class="alert">⚠️ Khai báo sai sự thật là vi phạm pháp luật Việt Nam</div>

    <form:form modelAttribute="toKhaiYTe" action="save" method="post">


        <div class="row">
            <div class="col">
                <label>Họ và tên <span class="required">*</span></label>
                <form:input path="fullName" cssClass="full" placeholder="Nhập họ và tên" required="true"/>
            </div>
        </div>

        <div class="row">
            <div class="col">
                <label>Năm sinh</label>
                <form:input path="yearOfBirth" type="number" cssClass="full"/>
            </div>
            <div class="col">
                <label>Giới tính</label>
                <form:select path="gender" cssClass="full">
                    <form:option value="">-- Chọn giới tính --</form:option>
                    <form:option value="Nam" label="Nam"/>
                    <form:option value="Nữ" label="Nữ"/>
                    <form:option value="Khác" label="Khác"/>
                </form:select>
            </div>
            <div class="col">
                <label>Quốc tịch</label>
                <form:input path="nationality" cssClass="full"/>
            </div>
        </div>


        <div class="row">
            <div class="col">
                <label>Số CMND/CCCD</label>
                <form:input path="idCard" cssClass="full"/>
            </div>
            <div class="col">
                <label>Phương tiện di chuyển</label>
                <div class="checkbox-row">
                    <label><form:radiobutton path="vehicle" value="Tàu bay"/>Tàu bay</label>
                    <label><form:radiobutton path="vehicle" value="Tàu thuyền"/>Tàu thuyền</label>
                    <label><form:radiobutton path="vehicle" value="Ô tô"/>Ô tô</label>
                    <label><form:radiobutton path="vehicle" value="Khác"/>Khác</label>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col">
                <label>Số hiệu phương tiện</label>
                <form:input path="vehicleNumber" cssClass="full"/>
            </div>
            <div class="col">
                <label>Ngày khởi hành</label>
                <form:input path="departureDay" type="date" cssClass="full"/>
            </div>
            <div class="col">
                <label>Ngày kết thúc</label>
                <form:input path="endDay" type="date" cssClass="full"/>
            </div>
        </div>

        <div class="row">
            <div class="col">
                <label>Địa chỉ liên lạc</label>
                <form:input path="address" cssClass="full" placeholder="Nhập địa chỉ hiện tại"/>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <label>Điện thoại</label>
                <form:input path="phone" cssClass="full" placeholder="Số điện thoại liên hệ"/>
            </div>
            <div class="col">
                <label>Email</label>
                <form:input path="email" type="email" cssClass="full" placeholder="example@gmail.com"/>
            </div>
        </div>

        <div class="section">
            <label style="font-weight:700;">Triệu chứng (14 ngày qua)</label>
            <div class="checkbox-row">
                <label><form:checkbox path="fever"/>Sốt</label>
                <label><form:checkbox path="cough"/>Ho</label>
                <label><form:checkbox path="soreThroat"/>Đau họng</label>
                <label><form:checkbox path="shortnessOfBreath"/>Khó thở</label>
            </div>
        </div>

        <div class="section">
            <label style="font-weight:700;">Lịch sử tiếp xúc</label>
            <div class="checkbox-row">
                <label><form:checkbox path="contactWithPatient"/>Tiếp xúc với người nhiễm bệnh</label>
                <label><form:checkbox path="contactWithFeverPerson"/>Tiếp xúc với người có biểu hiện sốt, ho</label>
                <label><form:checkbox path="contactWithForeign"/>Tiếp xúc với người từ nước có dịch</label>
            </div>
        </div>
        <div style="text-align:center; margin-top:25px;">
            <input type="submit" class="btn" value="GỬI TỜ KHAI"/>
        </div>

    </form:form>
</div>
</body>
</html>
