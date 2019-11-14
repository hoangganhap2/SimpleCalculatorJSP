import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet",urlPatterns = "/calculate")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float firstOperand = Integer.parseInt(request.getParameter("first-operand"));
        float secondOperand = Integer.parseInt(request.getParameter("second-operand"));
        char operator = request.getParameter("operator").charAt(0);

//        PrintWriter writer = response.getWriter();
//        writer.println("<html>");
//        writer.println("<h1>Result: <h1/>");
        try {
            float result = Calculator.calculate(firstOperand,secondOperand,operator);
            request.setAttribute("result",result);
//            writer.println(firstOperand+ " " + operator + " " + secondOperand + " = "+ result);
        } catch (Exception ex) {

            String error = ex.getMessage();
            request.setAttribute("error",error);
//            writer.println("Error: "+ ex.getMessage());
        }
        request.setAttribute("firstOperand",firstOperand);
        request.setAttribute("secondOperand",secondOperand);
        request.setAttribute("operator",operator);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request,response);
//        writer.println("</html>");
    }
}
