if "%1"=="" (
	set p=100
	set i=100
) else (
	set p=%1
	set i=%2
)
for /f %%f in ('dir /b ..\instancje') do java -cp ../bin bio.Projekt %%f -pi %p% %i% >>..\odp\p%p%i%i%
echo xD