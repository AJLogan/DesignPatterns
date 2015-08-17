using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Visitor {
    internal class Document : IVisited {
        private readonly List<Module> modules = new List<Module>();

        public void AcceptVisitor(IVisitor v) {
            v.VisitDocumentStart(this);
            foreach (var m in modules) {
                m.AcceptVisitor(v);
            }
            v.VisitDocumentEnd();
        }

        public void AddModule(Module m) {
            modules.Add(m);
        }
    }
}