# Diplom_3. Проект с UI автотестами для двух браузеров

## Требования
1. Установленный браузер Google Chrome
2. Установить браузер Yandex
3. Скачать файлы с кодом, яндекс драйвер и pom.xml

## Описание:
1) в пакете factoryBrowsers реализован метод выбора браузера для выполнения тестов: 
- Яндекс (через бинарный файл и указание исполняемого браузера)
- Google Chrome - подключение через WebDriverManager
2) в пакете testDataCreateApi реализованы классы с методами API, через которые создаются и удаляются тестовые пользователи
3) в пакете pageObjeckts описаны page object для всех страниц и методы для тестов
4) в пакете  src/test/java написаны тесты по требованиям из задания №3

## Для запуска тестов в разных браузерах используем команды:
- Запуск в Яндекс браузере: mvn clean test -Dbrowser=yandex allure:report
- Запуск в Google Chrome: mvn clean test -Dbrowser=chrome allure:report или mvn clean test -Dbrowser= allure:report (если не указываем браузер, то по умолчанию запускается хром)

## После завершения тестов для генерации отчета Allure выполняем:
-  allure serve target/allure-results

