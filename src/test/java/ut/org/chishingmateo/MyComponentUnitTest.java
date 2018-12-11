package ut.org.chishingmateo;

import org.junit.Test;
import org.chishingmateo.api.MyPluginComponent;
import org.chishingmateo.impl.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}