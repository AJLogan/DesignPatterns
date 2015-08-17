#include "stdio.h"
#include "windows.h"
#include "process.h"
#include "stdafx.h"

VOID CALLBACK MyTimerCallback(PTP_CALLBACK_INSTANCE instance, PVOID data, PTP_TIMER timer);

int count = 1;

int _tmain(int argc, _TCHAR* argv[]) {
	HANDLE myEvent = CreateEvent(NULL,true,false,TEXT("MyEvent"));
	PTP_TIMER aTimer = CreateThreadpoolTimer(MyTimerCallback,&myEvent,NULL);

	//we want to start the timer one second from now
	ULARGE_INTEGER val;
	val.QuadPart = (LONGLONG) -(10000000);
	FILETIME startTime;
	startTime.dwHighDateTime = val.HighPart;
	startTime.dwLowDateTime = val.LowPart;
	
	printf("About to set timer\n");
	SetThreadpoolTimer(aTimer,&startTime,2000,20);

	WaitForSingleObject(myEvent,INFINITE);
	printf("End of main\n");
}
VOID CALLBACK MyTimerCallback(PTP_CALLBACK_INSTANCE instance, PVOID data, PTP_TIMER timer) {
	printf("Timer callback triggered (%d)\n",count);

	if(count == 10) {
		HANDLE * anEvent = (HANDLE *) data;
		SetEvent(*anEvent);
	} else {
		count++;
	}
}


