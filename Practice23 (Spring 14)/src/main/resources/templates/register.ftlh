<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Регистрация</title>
    <style>
        <#include "styles.css">
    </style>
</head>
<body>
<div class="container">
    <form action="/register" method="post">
        <h2>Регистрация</h2>
        <div class="form-group">
            <label for="username"></label>
            <input type="text" placeholder="Имя пользователя" id="username" name="name" required>
        </div>
        <div class="form-group">
            <label for="email"></label>
            <input type="email" placeholder="Эл. почта" id="username" name="email" required>
        </div>
        <div class="form-group">
            <label for="phoneNumber"></label>
            <input type="tel" placeholder="Номер Телефона" id="username" name="phoneNumber" required>
        </div>
        <div class="form-group">
            <label for="password"></label>
            <input type="password" placeholder="Пароль" id="password" name="password" required>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit">Зарегистрироваться</button>
    </form>
    <p>Уже есть аккаунт?<p>
    <a href="/login">Войти</a>
</div>
</body>
</html>
