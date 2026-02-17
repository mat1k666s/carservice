package ru.car.api.client;

public enum InteractionType {
    CALL_IN, //("Входящий звонок")
    CALL_OUT,//("Исходящий звонок")
    EMAIL, //("Email")
    SMS,//("SMS")
    MEETING,//("Встреча")
    ORDER_CREATED,//("Создание заявки")
    ORDER_COMPLETED,//("Завершение заявки")
    ORDER_CANCELLED,//("Отмена заявки")
    VISIT,//("Визит в сервис")
    COMPLAINT,//("Жалоба")
    FEEDBACK,//("Обратная связь")
    CONSULTATION, //("Консультация")
    SERVICE_REMINDER,//("Напоминание о ТО")
    BIRTHDAY, //("Поздравление с днём рождения")
    OTHER//("Другое")

}
