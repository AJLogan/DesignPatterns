using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Visitor {
    internal class Paragraph : IVisited {
        private readonly string text;

        public void AcceptVisitor(IVisitor v) {
            v.VisitParagraphStart(this);
            v.VisitParagraphEnd();
        }

        public Paragraph(string text) {
            this.text = text;
        }

        public override string ToString() {
            return text;
        }
    }
}