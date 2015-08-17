using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Visitor {
    internal class Title : IVisited {
        private readonly string text;

        public void AcceptVisitor(IVisitor v) {
            v.VisitTitleStart(this);
            v.VisitTitleEnd();
        }

        public Title(String text) {
            this.text = text;
        }

        public override string ToString() {
            return text;
        }
    }
}