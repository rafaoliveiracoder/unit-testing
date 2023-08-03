package com.in28minutes.unittesting.unittesting.business;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {

    List<String> mock = mock(List.class);

    @Test
    public void size_basic() {
        when(mock.size()).thenReturn(5);
        assertEquals(5, mock.size());
    }

    @Test
    public void returnDifferentValues() {
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    public void returnWithParameters() {
        when(mock.get(anyInt())).thenReturn("in28minutes");
        assertEquals("in28minutes", mock.get(0));
        assertEquals("in28minutes", mock.get(1));
    }

    @Test
    public void verificationBasics(){
        String value1 = mock.get(0);
        String value2 = mock.get(1);
        String value3 = mock.get(3);
        verify(mock).get(0);
        verify(mock).get(1);
        verify(mock, times(3)).get(anyInt());
        verify(mock, atLeastOnce()).get(anyInt());
    }

    @Test
    public void multipleArgumentCapturing(){
        mock.add("SomeString1");
        mock.add("SomeString2");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        verify(mock,times(2)).add(captor.capture());

        List<String> allValues = captor.getAllValues();

        assertEquals("SomeString1", allValues.get(0));
        assertEquals("SomeString2", allValues.get(1));
    }

    @Test
    public void mocking(){
        ArrayList arrayListSpy = mock(ArrayList.class);
        arrayListSpy.get(0);
        arrayListSpy.size();
        arrayListSpy.add("test");
        arrayListSpy.add("test2");
        arrayListSpy.size();
        when(arrayListSpy.size()).thenReturn(5);
        arrayListSpy.size();

    }

    @Test
    public void spying(){
        ArrayList arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("test0");
        arrayListSpy.get(0);
        arrayListSpy.size();
        arrayListSpy.add("test");
        arrayListSpy.add("test2");
        arrayListSpy.size();
        when(arrayListSpy.size()).thenReturn(5);
        arrayListSpy.size();
        verify(arrayListSpy).add("test2");
    }
}
