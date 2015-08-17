using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace MockingChallengeFinish {
    public interface IFlightPathDatabase {
        long FindFlightPath(string originAirport, string destinationAirport);
    }
}
