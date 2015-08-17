using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConstraintsOnGenerics {
    class MyClass {
    }
    class MyDerived : MyClass {
        MyDerived(string str){
        }
    }
    struct MyStruct {
    }
    class PairA<T, U> {
        public T first;
        public U second;
    }
    class PairB<T, U> 
        where T : class 
        where U : struct {

        public T first;
        public U second;
    }
    class PairC<T, U>
        where T : MyClass {

        public T first;
        public U second;
    }
    class PairD<T, U>
        where T : new() {

        public PairD() {
            first = new T();
            //Will not compile
            //second = new U();
        }
        private T first;
        private U second;
    }
    class Program {
        static void Main(string[] args) {
            PairA<MyClass, MyStruct> obj1 = new PairA<MyClass, MyStruct>();
            PairB<MyClass, MyStruct> obj2 = new PairB<MyClass, MyStruct>();
            //Will not compile
            //PairB<MyStruct,MyClass> obj3 = new PairB<MyStruct,MyClass>();
            PairC<MyClass, MyStruct> obj4 = new PairC<MyClass, MyStruct>();
            PairC<MyDerived, MyStruct> obj5 = new PairC<MyDerived, MyStruct>();
            //Will not compile
            //PairC<string, MyStruct> obj6 = new PairC<MyClass, MyStruct>();
            PairD<MyClass, MyStruct> obj7 = new PairD<MyClass, MyStruct>();
            //Will not compile
            //PairD<MyDerived, MyStruct> obj8 = new PairD<MyDerived, MyStruct>();
        }
    }
}
