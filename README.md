# nanodbc-java-test

To set up the PowerShell build environment, use the following commands:

```
Import-Module "C:\Program Files\Microsoft Visual Studio\2022\Community\Common7\Tools\Microsoft.VisualStudio.DevShell.dll"

# For x86
Enter-VsDevShell -VsInstallPath "C:\Program Files\Microsoft Visual Studio\2022\Community" -DevCmdArguments '-arch=x86'

# For x64
Enter-VsDevShell -VsInstallPath "C:\Program Files\Microsoft Visual Studio\2022\Community" -DevCmdArguments '-arch=x64'

```

(reference: https://stackoverflow.com/a/69961784)

```

To run using the natively built library, add something like the following to VM arguments:

```
-Djava.library.path=D:\git\nanodbc-java-test\build\classes\java\main\io\nanodbc\windows-x86_64
```
