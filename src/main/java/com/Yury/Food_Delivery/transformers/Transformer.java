package com.Yury.Food_Delivery.transformers;

public abstract class Transformer<T,E> {

    public abstract T transform(E e);

}
