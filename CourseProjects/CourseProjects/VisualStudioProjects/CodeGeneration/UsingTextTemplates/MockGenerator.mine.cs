using System;
using System.Reflection;
using System.Text;

namespace UsingTextTemplates {
    partial class MockGenerator {
        public MockGenerator(Type t) {
            typeToBeMocked = t;
        }
        private string BuildParamsString(MethodInfo mi) {
            if (mi.GetParameters().Length > 0) {
                var sb = new StringBuilder();
                foreach (var param in mi.GetParameters()) {
                    sb.Append(param.ParameterType.Name);
                    sb.Append(" ");
                    sb.Append(param.Name);
                    sb.Append(",");
                }
                sb.Remove(sb.Length - 1, 1);
                return sb.ToString();
            }
            return "";
        }

        private Type typeToBeMocked;
    }
}