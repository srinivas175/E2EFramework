@echo off
cd /d %~dp0Framework
SET CLASSPATH=..\Framework\*;..\Framework\lib\*;
SET PATH=%PATH%;.

cls
taskkill -f /IM chromedriver.exe
java com.java.RunTest
taskkill -f /IM chromedriver.exe
taskkill -f /IM java.exe
pause