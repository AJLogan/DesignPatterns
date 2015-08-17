using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Visitor {
    internal class Module : IVisited {
        private readonly List<Section> sections = new List<Section>();

        public void AcceptVisitor(IVisitor v) {
            v.VisitModuleStart(this);
            foreach (var s in sections) {
                s.AcceptVisitor(v);
            }
            v.VisitModuleEnd();
        }

        public void AddSection(Section s) {
            sections.Add(s);
        }
    }
}