using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace VideostoreWithStrategyFinish {
    public class HtmlStrategy : Strategy {
        public override string Preamble {
            get { return "<html>\n\t<body>\n"; }
        }

        public override string Postscript {
            get { return "\t</body>\n</html>\n"; }
        }

        public override string FormatHeader(string header) {
            return string.Format("\t\t<h2>{0}</h2>\n", header);
        }

        public override string FormatRentalLine(string line) {
            return string.Format("\t\t<p>{0}</p>\n", line);
        }

        public override string FormatFooter(string footer) {
            return string.Format("\t\t<h3>{0}</h3>\n", footer);
        }
    }
}