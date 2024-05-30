package com.Platform.Courses.infrastructure.helpers;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.BeanUtils;

public class EntityToEntity {

    public static <FROMENTITY, TOENTITY> TOENTITY entityToEntity(FROMENTITY fromEntity, Class<TOENTITY> toEntity) {
        Constructor<TOENTITY> constructor;
        TOENTITY entity;
        try {
            constructor = toEntity.getDeclaredConstructor();
            entity = constructor.newInstance();
            BeanUtils.copyProperties(fromEntity, entity);
            return entity;
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        return null;
    }

}
