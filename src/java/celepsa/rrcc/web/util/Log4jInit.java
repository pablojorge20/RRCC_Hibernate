package celepsa.rrcc.web.util;


import java.util.Properties;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.PropertyConfigurator;

public class Log4jInit extends HttpServlet {

    @Override
    public void init() {
        String prefix =  getServletContext().getRealPath("/");
        String file = getInitParameter("log4j-init-file");
        // if the log4j-init-file is not set, then no point in trying
        if(file != null) 
        {
            PropertyConfigurator.configure(prefix+file);
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) {
    }
}