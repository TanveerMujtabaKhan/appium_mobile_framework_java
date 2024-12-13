package com.automate.reports;

import com.automate.enums.ConfigProperties;
import com.automate.utils.configloader.PropertyUtils;
import com.automate.utils.screenshot.ScreenshotService;
import com.automate.utils.screenshot.ScreenshotUtils;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.IOException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ExtentReportLogger {

  public static void logPass(String message) {
    if (PropertyUtils.getPropertyValue(ConfigProperties.PASSED_STEP_SCREENSHOTS).equalsIgnoreCase("yes")) {
      ExtentReportManager.getExtentTest().pass(message,
                                               MediaEntityBuilder.createScreenCaptureFromBase64String(
                                                 ScreenshotService.getScreenshotAsBase64()).build());
    } else {
      ExtentReportManager.getExtentTest().pass(MarkupHelper.createLabel(message, ExtentColor.GREEN));
    }
  }

//  public static void logFail(String message, Throwable t) {
//    if (PropertyUtils.getPropertyValue(ConfigProperties.FAILED_STEP_SCREENSHOTS).equalsIgnoreCase("yes")) {
//      ExtentReportManager.getExtentTest().fail(MarkupHelper.createLabel(message, ExtentColor.RED))
//        .fail(MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotService.getScreenshotAsBase64()).build())
//        .fail(t);
//    } else {
//      ExtentReportManager.getExtentTest().fail(message).fail(t);
//    }
//  }

  public static void logFail(String message, Throwable t) {
    // Check if screenshots should be taken for failed steps
    if (PropertyUtils.getPropertyValue(ConfigProperties.FAILED_STEP_SCREENSHOTS).equalsIgnoreCase("yes")) {

      // Get the test name (you can modify this to capture the actual test name dynamically)
      String testName = "exampleTest";  // Replace with dynamic test name if necessary

      // Capture the screenshot as a file
      ScreenshotUtils.captureScreenshotAsFile(testName);

      // Screenshot file path
      String screenshotFilePath = "extent-test-report/" + testName + ".png";

      // Attach screenshot file and log failure message
      ExtentReportManager.getExtentTest().fail(MarkupHelper.createLabel(message, ExtentColor.RED))
        .fail(MediaEntityBuilder.createScreenCaptureFromPath(screenshotFilePath).build())
        .fail(t);
    } else {
      // If no screenshot needed, just log the failure message
      ExtentReportManager.getExtentTest().fail(message).fail(t);
    }
  }

  public static void logSkip(String message) {
    if (PropertyUtils.getPropertyValue(ConfigProperties.SKIPPED_STEP_SCREENSHOTS).equalsIgnoreCase("yes")) {
      ExtentReportManager.getExtentTest().skip(message,
                                               MediaEntityBuilder.createScreenCaptureFromBase64String(
                                                 ScreenshotService.getScreenshotAsBase64()).build());
    } else {
      ExtentReportManager.getExtentTest().log(Status.SKIP, message);
    }
  }

  public static void logInfo(String message) {
    ExtentReportManager.getExtentTest().log(Status.INFO, message);
  }

  public static void warning(String message) {
    ExtentReportManager.getExtentTest().log(Status.WARNING, message);
  }
}
