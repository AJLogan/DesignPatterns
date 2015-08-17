using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace VideostoreWithStrategyFinish {
    public abstract class Strategy {
        public abstract string Preamble { get; }
        public abstract string Postscript { get; }
        public abstract string FormatHeader(string header);
        public abstract string FormatRentalLine(string line);
        public abstract string FormatFooter(string footer);
    }
}