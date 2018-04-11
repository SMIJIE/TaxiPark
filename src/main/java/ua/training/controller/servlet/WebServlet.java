package ua.training.controller.servlet;

import ua.training.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * WebServlet
 * <p>
 * Description: This is the WebServlet class
 * <p>
 * Created: 09.04.2018
 * <p>
 * Updated:
 *
 * @author Zakusylo Pavlo
 */
public class WebServlet extends HttpServlet {
    private Map<String, Command> commands;

    @Override
    public void init() throws ServletException {

        final Object commands = getServletContext().getAttribute("commands");

        if (commands == null || !(commands instanceof ConcurrentHashMap)) {
            throw new IllegalStateException("You're repo does not initialize!");
        } else {
            this.commands = (Map<String, Command>) commands;
        }
    }

    @Override
    public void destroy() {
        commands = null;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String path = req.getRequestURI();
        System.out.println(path);
        path = path.replaceAll(".*/taxi/", "");
        System.out.println(path);

        Command command = commands.getOrDefault(path, (r) -> "/index.jsp)");

        String page = command.execute(req);

        if (page.contains("redirect")) {
            resp.sendRedirect(page.replace("redirect:", "/app"));
        } else {
            req.getRequestDispatcher(page).forward(req, resp);
        }
    }
}
