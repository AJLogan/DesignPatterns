package demos.guava.functional;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class FunctionalConceptsDemo {
	public static void main(String[] args) {
		showApplyingPredicates();
		showFilteringInLists();
		showFilteringInMaps();
		showTransformingLists();
		showTransformingMaps();
		showComposingOperations();
		showFluentInterface();
	}
	private static void showFluentInterface() {
		List<String> input = Lists.newArrayList("abc","de","fgh","ij","klm","no","pqr","st","uvw");
		
		Predicate<String> p = new Predicate<String>() {
								public boolean apply(String str) {
									return str.length() == 3;
								}
							  };
		Function<String,String> f = new Function<String,String>() {
										public String apply(String str) {
											return str.toUpperCase();
										}
								    };					  
		Iterable<String> output = FluentIterable.from(input).filter(p).transform(f);
		
		System.out.println("Using fluent interface produces:");
		for(String s : output) {
			System.out.printf("\t%s\n", s);
		}
	}
	private static void showApplyingPredicates() {
		List<String> input = Lists.newArrayList("ab","cd","ef","GH","ij","KL","mn");
		
		System.out.println("Applying predicates produces:");
		
		if(Iterators.all(input.iterator(), new RegexPredicate("[A-Za-z]+"))) {
			System.out.println("\tAll strings contain letters only");
		} else {
			System.out.println("\tSome strings contain invalid characters!!");
		}
		
		if(Iterators.any(input.iterator(), new RegexPredicate(".*[A-Z]+.*"))) {
			System.out.println("\tSome strings contain uppercase letters");
		} else {
			System.out.println("\tNo strings contain uppercase letters");
		}
	}
	private static void showComposingOperations() {
		final DateFormat formatter1 = DateFormat.getDateInstance(DateFormat.SHORT,Locale.UK);
		final DateFormat formatter2 = DateFormat.getDateInstance(DateFormat.LONG,Locale.UK);
		
		Function<String,StringBuffer> f1 = new Function<String,StringBuffer>() {
												public StringBuffer apply(String str) {
													return new StringBuffer().append(str).append("/14");
												}
										   };
		Function<StringBuffer,Date> f2 = new Function<StringBuffer,Date>() {
												public Date apply(StringBuffer buffer) {
													try {
														return formatter1.parse(buffer.toString());
													} catch(ParseException ex) {
														return new Date();
													}
												}
										   };
		
		List<String> input = Lists.newArrayList("02/01","01/03","01/04","01/05","01/06","01/07","01/08");
		List<Date> output = Lists.transform(input, Functions.compose(f2, f1));
		
		System.out.println("Result of composite transformation is:");
		for(Date date : output) {
			System.out.printf("\t%s\n",formatter2.format(date));
		}
	}
	private static void showTransformingMaps() {
		Map<String,String> input = Maps.fromProperties(System.getProperties());
		Map<String,Setting> output = Maps.transformValues(input, new Function<String,Setting>(){
																	public Setting apply(String val) {
																		return new Setting(val);
																	}
																});
		System.out.println("Result of transforming Map is:");
		for(Map.Entry<String, Setting> entry : output.entrySet()) {
			System.out.printf("\t'%s' indexes '%s'\n", entry.getKey(), entry.getValue());
		}
	}
	private static void showTransformingLists() {
		List<String> input = Lists.newArrayList("Dave","Jane","Pete","Susan","Brian","Kate","Henry");
		List<Person> output = Lists.transform(input, new Function<String,Person>(){
														public Person apply(String name) {
															return new Person(name);
														}
													});
		System.out.println("Result of transforming List is:");
		for(Person p : output) {
			System.out.printf("\t%s\n", p);
		}
	}
	private static void showFilteringInMaps() {
		Map<String,String> input = Maps.fromProperties(System.getProperties());
		Map<String,String> output = Maps.filterKeys(input, new Predicate<String>() {
																public boolean apply(String str) {
																	return str.startsWith("java.vm");
																}
														  });
		System.out.println("Result of filtering Map is:");
		for(Map.Entry<String, String> entry : output.entrySet()) {
			System.out.printf("\t'%s' indexes '%s'\n", entry.getKey(), entry.getValue());
		}
	}
	private static void showFilteringInLists() {
		List<String> input = Lists.newArrayList("ab","cd","ef","gh","ij","kl","mn");
		Iterable<String> output = Iterables.filter(input, new Predicate<String>() {
															public boolean apply(String str) {
																return str.charAt(0) < 'k';
															}
							  						      });
		System.out.println("Result of filtering List is:");
		for(String s : output) {
			System.out.printf("\t%s\n", s);
		}
	}

}
