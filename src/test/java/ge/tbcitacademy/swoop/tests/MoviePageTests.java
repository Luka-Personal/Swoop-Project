package ge.tbcitacademy.swoop.tests;
import ge.tbcitacademy.swoop.steps.LandingPageSteps;
import ge.tbcitacademy.swoop.steps.LoginPageSteps;
import ge.tbcitacademy.swoop.steps.MoviesPageSteps;
import ge.tbcitacademy.swoop.steps.RegisterPageSteps;
import ge.tbcitacademy.swoop.tests.config.WebDriverFactory;
import org.testng.annotations.Test;
import static ge.tbcitacademy.swoop.data.Constants.*;

public class MoviePageTests extends WebDriverFactory {
    @Test
    public void cinemaAndRegisterTest() {
        LandingPageSteps landingPageSteps = new LandingPageSteps(driver);
        MoviesPageSteps moviesPageSteps = landingPageSteps.clickMovieButton();
        moviesPageSteps.hoverFirstMovie();
        moviesPageSteps.clickBuyButton();
        moviesPageSteps.scrollIntoViewAndClick(CINEMA_NAME);
        moviesPageSteps.setEsatPointSeances();
        softAssert.assertTrue(moviesPageSteps.validateIsAllCaveaSeances(CINEMA_NAME), CAVEA_SEANCES_VALIDATION_ERROR);
        moviesPageSteps.openVeryLastSeance();
        moviesPageSteps.assertPopUpInfo(softAssert);
        LoginPageSteps loginPageSteps = moviesPageSteps.clickFreeSeat();
        RegisterPageSteps registerPageSteps = loginPageSteps.clickRegisterButton();
        registerPageSteps.fillRegistrationData();
        softAssert.assertEquals(registerPageSteps.returnInvalidEmailPageMsg(), EXPECTED_EMAIL_ERROR_MSG, EMAIL_ERROR_MISMATCH_MSG);
        softAssert.assertAll();
    }
}
