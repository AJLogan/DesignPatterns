.assembly extern mscorlib {}
.assembly LocalVariables {}

.class public auto ansi Variables extends [mscorlib]System.Object {
	.field private static int32 myField		//declare a static field
	
	.method public static void FooBar() il managed {
		.entrypoint				//entry point declaration (one per assembly)
		.locals(int32 'myvar1')			//declare a local variable myvar1
		.locals(int32 'myvar2')			//declare a local variable myvar2
		ldc.i4 12				//load a value onto the stack
		stloc myvar1				//pop the value into the variable
		ldc.i4 16				//load a value onto the stack
		stloc myvar2				//pop the value into the variable
		ldloc myvar1				//push the value of myvar1 onto the stack
		ldloc myvar2				//push the value of myvar1 onto the stack
		call void Variables::Add(int32,int32)	//call the Add method (result kept in myField)
		ldsfld int32 Variables::myField		//load the value of myField onto the stack
		box int32				//box the field into an object
		call void [mscorlib]System.Console::WriteLine(object)
		ret
	}
	.method private static void Add(int32 val1, int32 val2) il managed {
		ldarg.0					//push arg 1 onto the stack
		ldarg.1					//push arg 2 onto the stack
		add					//add the values on the stack
		stsfld int32 Variables::myField		//store the result in myField
		ret					//return
	}

}