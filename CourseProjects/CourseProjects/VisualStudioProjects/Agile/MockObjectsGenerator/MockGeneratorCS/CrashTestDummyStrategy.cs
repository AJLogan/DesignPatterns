using System;
using System.CodeDom;

namespace MockGenerator {
	public class CrashTestDummyStrategy : Strategy {
		public override void apply(CodeTypeDeclaration mock, Type target) {
			CodeTypeMemberCollection mockMethods = mock.Members;
			foreach(CodeTypeMember member in mockMethods) {
				if(member is CodeMemberMethod) {
					CodeMemberMethod method = (CodeMemberMethod)member;
					CodeStatementCollection statements =  method.Statements;
					if(statements.Count > 0) {
						CodeStatement lastStatement = statements[statements.Count - 1];
						if(lastStatement is CodeMethodReturnStatement) {
							statements.Remove(lastStatement);
						}
					}
					CodeTypeReference typeToThrow = new CodeTypeReference(typeof(System.NotSupportedException));
					CodeObjectCreateExpression createExpression = new CodeObjectCreateExpression(typeToThrow,new CodeExpression[] {});
					CodeThrowExceptionStatement throwStatement = new CodeThrowExceptionStatement(createExpression);
					statements.Add(throwStatement);
				}
			}
		}
	}
}