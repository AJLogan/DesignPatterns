using System;

namespace XPathQuiz {
	public class Solutions {
		public static readonly string Q1 = "//b";
		public static readonly string Q2 = "/*";
		public static readonly string Q3 = "/*/*[1]";	
		public static readonly string Q4 = "/*/*[last()]";
		public static readonly string Q5 = ".//d";
		public static readonly string Q6 = "//b/..";
		public static readonly string Q7 = "(//c)[last()]";
		public static readonly string Q8 = "//comment()/..";
		public static readonly string Q9 = ".";
		public static readonly string Q10 = "..";
		public static readonly string Q11 = "following-sibling::*[1]";
		public static readonly string Q12 = "preceding-sibling::*[1]";
		public static readonly string Q13 = "*";
		public static readonly string Q14 = "descendant::*[@id > 11]";
		public static readonly string Q15 = "* | /*/*";
		public static readonly string Q16 = "//*[not(self::a)][not(self::b)][not(self::c)][not(self::d)]";
		//public static readonly string Q16 = "//*[local-name() != 'a'][local-name() != 'b'][local-name() != 'c'][local-name() != 'd']";
		public static readonly string Q17 = "(//b[@id > '15'])[1]";
		public static readonly string Q18 = "//processing-instruction()/..";
		public static readonly string Q19 = "//processing-instruction('p2')/..";
		public static readonly string Q20 = "preceding-sibling::b | following-sibling::b";
		public static readonly string Q21 = "/descendant::c[5]";
		public static readonly string Q22 = "descendant::*[@att][count(*) = 0]";
		public static readonly string Q23 = "following-sibling::*[last()]";
		public static readonly string Q24 = "preceding-sibling::*[last()]";
		public static readonly string Q25 = "*/*[2] | */*[4]";
		public static readonly string Q26 = "ancestor::*[3]";
		public static readonly string Q27 = "//c[child::d]";
		public static readonly string Q28 = "//*[count(*) > '2' ]";
		public static readonly string Q29 = "descendant::*[@att][1]";
		public static readonly string Q30 = "//*[count(node()) = '0']";
		public static readonly string Q31 = "//*[text()]/preceding-sibling::*[1]";
	}
}
