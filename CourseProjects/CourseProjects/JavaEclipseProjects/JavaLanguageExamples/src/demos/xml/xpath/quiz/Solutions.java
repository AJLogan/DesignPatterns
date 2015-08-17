package demos.xml.xpath.quiz;

public class Solutions {
	public static final String Q1 = "//b";
	public static final String Q2 = "/*";
	public static final String Q3 = "/*/*[1]";	
	public static final String Q4 = "/*/*[last()]";
	public static final String Q5 = ".//d";
	public static final String Q6 = "//b/..";
	public static final String Q7 = "(//c)[last()]";
	public static final String Q8 = "//comment()/..";
	public static final String Q9 = ".";
	public static final String Q10 = "..";
	public static final String Q11 = "following-sibling::*[1]";
	public static final String Q12 = "preceding-sibling::*[1]";
	public static final String Q13 = "*";
	public static final String Q14 = "descendant::*[@id > 11]";
	public static final String Q15 = "* | /*/*";
	public static final String Q16 = "//*[not(self::a)][not(self::b)][not(self::c)][not(self::d)]";
	//public static final String Q16 = "//*[local-name() != 'a'][local-name() != 'b'][local-name() != 'c'][local-name() != 'd']";
	public static final String Q17 = "(//b[@id > '15'])[1]";
	public static final String Q18 = "//processing-instruction()/..";
	public static final String Q19 = "//processing-instruction('p2')/..";
	public static final String Q20 = "preceding-sibling::b | following-sibling::b";
	public static final String Q21 = "/descendant::c[5]";
	public static final String Q22 = "descendant::*[@att][count(*) = 0]";
	public static final String Q23 = "following-sibling::*[last()]";
	public static final String Q24 = "preceding-sibling::*[last()]";
	public static final String Q25 = "*/*[2] | */*[4]";
	public static final String Q26 = "ancestor::*[3]";
	public static final String Q27 = "//c[child::d]";
	public static final String Q28 = "//*[count(*) > '2' ]";
	public static final String Q29 = "descendant::*[@att][1]";
	public static final String Q30 = "//*[count(node()) = '0']";
	public static final String Q31 = "//*[text()]/preceding-sibling::*[1]";
}
