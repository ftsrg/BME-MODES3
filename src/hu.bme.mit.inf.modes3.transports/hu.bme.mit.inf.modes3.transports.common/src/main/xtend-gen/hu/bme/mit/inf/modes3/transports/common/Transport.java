package hu.bme.mit.inf.modes3.transports.common;

import com.google.gson.Gson;
import java.util.List;

@SuppressWarnings("all")
public abstract class Transport {
  public List<String> getEndpoints() {
    Object _xblockexpression = null;
    {
      final Gson gson = new Gson();
      _xblockexpression = null;
    }
    return ((List<String>)_xblockexpression);
  }
}
