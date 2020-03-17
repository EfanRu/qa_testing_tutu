# language: ru
@all
Функция: Добавление пользователя
  Сервер должен принять на добавление пользователя с логином Огурчик и паролем Пестик
  Добавление успешно, если пользователь добавился к списку пользователей

  Предыстория:
    Допустим мы авторизовались под админом
    И зашли в меню добавления пользователя

  @correct
  Сценарий: Успешное добавление пользователя
    Если на сервере не существует такого же логина "Огурчик"
    Тогда пользователь с логином "Огурчик" и паролем "Пестик" добавляется корретно

  @fail
  Сценарий: Некорректное добавление пользователя
    Если на сервере существует такой же логин "Огурчик" с паролем "Пестик"
    Тогда пользователь с логином "Огурчик" и паролем "Пестик" не добавляется