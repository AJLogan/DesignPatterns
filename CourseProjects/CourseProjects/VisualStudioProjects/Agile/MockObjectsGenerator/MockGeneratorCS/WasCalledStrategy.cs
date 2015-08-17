using System;
using System.CodeDom;
using System.Reflection;

namespace MockGenerator {
	public class WasCalledStrategy : Strategy {
		public override void apply(CodeTypeDeclaration mock, Type target) {
			MethodInfo[] methods = target.GetMethods();
			foreach(MethodInfo m in methods) {
				addWasCalledFieldForMethod(m,mock);
			}
			CodeTypeMemberCollection mockMethods = mock.Members;
			foreach(CodeTypeMember member in mockMethods) {
				if(member is CodeMemberMethod) {
					CodeMemberMethod method = (CodeMemberMethod)member;
					method.Statements.Insert(0,buildStatementToSetWasCalledField(method.Name));
				}
			}
		}
		private void addWasCalledFieldForMethod(MethodInfo method, CodeTypeDeclaration klass) {
			string name = method.Name + "WasCalled";
			CodeMemberField wasCalled = new CodeMemberField(typeof(bool), name);
			wasCalled.Attributes = MemberAttributes.Public;
			klass.Members.Add(wasCalled);
		}
		private CodeAssignStatement buildStatementToSetWasCalledField(string methodName) {
			CodeFieldReferenceExpression fieldToSet = new CodeFieldReferenceExpression(new CodeThisReferenceExpression(), methodName + "WasCalled");
			CodePrimitiveExpression valueToSet = new CodePrimitiveExpression(true);
			return new CodeAssignStatement(fieldToSet,valueToSet);
		}
	}
}