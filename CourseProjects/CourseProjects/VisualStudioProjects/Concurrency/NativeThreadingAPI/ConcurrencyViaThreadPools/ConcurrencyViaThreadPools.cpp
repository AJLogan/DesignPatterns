#include "stdio.h"
#include "windows.h"
#include "process.h"
#include "stdafx.h"

VOID CALLBACK ThreadFuncOne(PTP_CALLBACK_INSTANCE instance, PVOID data, PTP_WORK work);
VOID CALLBACK ThreadFuncTwo(PTP_CALLBACK_INSTANCE instance, PVOID data, PTP_WORK work);

int _tmain(int argc, _TCHAR* argv[]) {
	PTP_WORK work1 = CreateThreadpoolWork(ThreadFuncOne,"Thread 1",NULL);
	PTP_WORK work2 = CreateThreadpoolWork(ThreadFuncTwo,"Thread 2",NULL);

	SubmitThreadpoolWork(work1);
	SubmitThreadpoolWork(work2);

	WaitForThreadpoolWorkCallbacks(work1,FALSE);
	WaitForThreadpoolWorkCallbacks(work2,FALSE);

	CloseThreadpoolWork(work1);
	CloseThreadpoolWork(work2);

	printf("End of main\n");
}
VOID CALLBACK ThreadFuncOne(PTP_CALLBACK_INSTANCE instance, PVOID data, PTP_WORK work) {
	for(int i=0;i<100;i++) {
		printf("%s message %d\n",data,i);
		Sleep(100);
	}
}
VOID CALLBACK ThreadFuncTwo(PTP_CALLBACK_INSTANCE instance, PVOID data, PTP_WORK work) {
	for(int i=0;i<100;i++) {
		printf("%s message %d\n",data,i);
		Sleep(100);
	}
}


