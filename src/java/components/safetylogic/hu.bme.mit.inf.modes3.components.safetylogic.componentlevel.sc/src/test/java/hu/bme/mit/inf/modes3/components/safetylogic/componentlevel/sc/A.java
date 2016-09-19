package hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc;

import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import hu.bme.mit.inf.modes3.safetylogic.sc.conf.LayoutConfiguration;

public class A {

	@Test
	public void test() {
		try (InputStreamReader isr = new InputStreamReader(A.class.getClassLoader().getResourceAsStream("conf/layout.json"))) {
			JsonReader reader = new JsonReader(isr);
			LayoutConfiguration result = new Gson().fromJson(reader, LayoutConfiguration.class);
			System.out.println(result.getComponents().size());
		} catch (IOException e) {
		}

		Assert.assertTrue(true);
	}

}
