using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Visitor {
    internal class XMLFormatVisitor : IVisitor {
        private readonly StreamWriter output;

        public XMLFormatVisitor(FileStream fs) {
            output = new StreamWriter(fs);
        }

        public void VisitDocumentStart(Document d) {
            Write("<document>");
        }

        public void VisitDocumentEnd() {
            Write("</document>");
            CloseOutput();
        }

        public void VisitModuleStart(Module m) {
            Write("<module>");
        }

        public void VisitModuleEnd() {
            Write("</module>");
        }

        public void VisitParagraphStart(Paragraph p) {
            Write("<paragraph>");
            Write(p.ToString());
        }

        public void VisitParagraphEnd() {
            Write("</paragraph>");
        }

        public void VisitSectionStart(Section s) {
            Write("<section>");
        }

        public void VisitSectionEnd() {
            Write("</section>");
        }

        public void VisitTitleStart(Title title) {
            Write("<title>");
            Write(title.ToString());
        }

        public void VisitTitleEnd() {
            Write("</title>");
        }

        private void Write(string text) {
            output.Write(text);
            output.WriteLine();
        }

        private void CloseOutput() {
            output.Close();
        }
    }
}