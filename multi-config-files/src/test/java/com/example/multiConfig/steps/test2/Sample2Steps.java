package com.example.multiConfig.steps.test2;

import com.example.multiConfig.steps.SampleTestContext;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import mappers.DateMapper;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;


@ContextConfiguration(classes = {Sample2TestConfig.class})
public class Sample2Steps {
    SampleTestContext sampleTest2Context;

    @Value("${inputText}")
    private String inputText;

    public Sample2Steps(SampleTestContext sampleTest2Context) {
        this.sampleTest2Context = sampleTest2Context;
    }

    @Then("^output OK2$")
    public void output_OK2() {
        Assert.assertEquals(sampleTest2Context.getSampleService().get(), inputText);
    }


    @Given("^mock PM get interactions (.*)$")
    public void mockPmGetInteractionsInTheDateRange(@Transform(DateMapper.class) LocalDate myDate) throws Throwable {
        System.out.println("myDate=" + myDate);
    }

}
