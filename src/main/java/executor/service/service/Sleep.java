package executor.service.service;

import executor.service.model.Step;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Sleep implements StepExecution {

    @Override
    public String getStepAction() {
        return "sleep";
    }

    @Override
    public void step(WebDriver webDriver, Step step) {
        try {
            long timeSleep = Long.parseLong(step.getValue());
            TimeUnit.SECONDS.sleep(timeSleep);
        } catch (InterruptedException e) {
            System.out.println("Interrupted exception: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Incorrect value in Step value: " + step.getValue());
        }
    }
}