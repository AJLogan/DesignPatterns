using System;
using System.Collections.Generic;
using System.Dynamic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PlayingWithDynamicTypes {
    internal class Person : DynamicObject {
        public override bool TryGetMember(GetMemberBinder binder, out object result) {
            Console.WriteLine("\t\tTryGetMember called for {0}", binder.Name);
            if (binder.Name == "Salary") {
                result = wage;
                return true;
            }
            result = null;
            return false;
        }

        public override bool TrySetMember(SetMemberBinder binder, object value) {
            Console.WriteLine("\t\tTrySetMember called for {0}", binder.Name);
            if (binder.Name == "Salary") {
                wage = (double) value;
                return true;
            }
            return false;
        }

        public override bool TryInvokeMember(InvokeMemberBinder binder, object[] args, out object result) {
            Console.WriteLine("\t\tTryInvokeMember called for {0}", binder.Name);
            if (binder.Name == "AwardBonus") {
                wage += (double) args[0];
                result = wage;
                return true;
            }
            result = null;
            return false;
        }

        private double wage;
    }
}