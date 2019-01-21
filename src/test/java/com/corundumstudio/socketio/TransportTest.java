package com.corundumstudio.socketio;

import com.corundumstudio.socketio.Transport;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Assert;

public class TransportTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void byNameIllegalArgument() {
    final String value = "????";
    thrown.expect(IllegalArgumentException.class);
    Transport.byName(value);
  }

  @Test
  public void byNameWebSocket() {
    final String value = "websocket";
    final Transport retval = Transport.byName(value);
    Assert.assertEquals(Transport.WEBSOCKET, retval);
  }

  @Test
  public void byNamePolling() {
    final String value = "polling";
    final Transport retval = Transport.byName(value);
    Assert.assertEquals(Transport.POLLING, retval);
  }

  @Test
  public void values() {
    final Transport[] retval = Transport.values();
    Assert.assertArrayEquals(new Transport[] { Transport.WEBSOCKET, Transport.POLLING }, retval);
  }
}
