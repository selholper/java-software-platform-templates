<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Вход</title>
    <style>
        <#include "styles.css">
    </style>
</head>
<body>
<div class="container">
    <form action="/home" method="get`">
        <h2>Вход</h2>
        <div class="form-group">
            <label for="username"></label>
            <input type="text" placeholder="Логин или эл. почта" id="username" name="username" required>
        </div>
        <div class="form-group">
            <label for="password"></label>
            <input type="password" placeholder="Пароль" id="password" name="password" required>
        </div>
        <button type="submit">Войти</button>
    </form>
    <p>Еще не зарегистрировались?<p>
    <a href="/register">Регистрация</a>
</div>
</body>
</html>
