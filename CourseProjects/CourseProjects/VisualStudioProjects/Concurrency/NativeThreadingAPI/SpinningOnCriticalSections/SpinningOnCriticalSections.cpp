#include "stdio.h"
#include "windows.h"
#include "process.h"
#include "stdafx.h"

unsigned int _stdcall ThreadFunc(void * data);
DWORD GetExitCode(uintptr_t handle);

struct MyData {
	const char * threadName;
	CRITICAL_SECTION * criticalSection;
};

int _tmain(int argc, _TCHAR* argv[])
{
	uintptr_t handleToThreadOne;
	uintptr_t handleToThreadTwo;
	uintptr_t handleToThreadThree;

	unsigned int threadOneID;
	unsigned int threadTwoID;
	unsigned int threadThreeID;

	CRITICAL_SECTION criticalSection;
	InitializeCriticalSection(&criticalSection);

	MyData d1 = {"Thread 1", &criticalSection};
	MyData d2 = {"Thread 2", &criticalSection};
	MyData d3 = {"Thread 3", &criticalSection};

	handleToThreadOne = _beginthreadex(NULL,0,ThreadFunc,&d1,0,&threadOneID);
	handleToThreadTwo = _beginthreadex(NULL,0,ThreadFunc,&d2,0,&threadTwoID);
	handleToThreadThree = _beginthreadex(NULL,0,ThreadFunc,&d3,0,&threadThreeID);

	Sleep(500);  //Give threads time to start running
	while(1) {
		if(!TryEnterCriticalSection(&criticalSection)) {
			printf("Main filed to acquire critical section - will try again in 2 secs...\n");
			Sleep(2000);
		} else {
			printf("Main managed to acquire the critical section!\n");
			LeaveCriticalSection(&criticalSection);
			break;
		}
	}

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

	CloseHandle((HANDLE)handleToThreadOne);
	CloseHandle((HANDLE)handleToThreadTwo);
	CloseHandle((HANDLE)handleToThreadThree);

	DeleteCriticalSection(&criticalSection);

	printf("End of main\n");
}
unsigned int _stdcall ThreadFunc(void * data) {
	MyData * realData = (MyData *)data;
	for(int i=0;i<100;i++) {
		EnterCriticalSection(realData->criticalSection);
		printf("%s iteration %d message A\n",realData->threadName,i);
		Sleep(25);
		printf("%s iteration %d message B\n",realData->threadName,i);
		Sleep(25);
		printf("%s iteration %d message C\n",realData->threadName,i);
		Sleep(25);
		LeaveCriticalSection(realData->criticalSection);
		Sleep(25);
	}
	return 0;
}
DWORD GetExitCode(uintptr_t handle) {
	DWORD code;
	GetExitCodeThread((HANDLE)handle, &code);
	return code;
}




