package services;

public abstract class Service<T> {
    public abstract T[] findProductAll();
    public abstract boolean deleteProduct(int id);
}
