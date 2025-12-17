package tests;

import org.testng.annotations.Test;

import utilities.ScreenshotUtil;

public class DummyTest {
	
	@Test
	public void demoScreenshotTest() {
	    ScreenshotUtil.takeScreenshot("DemoFailTest");
	}

}
