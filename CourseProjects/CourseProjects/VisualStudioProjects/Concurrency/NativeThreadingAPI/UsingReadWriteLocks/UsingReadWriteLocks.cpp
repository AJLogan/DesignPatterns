#include "stdio.h"
#include "windows.h"
#include "process.h"
#include "stdafx.h"
#include "WinBase.h"

unsigned int _stdcall ReaderThreadFunc(void * data);
unsigned int _stdcall WriterThreadFunc(void * data);
DWORD GetExitCode(uintptr_t handle);

struct MyData {
	const char * threadName;
	SRWLOCK * readWriteLock;
};

int _tmain(int argc, _TCHAR* argv[]) {
	uintptr_t handleToThreadOne;
	uintptr_t handleToThreadTwo;
	uintptr_t handleToThreadThree;
	uintptr_t handleToThreadFour;
	uintptr_t handleToThreadFive;

	unsigned int threadOneID;
	unsigned int threadTwoID;
	unsigned int threadThreeID;
	unsigned int threadFourID;
	unsigned int threadFiveID;

	SRWLOCK slimReadWriteLock;
	InitializeSRWLock(&slimReadWriteLock);

	MyData d1 = {"Thread 1", &slimReadWriteLock};
	MyData d2 = {"Thread 2", &slimReadWriteLock};
	MyData d3 = {"Thread 3", &slimReadWriteLock};
	MyData d4 = {"Thread 4", &slimReadWriteLock};
	MyData d5 = {"Thread 5", &slimReadWriteLock};

	handleToThreadOne = _beginthreadex(NULL,0,WriterThreadFunc,&d1,0,&threadOneID);
	handleToThreadTwo = _beginthreadex(NULL,0,WriterThreadFunc,&d2,0,&threadTwoID);
	handleToThreadThree = _beginthreadex(NULL,0,ReaderThreadFunc,&d3,0,&threadThreeID);
	handleToThreadFour = _beginthreadex(NULL,0,ReaderThreadFunc,&d4,0,&threadFourID);
	handleToThreadFive = _beginthreadex(NULL,0,ReaderThreadFunc,&d5,0,&threadFiveID);

	HANDLE handles[] = {
							(HANDLE)handleToThreadOne,
							(HANDLE)handleToThreadTwo,
							(HANDLE)handleToThreadThree,
							(HANDLE)handleToThreadFour,
							(HANDLE)handleToThreadFive
						};

	WaitForMultipleObjects(5,handles,true,INFINITE);
	printf("Threads finished with exit codes %d, %d, %d, %d and %d\n",
			GetExitCode(handleToThreadOne),
			GetExitCode(handleToThreadTwo),
			GetExitCode(handleToThreadThree),
			GetExitCode(handleToThreadFour),
			GetExitCode(handleToThreadFive));

	CloseHandle((HANDLE)handleToThreadOne);
	CloseHandle((HANDLE)handleToThreadTwo);
	CloseHandle((HANDLE)handleToThreadThree);
	CloseHandle((HANDLE)handleToThreadFour);
	CloseHandle((HANDLE)handleToThreadFive);

	printf("End of main\n");
}
unsigned int _stdcall WriterThreadFunc(void * data) {
	MyData * realData = (MyData *)data;
	for(int i=0;i<50;i++) {
		AcquireSRWLockExclusive(realData->readWriteLock);
		printf("%s has the SRWLock for exclusive access message A\n",realData->threadName);
		Sleep(25);
		printf("%s has the SRWLock for exclusive access message B\n",realData->threadName);
		Sleep(25);
		printf("%s has the SRWLock for exclusive access message C\n",realData->threadName);
		Sleep(25);
		printf("%s has the SRWLock for exclusive access message D\n",realData->threadName);
		ReleaseSRWLockExclusive(realData->readWriteLock);
		Sleep(25);
	}
	return 0;
}
unsigned int _stdcall ReaderThreadFunc(void * data) {
	MyData * realData = (MyData *)data;
	for(int i=0;i<50;i++) {
		AcquireSRWLockShared(realData->readWriteLock);
		printf("%s has the SRWLock for shared access message W\n",realData->threadName);
		Sleep(25);
		printf("%s has the SRWLock for shared access message X\n",realData->threadName);
		Sleep(25);
		printf("%s has the SRWLock for shared access message Y\n",realData->threadName);
		Sleep(25);
		printf("%s has the SRWLock for shared access message Z\n",realData->threadName);
		ReleaseSRWLockShared(realData->readWriteLock);
		Sleep(25);
	}
	return 0;
}
DWORD GetExitCode(uintptr_t handle) {
	DWORD code;
	GetExitCodeThread((HANDLE)handle, &code);
	return code;
}






