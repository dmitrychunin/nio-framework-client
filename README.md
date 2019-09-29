# nio-framework-client
IO-клиент отправляющий несколько запросов одновременно, на сервер localhost:8080 и после получения ответа сразу закрывающий соединение

Инструкции по тестовому прогону проекта nio-framework, состоящего из 3х частей:
1) Установить nio-framework в локальную папку .m2 (clean install)
2) Запустить nio-framework-server: запуск main-класса NettyMain, либо сборка jar мавеном (clean package) и запуск из командной строки
3) Запустить nio-framework-client: запуск main-класса HttpIoClient, либо сборка jar мавеном (clean package) и запуск из командной строки
