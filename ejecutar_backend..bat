@echo off
echo ================================
echo Compilando MarketPro POS API...
echo ================================

cd pos-api

REM Compilar el proyecto con Maven
mvn clean package

IF %ERRORLEVEL% NEQ 0 (
    echo ERROR: Falló la compilación. Verifica el código.
    pause
    exit /b
)

echo ================================
echo Ejecutando el backend...
echo ================================

REM Ejecutar el JAR generado
java -jar target\pos-api-0.0.1-SNAPSHOT.jar

pause