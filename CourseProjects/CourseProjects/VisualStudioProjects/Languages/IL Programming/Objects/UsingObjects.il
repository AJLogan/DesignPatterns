.assembly extern mscorlib {}
.assembly UsingObjects {}

.class public auto ansi Test extends [mscorlib]System.Object {
	.method public static void FooBar() il managed {
		//entry point declaration (one per assembly)
		.entrypoint
		//declare three local variables
		.locals init ([0] class [mscorlib]System.Text.StringBuilder obj,
			 	[1] string str1, [2] string str2)
		//create a new instance of the StringBuilder class
		newobj instance void [mscorlib]System.Text.StringBuilder::.ctor()
		//store the object reference into a local variable
		stloc obj
		//ask the user to enter a string
		ldstr "Enter the first string"
		call void [mscorlib]System.Console::WriteLine(string)
		//read in the string and store it in a local variable
		call string [mscorlib]System.Console::ReadLine()
		stloc str1
		//ask the user to enter a string
		ldstr "Enter the second string"
		call void [mscorlib]System.Console::WriteLine(string)
		//read in the string and store it in a local variable
		call string [mscorlib]System.Console::ReadLine()
		stloc str2
		//push the reference to the StringBuilder
		ldloc.0
		//push the first string to be appended
		ldloc.1
		//call the Append method
		call instance class [mscorlib]System.Text.StringBuilder
			[mscorlib]System.Text.StringBuilder::Append(string)
		//push the second string to be appended
		ldloc.2
		//call the Append method
		call instance class [mscorlib]System.Text.StringBuilder 
			[mscorlib]System.Text.StringBuilder::Append(string)
		//convert the builder to a string
		callvirt string 
			[mscorlib]System.Text.StringBuilder::ToString()
		//print the result
		call void [mscorlib]System.Console::WriteLine(object)
		ret
	}

}