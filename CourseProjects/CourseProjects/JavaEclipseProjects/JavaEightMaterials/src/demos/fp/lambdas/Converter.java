package demos.fp.lambdas;

@FunctionalInterface
public interface Converter<T,U> {
    public U convert(T input);
}
