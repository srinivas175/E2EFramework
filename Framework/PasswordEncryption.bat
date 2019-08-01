@echo off
cd %~dp0


echo.

SET CLASSPATH=..\Framework\*;
SET PATH=%PATH%;.

echo.

set num1=2
set /p num1=Enter string to be encrypted:

echo.


java com.java.CryptoUtil %num1%

echo ------------------------------------------------------------------
echo.
echo You can also find the Output in following text file
@echo off&setlocal
for %%i in ("%~dp0..") do set "folder=%%~fi"

echo %folder%\TestInputs\decryptContent.txt
echo.
echo ------------------------------------------------------------------

pause