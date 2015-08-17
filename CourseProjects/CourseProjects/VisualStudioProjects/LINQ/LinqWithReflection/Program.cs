using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Reflection;

namespace LinqWithReflection {
    class Program {
        static void Main(string[] args) {
            string assemblyName = "System.Xml, Version=1.0.5000.0, Culture=Neutral, PublicKeyToken=b77a5c561934e089";
            Assembly assembly = AppDomain.CurrentDomain.Load(assemblyName);

            var result = from type in assembly.GetTypes()
                         where type.IsClass
                         where type.IsPublic
                         from method in type.GetMethods()
                         where method.Name.StartsWith("A")
                         where method.GetParameters().Length == 3
                         select new { className = type.Name, 
                                      methodName = method.Name, 
                                      parameters = method.GetParameters() };

            foreach(var item in result) {
                var builder = new StringBuilder();
                foreach(var p in item.parameters) {
                    builder.Append(p.Name);
                    builder.Append(",");
                }
                builder.Remove(builder.Length - 1,1);
                Console.WriteLine("{0}.{1}({2})",item.className,item.methodName,builder.ToString());
            }
        }
    }
}
