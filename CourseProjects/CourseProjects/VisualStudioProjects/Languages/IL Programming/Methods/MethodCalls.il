.assembly extern mscorlib {}
.assembly MethodCalls {}

.class public auto ansi CallingMethods extends [mscorlib]System.Object {
	
	.method public static void FooBar() il managed {
		.entrypoint	//entry point declaration (one per assembly)
		ldc.i4 12	//load an integer constant
		ldc.r4 7.8	//load a floating point constant
		ldstr "abcdef"	//load a string constant
		call void CallingMethods::testFunc(int32 p1, float32 p2, string p3)
		ret
	}
	.method private static void testFunc(int32 p1, float32 p2, string p3) il managed {
		ldarg.0
		box int32
		call void [mscorlib]System.Console::WriteLine(object)
		ldarg.1
		box float32
		call void [mscorlib]System.Console::WriteLine(object)
		ldarg.2
		call void [mscorlib]System.Console::WriteLine(object)
		ret	//return
	}

}