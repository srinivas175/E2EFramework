cd /d %~dp0Framework
SET CLASSPATH=..\Framework\*;..\Framework\.;..\Framework\lib\*;
"C:\Program Files\Java\jdk1.8.0_60\bin\javac" -d . *.java
cd..
pause
