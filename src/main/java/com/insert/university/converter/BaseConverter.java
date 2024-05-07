package com.insert.university.converter;

import java.util.List;
import java.util.stream.Collectors;

public interface BaseConverter<E,D> {

    E convertDtoE(D d);

    D convertEtoD(E e);
    default List<E> convertDtoE(List<D> dList) {
        if (dList != null) {
            return dList.stream()
                    .map(this::convertDtoE)
                    .collect(Collectors.toList());
        }
        return null;
    }

    default List<D> convertEtoD(List<E> dList) {
        if (dList != null) {
            return dList.stream()
                    .map(this::convertEtoD)
                    .collect(Collectors.toList());
        }
        return null;
    }


}