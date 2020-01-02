
import com.example.demo.auth.base.BaseController;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseControllerTests {

    private BaseController baseController;
    private HttpSession session;



/*This test will pass if the ModelandView object returned by the home() method in the Base Controller is not empty when
the method is called */

    @Test
    public void whenMethodIsCalledObjectIsNotEmpty() {
        baseController = new BaseController();
        ModelAndView result = baseController.home(session);
        assertEquals(result.isEmpty(), false);
    }

    //This test will pass if the correct View is set by the home() method

    @Test
    public void whenMethodIsCalledCorrectViewIsSet() {
        baseController = new BaseController();
        String result = baseController.home(session).getViewName();
        assertEquals(result, "loginTemplate");
    }

    //This test will pass if the correct String is returned and therefore the user is redirected correctly to the eventpage.
    @Test
    public void whenEventPageMethodRunsUserIsRedirectedToEventPage(){
        baseController = new BaseController();
        String result = baseController.eventPage();
        assertEquals(result, "eventPage");
    }



}



