#include "stdio.h"
#include "windows.h"
#include "process.h"
#include "stdafx.h"

unsigned int _stdcall ThreadFunc(void * data);
DWORD GetExitCode(uintptr_t handle);
void PrintThreadTimes(const char * name, uintptr_t handle);

int _tmain(int argc, _TCHAR* argv[])
{
	uintptr_t handleToThreadOne;
	uintptr_t handleToThreadTwo;
	uintptr_t handleToThreadThree;

	unsigned int threadOneID;
	unsigned int threadTwoID;
	unsigned int threadThreeID;

	handleToThreadOne = _beginthreadex(NULL,0,ThreadFunc,"Thread 1",0,&threadOneID);
	handleToThreadTwo = _beginthreadex(NULL,0,ThreadFunc,"Thread 2",0,&threadTwoID);
	handleToThreadThree = _beginthreadex(NULL,0,ThreadFunc,"Thread 3",0,&threadThreeID);

	HANDLE handles[] = {
							(HANDLE)handleToThreadOne,
							(HANDLE)handleToThreadTwo,
							(HANDLE)handleToThreadThree
						};

	WaitForMultipleObjects(3,handles,true,INFINITE);
	printf("Threads finished with exit codes %d, %d and %d\n",
			GetExitCode(handleToThreadOne),
			GetExitCode(handleToThreadTwo),
			GetExitCode(handleToThreadThree));

	PrintThreadTimes("First thread",handleToThreadOne);
	PrintThreadTimes("Second thread",handleToThreadTwo);
	PrintThreadTimes("Thread thread",handleToThreadThree);

	CloseHandle((HANDLE)handleToThreadOne);
	CloseHandle((HANDLE)handleToThreadTwo);
	CloseHandle((HANDLE)handleToThreadThree);

	printf("End of main\n");
}
unsigned int _stdcall ThreadFunc(void * data) {
	for(int i=0;i<150;i++) {
		printf("%s message %d\n",data,i);
		Sleep(100);
	}
	return 0;
}
DWORD GetExitCode(uintptr_t handle) {
	DWORD code;
	GetExitCodeThread((HANDLE)handle, &code);
	return code;
}
void PrintThreadTimes(const char * name, uintptr_t handle) {
	FILETIME creationTime;
	FILETIME exitTime;
	FILETIME kernelTime;
	FILETIME userTime;

	SYSTEMTIME formattedCreationTime;
	SYSTEMTIME formattedExitTime;

	GetThreadTimes((HANDLE)handle,&creationTime,&exitTime,&kernelTime,&userTime);

	FileTimeToSystemTime(&creationTime,&formattedCreationTime);
	FileTimeToSystemTime(&exitTime,&formattedExitTime);

	printf("%s ran",name); 
	printf(" from %d:%d:%d:%d",formattedCreationTime.wHour,formattedCreationTime.wMinute,
			formattedCreationTime.wSecond,formattedCreationTime.wMilliseconds);
	printf(" to %d:%d:%d:%d\n",formattedExitTime.wHour,formattedExitTime.wMinute,
			formattedExitTime.wSecond,formattedExitTime.wMilliseconds);
}

