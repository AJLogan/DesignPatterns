using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Visitor
{
    interface IVisitor
    {
        void VisitDocumentStart(Document d);
        void VisitDocumentEnd();
        void VisitModuleStart(Module m);
        void VisitModuleEnd();
        void VisitSectionStart(Section s);
        void VisitSectionEnd();
        void VisitParagraphStart(Paragraph p);
        void VisitParagraphEnd();
        void VisitTitleStart(Title t);
        void VisitTitleEnd();
    }
}
