#!/bin/bash

echo "[INFO] Package the zip in target dir."

cd ..

mvn clean package -Pprod-Dmaven.test.skip=true

cd bin