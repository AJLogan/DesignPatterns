#include "stdio.h"
#include "windows.h"
#include "process.h"
#include "stdafx.h"
#include "psapi.h"

//NB this program requires Psapi.lib or Psapi.dll
int _tmain(int argc, _TCHAR* argv[])
{
	const int magic = 256;
	HMODULE modulesInThisProcess[magic];
	DWORD arraySizeInBytes = magic * sizeof(HMODULE);
	DWORD arraySizeNeededInBytes;

	HANDLE currentProcess = GetCurrentProcess();

	if(!EnumProcessModules(currentProcess,modulesInThisProcess,arraySizeInBytes,&arraySizeNeededInBytes)) {
		printf("Could not enumerate modules!");
	} else {
		int moduleCount = arraySizeNeededInBytes / sizeof(HMODULE);

		printf("Allocated space for %d modules\n", magic);
		printf("Actual number of modules was %d\n", moduleCount);

		printf("Modules loaded into this process are:\n");
		const int magic2 = 1024;
		TCHAR pathToModuleFile[magic2];
		for(int i=0; i<moduleCount; i++) {
			GetModuleFileName(modulesInThisProcess[i],pathToModuleFile,magic2);
			_tprintf(TEXT("\t%s\n"),pathToModuleFile);
		}
	}
	return 0;
}

