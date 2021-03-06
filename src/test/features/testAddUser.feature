# language: ru
@all
Функция: Заказ Ж/Д билета
  Нужно сформировать заказ на Ж/Д билет
  Заказ успешен, если пользователь смог сформировтаь заказ

  Предыстория:
    Допустим мы зашли на сайт "tutu.ru"
    И зашли в меню заказ Ж/Д билетов

  @correct
  Сценарий: Успешное формирование заказа на Ж/Д билет
    Если имееются свободные места на сегодняшнее число из "Москва" в "Санкт-Петербург"
    Тогда сформировать заказ на билет из "Москвы" в "Санкт-Петербург"

#  @fail
#  Сценарий: Некорректное заказ билета
#    Если сделать заказ на вчерашнюю дату
#    Тогда должно появиться сообщение об ошибке