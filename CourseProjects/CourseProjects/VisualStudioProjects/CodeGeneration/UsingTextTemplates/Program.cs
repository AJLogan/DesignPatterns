using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;

namespace UsingTextTemplates {
    public interface ITest {
        int Foo();
        DateTime Bar(float f);
        string Zed(string s, char c);
    }

    internal class Program {
        private static void Main(string[] args) {
            var generator = new MockGenerator(typeof (ITest));
            var result = generator.TransformText();
            System.IO.File.WriteAllText("MyMock.cs", result);
            Console.WriteLine(@"Template run - output should be in bin\debug");
        }
    }
}