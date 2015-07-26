package org.selenide.examples.twitter;

import com.codeborne.selenide.CollectionCondition;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;

public class UploadImageToPostTest {
  @Before
  public void login() {
    open("https://twitter.com");
    $$(".front-card .front-signin form.signin #signin-email").shouldHave(size(1));
    $(".front-card .front-signin form.signin #signin-email").val(System.getProperty("twitter.username", "enter-your-twitter-username"));
    $(".front-card .front-signin form.signin #signin-password").val(System.getProperty("twitter.password", "enter-your-twitter-password"));
    $(".front-card .front-signin form.signin .submit").click();
  }

  @Test
  public void canDragAndDropImageToPost() {
    $(".tweet-form .tweet-content .rich-editor").click();
    $(".tweet-form .toolbar .image-selector").find(By.name("media_empty")).sendKeys("/Users/andrei/Pictures/web.jpg");

    sleep(5000);
    // could add more checks/actions here
  }
}
