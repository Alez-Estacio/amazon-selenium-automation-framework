@echo off
echo ==========================================
echo    Iniciando Pruebas Automatizadas
echo ==========================================
echo.

REM Verificar si Java está instalado
java -version > nul 2>&1
if errorlevel 1 (
    echo Error: Java no está instalado
    echo Por favor instale Java y agregue JAVA_HOME a las variables de entorno
    pause
    exit /b 1
)

echo Ejecutando pruebas...
echo.

REM Ejecutar pruebas con Gradle
call gradlew clean test

echo.
echo ==========================================
echo    Pruebas Completadas
echo ==========================================
echo.
echo El reporte se encuentra en:
echo test-output\SparkReport\Spark.html
echo.

pause