package com.intellias.px.commands;

import com.intellias.px.annotations.CommandId;
import com.intellias.px.dao.DaoFactory;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class CommandsFinder {
    private  DaoFactory daoFactory;

    public CommandsFinder(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public Command lookup(String id) {
        Reflections reflections = new Reflections("com.intellias.px");
        Set<Class<?>> typesAnnotadedWithCommandId = reflections.getTypesAnnotatedWith(CommandId.class);

        List<Class<?>> foundCommands = typesAnnotadedWithCommandId.stream()
                .filter(aClass -> aClass.getAnnotation(CommandId.class).value().equals(id))
                .filter(aClass -> Command.class.isAssignableFrom(aClass))
                .collect(Collectors.toList());

        if (foundCommands.size() !=1){
            throw new IllegalStateException("My message");
        }
        Class<?> commandClass = foundCommands.get(0);

        Constructor<?>[] constructors = commandClass.getConstructors();

        Optional<Constructor<?>> maybeConstructorWithDaoFactory = Arrays.stream(constructors)
                .filter(constructor -> constructor.getParameterTypes().length == 1)
                .filter(constructor -> constructor.getParameterTypes()[0].isAssignableFrom(DaoFactory.class))
                .findFirst();

        if (maybeConstructorWithDaoFactory.isPresent()) {
            Constructor<?> constructor = maybeConstructorWithDaoFactory.get();
            return (Command) constructor.newInstance(daoFactory);
        } else {
            Arrays.stream(constructors)
                    .filter(constructor -> constructor.getParameterTypes().length ==0)
                    .findFirst()
                    .orElseThrow()
        }


        return  new LoginCommand(daoFactory);
    }
}
