using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Visitor {
    internal class Section : IVisited {
        private readonly Title title;
        private readonly List<Paragraph> paragraphs = new List<Paragraph>();

        public void AcceptVisitor(IVisitor v) {
            v.VisitSectionStart(this);
            title.AcceptVisitor(v);
            foreach (var p in paragraphs) {
                p.AcceptVisitor(v);
            }
            v.VisitSectionEnd();
        }

        public Section(Title title) {
            this.title = title;
        }

        public void AddParagraph(Paragraph p) {
            paragraphs.Add(p);
        }
    }
}