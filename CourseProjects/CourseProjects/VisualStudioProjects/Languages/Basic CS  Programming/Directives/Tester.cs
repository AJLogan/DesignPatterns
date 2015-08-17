#define TEST_SYMBOL
//#undef TEST_SYMBOL

using System;

namespace Directives
{
	class Tester
	{
#if TEST_SYMBOL
		private static void endOnError(string msg) {
			Console.WriteLine("Cannot continue because: {0}",msg);
			throw new Exception(msg);
		}
#else
		private static void endOnError(string msg) {
			Console.WriteLine("Ignoring: {0}",msg);
		}
#endif

		#region How this code executes depends on TEST_SYMBOL
		static void Main(string[] args) 
		{
			endOnError("problem has occured");
		}
		#endregion
	}
}
