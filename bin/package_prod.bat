@echo off
echo [INFO] Package the zip in target dir.

cd %~dp0
cd ..
call mvn clean package -Pprod -Dmaven.test.skip=true
cd bin
pause