
using System;
using UsingTextTemplates;

public class ITestMock : ITest {
			public Int32 Foo() {
								return 0;
					}
			public DateTime Bar(Single f) {
								return new DateTime();
					}
			public String Zed(String s,Char c) {
								return new String();
					}
	}
