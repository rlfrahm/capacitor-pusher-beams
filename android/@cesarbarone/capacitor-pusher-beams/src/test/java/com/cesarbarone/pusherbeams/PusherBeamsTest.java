package com.cesarbarone.pusherbeams;

import com.getcapacitor.JSObject;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PusherBeamsTest {

    @Test
    public void hashMapOf() {
        JSObject headers = mock(JSObject.class);
        Iterator<String> iterator = mock(Iterator.class);

        when(headers.getString("Authorization")).thenReturn("Bearer 123321");
        when(headers.keys()).thenReturn(iterator);
        when(iterator.hasNext()).thenReturn(true,false);
        when(iterator.next()).thenReturn("Authorization");


        HashMap<String, String> hashMap = PusherBeams.hashMapOf(headers);
        assertEquals("Bearer 123321", hashMap.get("Authorization"));
    }
}