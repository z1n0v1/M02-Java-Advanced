package L07Generics.Lab.T02GenericArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator<Type> {

    public static <Type> Type[] create(int length, Type item) {
        Type[] array = (Type[]) new Object[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = item;
        }
        return array;
    }

    public static <Type> Type[] create(Class<Type> cl, int length, Type item) {
        Type[] array = (Type[]) Array.newInstance(cl, length);

        for (int i = 0; i < array.length; i++) {
            array[i] = item;
        }
        return array;
    }
}
