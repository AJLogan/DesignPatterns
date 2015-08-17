using System;
namespace NormalDelegates {
    public class TestTwo {
        public TestTwo(int val) {
            this.val = val;
        }
        public double multiply(int i) {
            return val*i;
        }
        public double divide(int i) {
            return val/(double) i;
        }
        private int val;
    }
}