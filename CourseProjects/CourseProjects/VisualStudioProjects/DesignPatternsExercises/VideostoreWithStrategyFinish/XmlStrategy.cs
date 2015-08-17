using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace VideostoreWithStrategyFinish
{
    public class XmlStrategy : Strategy
    {
        public override string Preamble
        {
            get { return "<rental>\n"; }
        }

        public override string Postscript
        {
            get { return "\t</rental>\n"; }
        }

        public override string FormatHeader(string header)
        {
            return string.Format("\t<header>{0}</header>\n", header);
        }

        public override string FormatRentalLine(string line)
        {
            return string.Format("\t<item>{0}</item>\n", line);
        }

        public override string FormatFooter(string footer)
        {
            return string.Format("\t<totals>{0}</totals>\n", footer);
        }
    }
}
