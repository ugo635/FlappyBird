@echo off
call gradlew.bat getExe

if %ERRORLEVEL% neq 0 (
    echo Build failed.
    pause
    exit /b %ERRORLEVEL%
)

echo Build complete.
pause
