using System;

namespace Iterator {
    public class ListEmptyException : Exception {
        public ListEmptyException(string msg) : base(msg) {}
    }
}