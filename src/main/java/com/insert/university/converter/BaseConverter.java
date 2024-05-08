package com.insert.university.converter;

import com.insert.university.common.TeacherDto;
import com.insert.university.model.entities.TeacherEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

public class BaseConverter<E,D> {

     public  E convertDtoE(D d) {return null;}


    public  D convertEtoD(E e){return null;}



     List<E> convertDtoE(List<D> dList) {
        if (dList != null) {
            return dList.stream()
                    .map(this::convertDtoE)
                    .collect(Collectors.toList());
        }
        return null;
    }

     List<D> convertEtoD(List<E> dList) {
        if (dList != null) {
            return dList.stream()
                    .map(this::convertEtoD)
                    .collect(Collectors.toList());
        }
        return null;

    }
}