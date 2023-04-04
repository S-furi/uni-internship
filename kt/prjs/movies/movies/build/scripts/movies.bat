@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  movies startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and MOVIES_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\movies-1.0-SNAPSHOT.jar;%APP_HOME%\lib\dataframe-0.9.1.jar;%APP_HOME%\lib\dataframe-arrow-0.9.1.jar;%APP_HOME%\lib\dataframe-excel-0.9.1.jar;%APP_HOME%\lib\dataframe-core-0.9.1.jar;%APP_HOME%\lib\kotlinpoet-1.12.0.jar;%APP_HOME%\lib\kotlin-stdlib-jdk8-1.8.0.jar;%APP_HOME%\lib\kotlin-stdlib-jdk7-1.8.0.jar;%APP_HOME%\lib\klaxon-5.5.jar;%APP_HOME%\lib\fuel-2.3.1.jar;%APP_HOME%\lib\kotlin-reflect-1.8.0.jar;%APP_HOME%\lib\kotlinx-datetime-jvm-0.4.0.jar;%APP_HOME%\lib\result-3.1.0.jar;%APP_HOME%\lib\kotlin-stdlib-1.8.0.jar;%APP_HOME%\lib\kotlin-stdlib-common-1.8.0.jar;%APP_HOME%\lib\annotations-13.0.jar;%APP_HOME%\lib\commons-csv-1.8.jar;%APP_HOME%\lib\arrow-vector-10.0.0.jar;%APP_HOME%\lib\arrow-format-10.0.0.jar;%APP_HOME%\lib\arrow-memory-unsafe-10.0.0.jar;%APP_HOME%\lib\poi-ooxml-5.2.2.jar;%APP_HOME%\lib\commons-compress-1.21.jar;%APP_HOME%\lib\poi-5.2.2.jar;%APP_HOME%\lib\arrow-memory-core-10.0.0.jar;%APP_HOME%\lib\jackson-annotations-2.13.4.jar;%APP_HOME%\lib\jackson-datatype-jsr310-2.13.4.jar;%APP_HOME%\lib\jackson-databind-2.13.4.jar;%APP_HOME%\lib\jackson-core-2.13.4.jar;%APP_HOME%\lib\commons-codec-1.15.jar;%APP_HOME%\lib\netty-common-4.1.82.Final.jar;%APP_HOME%\lib\flatbuffers-java-1.12.0.jar;%APP_HOME%\lib\slf4j-api-1.7.25.jar;%APP_HOME%\lib\poi-ooxml-lite-5.2.2.jar;%APP_HOME%\lib\xmlbeans-5.0.3.jar;%APP_HOME%\lib\commons-io-2.11.0.jar;%APP_HOME%\lib\curvesapi-1.07.jar;%APP_HOME%\lib\log4j-api-2.17.2.jar;%APP_HOME%\lib\commons-collections4-4.4.jar;%APP_HOME%\lib\commons-math3-3.6.1.jar;%APP_HOME%\lib\SparseBitSet-1.2.jar;%APP_HOME%\lib\jsr305-3.0.2.jar


@rem Execute movies
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %MOVIES_OPTS%  -classpath "%CLASSPATH%" MainKt %*

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable MOVIES_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%MOVIES_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
