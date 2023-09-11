package by.itacademy.jd2.firstapp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.Scanner;

@WebServlet(urlPatterns = "/hello_with_name")
public class HelloWithNameServlet extends HttpServlet {

    /**
     * Сделать консольное приложение:
     * 1) Которое будет запрашивать Фамилию и Имя пользователя через консоль
     * 2) Сделает http запрос из этого консольного приложения
     * и передаст через Query String (Параметры) на урл сервлета (/hello_with_name)
     * 3) В случае успеха распечатает полученное сообщение от сервера в консоль,
     * иначе сообщит о проблеме
     * <p>
     * Как проверять работу:
     * 1) Проверить в access логе что появилась строка с вашим запросом и статусом 200
     * 2) Дебагом на сервере
     * <p>
     * Мне в личку прислать:
     * 1) ФИО
     * 2) код консольного приложения в виде класса
     * 3) скрин из access лога где видно что запрос прошел успешно
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain; charset=utf-8");
        //resp.setHeader("Content-Type", "text/plain; charset=utf-8");

//        String firstName = req.getParameter("firstName");
//        String lastName = req.getParameter("lastName");

        PrintWriter writer = resp.getWriter();

        Enumeration<String> params = req.getParameterNames();

        while (params.hasMoreElements()) {
            String paramName = params.nextElement();
            writer.write("<p>" + paramName + ": " + req.getParameter(paramName) + "</p>");

        }
    }
//        writer.write("Hello, " + lastName + " " + firstName + "!");
}

