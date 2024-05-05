import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;


public class AppCardDeliveryTaskOneTest {

    private String generateDate(int addDays, String pattern){
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern(pattern));
    }

    @Test
    public void shouldBeSuccessfullyCompleted(){
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Рязань");
        String planningDate = generateDate(4, "dd.MM.yyyy");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $("[data-test-id='name'] input").setValue("Иванов-Иванович Иван");
        $("[data-test-id='phone'] input").setValue("+79005553535");
        $("[data-test-id='agreement']").click();
        $("button.button").click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Встреча успешно забронирована на " + planningDate));

    }
    @Test
    public void shouldBeSuccessfully(){
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Мо");
        $$(".menu-item__control").findBy(text("Москва")).click();
        String planningDate = generateDate(4, "dd.MM.yyyy");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $("[data-test-id='name'] input").setValue("Иванов-Иванович Иван");
        $("[data-test-id='phone'] input").setValue("+79005553535");
        $("[data-test-id='agreement']").click();
        $("button.button").click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Встреча успешно забронирована на " + planningDate));

    }
    @Test
    public void shouldBeSuccessf(){
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Рязань");
        String planningDate = generateDate(7, "dd.MM.yyyy");
        $("button.icon-button").click();
        //$("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        //$("[data-test-id='date'] input").setValue(planningDate);
        if (generateDate(3, "MM").equals(generateDate(7, "MM"))) {
         $$(".calendar__day").findBy(text(generateDate(7, "dd"))).click();
      } else {
          $("[class='calendar__arrow calendar__arrow_direction_right']").click();
            $$(".calendar__day").findBy(text(generateDate(7,"dd"))).click();
        }
        $("[data-test-id='name'] input").setValue("Иванов-Иванович Иван");
        $("[data-test-id='phone'] input").setValue("+79005553535");
        $("[data-test-id='agreement']").click();
        $("button.button").click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Встреча успешно забронирована на " + planningDate));

    }
}
