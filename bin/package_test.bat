@echo off
echo [INFO] Package the war in target dir.

cd %~dp0
cd ..
call mvn clean package -Ptest  -Dmaven.test.skip=true
cd bin
pause