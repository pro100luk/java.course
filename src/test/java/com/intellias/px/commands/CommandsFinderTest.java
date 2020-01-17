package com.intellias.px.commands;

import com.intellias.px.dao.DaoFactory;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import java.lang.reflect.Method;

public class CommandsFinderTest {

    @Test
    public void shouldFindLoginCommand() {
        //init
        CommandsFinder commandsFinder = new CommandsFinder(PowerMockito.mock(DaoFactory.class));

        //execute logic
        Command loginCommand = commandsFinder.lookup("login");

        //verify
        Assert.assertEquals(LoginCommand.class, loginCommand.getClass());
    }

    @Test
    public void shouldFindRegisterCommand() {
        //execute logic
        Command register = CommandsFinder.lookup("register");
        Method lookupMethod = CommandsFinder.class.getMethod("lookup", String.class);
        Command invoke = (Command) lookupMethod.invoke(CommandsFinder, "register");


        //verify
        Assert.
    }
}
