using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace MockingChallengeFinish {
    public interface IFlightConcessionsEngine {
        bool AdditionalBenefitApplies(int numFlights, double totalCost);
        double CalculateBenefit(int numFlights, double totalCost);
    }
}
