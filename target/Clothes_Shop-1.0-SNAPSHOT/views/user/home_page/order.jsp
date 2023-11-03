<%-- 
    Document   : order
    Created on : Nov 3, 2023, 2:46:32 PM
    Author     : Huu Huy
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Thông Tin Người Mua</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <style>
            body {
                padding-top: 50px;
            }
            .container {
                max-width: 600px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h2 class="mb-4">Thông Tin Người Mua</h2>

            <form action="YourServletMapping" method="POST">
                <div class="mb-3">
                    <label for="fullname" class="form-label">Họ và Tên</label>
                    <input type="text" class="form-control" id="fullname" name="fullname" required>
                </div>

                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" class="form-control" id="email" name="email" required>
                </div>

                <div class="mb-3">
                    <label for="phone" class="form-label">Số Điện Thoại</label>
                    <input type="text" class="form-control" id="phone" name="phone" required>
                </div>

                <div class="mb-3">
                    <label for="address" class="form-label">Địa Chỉ</label>
                    <textarea class="form-control" id="address" name="address" rows="3" required></textarea>
                </div>

                <button type="submit" class="btn btn-primary">Xác Nhận</button>
            </form>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>

