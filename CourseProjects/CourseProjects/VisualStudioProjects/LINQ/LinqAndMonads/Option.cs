using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace LinqAndMonads {
    public abstract class Option<T> {
        public abstract bool Worked { get; }
        public abstract T Value { get; }
    }
    public class None<T> : Option<T> {
        public override bool Worked { get { return false; } }
        public override T Value { get { return default(T); } }
    }
    public class Some<T> : Option<T> {
        public override bool Worked { get { return true; } }
        public override T Value { get { return value; } }
        public Some(T value) {
            this.value = value;
        }
        private T value;
    }
}
