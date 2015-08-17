using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace MockingChallengeFinish {
    class TravelAllowanceCalculator {
        private readonly long MAX_DISTANCE_OF_LOCAL_FLIGHT = 200;
	
	    public TravelAllowanceCalculator(IFlightConcessionsEngine concessionsEngine, 
						  			     IFlightPathDatabase pathDatabase) {
		    this.concessionsEngine = concessionsEngine;
		    this.pathDatabase = pathDatabase;
	    }
        public double CalculateAllowance(params Flight[] flights) {
		    double allowance = 0; 
		
		    foreach(Flight flight in flights) {
			    long distance = pathDatabase.FindFlightPath(flight.Origin,
														    flight.Destination);
			    switch(flight.Seating) {
	            case Seating.FIRST:
	                if(FlightIsLocal(distance)) {
	                    allowance += distance * 0.10;
	                } else {
	                    allowance += distance * 0.20;
	                }
	                break;
                case Seating.BUSINESS:
	                if(FlightIsLocal(distance)) {
	                    allowance += distance * 0.30;
	                } else {
	                    allowance += distance * 0.40;
	                }
	                break;
                case Seating.ECONOMY:
	                if(FlightIsLocal(distance)) {
	                    allowance += distance * 0.50;
	                } else {
	                    allowance += distance * 0.60;
	                }
	                break;
		         }
		    }
		    if(concessionsEngine.AdditionalBenefitApplies(flights.Length,allowance)) {
			    allowance += concessionsEngine.CalculateBenefit(flights.Length,allowance);
		    }
		    return allowance;
	    }
	    private bool FlightIsLocal(long distance) {
		    return distance <= MAX_DISTANCE_OF_LOCAL_FLIGHT;
	    }
	    private IFlightPathDatabase pathDatabase;
	    private IFlightConcessionsEngine concessionsEngine;
    }
}
