package com.automate.utils.screenshot;

import com.automate.constants.FrameworkConstants;
import com.automate.driver.manager.DriverManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ScreenshotUtils {

  // This class is to handle the change in third party library
  @SneakyThrows
  public static void captureScreenshotAsFile(String testName) {
    String screenshotDirectory = "extent-test-report";
    File directory = new File(screenshotDirectory);
    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    File source = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
    File destination = new File(screenshotDirectory + File.separator + testName + "_" + timestamp + ".png"); FileUtils.copyFile(source, destination);
  }

  public static String captureScreenshotAsBase64() {
    return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
  }
}
