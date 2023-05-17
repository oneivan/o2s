# Домашнее задание. Проект gradle с модульной структурой


 1  Создайте аккаунт на github.com (если еще нет)
 2  Создайте репозиторий для домашних работ
 3  Сделайте checkout репозитория на свой компьютер
 4  Создайте локальный бранч hw01-gradle
 5  Создать проект gradle
 6  В проект добавьте последнюю версию зависимости
    com.google.guava
    guava
 7  Создайте модуль hw01-gradle

 8  В модуле сделайте класс HelloOtus
 9  В этом классе сделайте вызов какого-нибудь метода из guava
10  Создайте "толстый-jar"
11  Убедитесь, что "толстый-jar" запускается.
12  Сделайте pull-request в gitHub
13  Ссылку на PR отправьте на проверку (личный кабинет, чат с преподавателем).

mkdir hw01-gradle 
cd mw01-gradle
gradle init --type java-application
...
Idea - open project - Refactor main class
...

## Guava Example

based on https://www.tutorialspoint.com/guava/guava_joiner.htm

## add FAT-JAR Builer

see Author's doc - https://imperceptiblethoughts.com/shadow/configuration/#configuring-output-name


## Check for FAT-JAR-FILE:

(base) ➜  ~/edq/o2s/Java/hw01-gradle git:(hw01-gradle) ✗ find . -type f -name "*jar" -ls
24940433        8 -rw-r--r--    1 oneivan          staff                1261 May  2 19:56 ./app/build/libs/app.jar
24940545     6208 -rw-r--r--    1 oneivan          staff             3175412 May  2 19:57 ./app/build/libs/fat-jar-file-0.0.1.jar
24936440      128 -rw-r--r--    1 oneivan          staff               62076 May  2 19:18 ./gradle/wrapper/gradle-wrapper.jar

## Check FAT-RUN run:

(base) ➜  ~/edq/o2s/Java/hw01-gradle/app/build/libs git:(hw01-gradle) ✗ java -cp ./fat-jar-file-0.0.1.jar hw01/gradle/HelloOtus
Call Guava String Joiner for Array with NULL values (skipped)
1,2,3,4,5,6
