package com.ifpb.dev.web.atividade5;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;


@WebServlet("/questao1-servlet")
public class Questao1Servlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> body = req.getParameterMap();
        Integer distance = null;
        if (body.get("distance").length > 0) {
            distance = Integer.parseInt(body.get("distance")[0]);
        }

        Integer time = null;
        if (body.get("time").length > 0) {
            time = Integer.parseInt(body.get("time")[0]);
        }

        Integer consumption = null;
        if (body.get("consumption").length > 0) {
            consumption = Integer.parseInt(body.get("consumption")[0]);
        }

        if (time!= null && distance != null && consumption != null) {
            Double avgSpeed = distance.doubleValue() / time.doubleValue();
            Double avgDistancePerConsumption = distance.doubleValue() / consumption.doubleValue();
            req.setAttribute("avgSpeed", avgSpeed);
            req.setAttribute("avgDistancePerConsumption", avgDistancePerConsumption);
            req.getRequestDispatcher("questao1-resp.jsp").forward(req, resp);
        } else {

        }
    }
}