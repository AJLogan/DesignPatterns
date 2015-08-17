using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Visitor {
    internal class HTMLFormatVisitor : IVisitor {
        private readonly StreamWriter output;

        public HTMLFormatVisitor(FileStream w) {
            output = new StreamWriter(w);
        }

        public void VisitDocumentStart(Document d) {
            Write("<html><head/><body>");
        }

        public void VisitDocumentEnd() {
            Write("</body></html>");
            CloseOutput();
        }

        public void VisitModuleStart(Module m) {
            Write("<h2>New Module</h2>");
        }

        public void VisitModuleEnd() {}

        public void VisitParagraphStart(Paragraph p) {
            Write("<p>" + p + "</p>");
        }

        public void VisitParagraphEnd() {}

        public void VisitSectionStart(Section s) {
            Write("<h3>New Section</h3>");
        }

        public void VisitSectionEnd() {}

        public void VisitTitleStart(Title title) {
            Write("<h4>" + title + "</h4>");
        }

        public void VisitTitleEnd() {}

        private void Write(String text) {
            output.Write(text);
            output.WriteLine();
        }

        private void CloseOutput() {
            output.Close();
        }
    }
}