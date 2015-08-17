using System;
using System.CodeDom;

namespace MockGenerator {
	public abstract class Strategy {
		public abstract void apply(CodeTypeDeclaration mock, Type target);
	}
}