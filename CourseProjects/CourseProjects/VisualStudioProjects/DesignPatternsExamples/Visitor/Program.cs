using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Visitor {
    internal class Program {
        private static void Main(string[] args) {
            Document doc = BuildDocument();

            IVisitor v1 = new HTMLFormatVisitor(File.Create(@"../../output/visitor.html"));
            doc.AcceptVisitor(v1);

            IVisitor v2 = new XMLFormatVisitor(File.Create(@"../../output/visitor.xml"));
            doc.AcceptVisitor(v2);

            Console.WriteLine("Reports generated");
        }

        private static Document BuildDocument() {
            var s1 = new Section(new Title("Section One"));
            s1.AddParagraph(new Paragraph("Paragraph One"));
            s1.AddParagraph(new Paragraph("Paragraph Two"));

            var s2 = new Section(new Title("Section Two"));
            s2.AddParagraph(new Paragraph("Paragraph Three"));
            s2.AddParagraph(new Paragraph("Paragraph Four"));

            var s3 = new Section(new Title("Section Three"));
            s3.AddParagraph(new Paragraph("Paragraph Five"));
            s3.AddParagraph(new Paragraph("Paragraph Six"));

            var s4 = new Section(new Title("Section Four"));
            s4.AddParagraph(new Paragraph("Paragraph Seven"));
            s4.AddParagraph(new Paragraph("Paragraph Eight"));

            var m1 = new Module();
            m1.AddSection(s1);
            m1.AddSection(s2);

            var m2 = new Module();
            m2.AddSection(s3);
            m2.AddSection(s4);

            var doc = new Document();
            doc.AddModule(m1);
            doc.AddModule(m2);
            return doc;
        }
    }
}