package sauce.demo.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import sauce.demo.factory.DriverFactory;

public class ScreenshotUtils {

	public static String takeScreenshot(String scenarioName) {

        String timestamp =
                new SimpleDateFormat("yyyyMMdd_HHmmss")
                        .format(new Date());

        String fileName =
                scenarioName + "_" + timestamp + ".png";

        String folder =
                "target/screenshots/";

        Path directory =
                Paths.get(folder);

        try {

            Files.createDirectories(directory);

        } catch (IOException e) {

            e.printStackTrace();
        }

        File source =
                ((TakesScreenshot) DriverFactory.getDriver())
                        .getScreenshotAs(OutputType.FILE);

        Path destination =
                Paths.get(folder + fileName);

        try {

            Files.copy(
                    source.toPath(),
                    destination
            );

        } catch (IOException e) {

            e.printStackTrace();
        }

        return destination.toString();
    }
}
