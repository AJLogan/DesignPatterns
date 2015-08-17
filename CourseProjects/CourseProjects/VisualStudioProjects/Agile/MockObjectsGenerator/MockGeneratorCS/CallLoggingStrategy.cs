using System;
using System.CodeDom;
using System.Reflection;

namespace MockGenerator {
	public class CallLoggingStrategy : Strategy {
		public override void apply(CodeTypeDeclaration mock, Type target) {
			addCallLogField(mock);
			CodeTypeMemberCollection mockMethods = mock.Members;
			foreach(CodeTypeMember member in mockMethods) {
				if(member is CodeMemberMethod) {
					CodeMemberMethod method = (CodeMemberMethod)member;
					CodeMethodInvokeExpression invocation = buildExpressionToUpdateCallLog("#" + method.Name);
					method.Statements.Insert(0,new CodeExpressionStatement(invocation));
				}
			}
			addDefaultConstructor(mock);
		}
		private void addCallLogField(CodeTypeDeclaration klass) {
			CodeMemberField logField = new CodeMemberField(typeof(System.Text.StringBuilder), "callLog");
			logField.Attributes = MemberAttributes.Public;
			klass.Members.Add(logField);
		}
		private void addDefaultConstructor(CodeTypeDeclaration klass) {
			CodeConstructor constructor = new CodeConstructor();
			constructor.Attributes = MemberAttributes.Public;
			CodeFieldReferenceExpression targetField = new CodeFieldReferenceExpression(new CodeThisReferenceExpression(), "callLog");
			CodeObjectCreateExpression ctorCall = new CodeObjectCreateExpression(typeof(System.Text.StringBuilder),new CodeExpression[]{});
			constructor.Statements.Add(new CodeAssignStatement(targetField,ctorCall));
			klass.Members.Add(constructor);
		}
		private CodeMethodInvokeExpression buildExpressionToUpdateCallLog(string msg) {
			CodeFieldReferenceExpression targetField = new CodeFieldReferenceExpression(new CodeThisReferenceExpression(), "callLog");
			CodeExpression[] parameters = new CodeExpression[] { new CodePrimitiveExpression(msg) };
			return new CodeMethodInvokeExpression(targetField,"Append",parameters);
		}
	}
}