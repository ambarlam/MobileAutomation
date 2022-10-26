package stepdefinitions;

import com.utils.Base;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	Base base;
	
	public Hooks(Base base) {
		this.base = base;
	}
	
	@Before
	public void setUp() {
		base.getAndroidDriverManager().getDriver();
	}
	
	@After
	public void tearDown() {
		base.getAndroidDriverManager().quitDriver();
	}
}
