package demos.guava.functional;

import com.google.common.base.Predicate;

class RegexPredicate implements Predicate<String> {
	public RegexPredicate(String pattern) {
		this.pattern = pattern;
	}
	public boolean apply(String str) {
		return str.matches(pattern);
	}
	private String pattern;
}
