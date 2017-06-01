if "%1"=="" (
	set p=500
	set i=500
) else (
	set p=%1
	set i=%2
)
cd bin
for /f %%f in ('dir /b ..\instancje') do java bio.Projekt %%f -pi %p% %i% >>..\odp\p%p%i%i%
echo xD