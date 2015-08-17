using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace LinqAndMonads {
    public static class MonadOperations {
        public static Option<T> ToOption<T>(this T value) {
            return new Some<T>(value);
        }
        public static Option<U> Bind<T, U>(this Option<T> a, Func<T, Option<U>> func) {
            if (a is Some<T>) {
                return func((a as Some<T>).Value);
            }
            else {
                return new None<U>();
            }
        }
        public static Option<V> SelectMany<T, U, V>(this Option<T> theOption, Func<T, Option<U>> func, Func<T, U, V> select) {
            return theOption.Bind(first => func(first).Bind(second => select(first, second).ToOption()));
        }
    }
}
