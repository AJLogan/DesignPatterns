using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace VideostoreWithStateFinish {
    public abstract class MovieType {
        public abstract double Cost(int days);

        public virtual bool EarnsExtraPoints {
            get { return false; }
        }

        public virtual int ExtraPoints(int days) {
            throw new InvalidOperationException("Not eligable");
        }
    }

    public class ChildrensMovieType : MovieType {
        public override double Cost(int days) {
            var cost = 1.5;
            if (days > 3) {
                cost += (days - 3)*1.5;
            }
            return cost;
        }
    }

    public class RegularMovieType : MovieType {
        public override double Cost(int days) {
            var cost = 2.0;
            if (days > 2) {
                cost += (days - 2)*1.5;
            }
            return cost;
        }
    }

    public class NewReleaseMovieType : MovieType {
        public override double Cost(int days) {
            return days*3;
        }

        public override bool EarnsExtraPoints {
            get { return true; }
        }

        public override int ExtraPoints(int days) {
            return (days > 1) ? 1 : 0;
        }
    }
}