@echo off
echo.
echo [��Ϣ] ������target����·����
echo.

%~d0
cd %~dp0

cd ..
call mvn clean

pause
