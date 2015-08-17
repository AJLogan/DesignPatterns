.assembly extern mscorlib {}
.assembly Hello {}

.class public auto ansi SayHello extends [mscorlib]System.Object {
	.method public static void FooBar() il managed {
		//entry point declaration (one per assembly)
		.entrypoint
		//load a string onto the execution stack
		ldstr "Hello There"
		//call a method from another assembly
		call void [mscorlib]System.Console::WriteLine(string)
		//return from this method
		ret
	}

}