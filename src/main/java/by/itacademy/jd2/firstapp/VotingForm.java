package by.itacademy.jd2.firstapp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.DataInput;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/voting_form")
public class VotingForm extends HttpServlet {


    private int immortalCount = 0;
    private int ledZeppelinCount = 0;
    private int metallicaCount = 0;
    private int dimaBilanCount = 0;

    private int pop = 0;
    private int jazz = 0;
    private int rock = 0;
    private int rap = 0;
    private int metal = 0;
    private int country = 0;
    private int hardcore = 0;
    private int bluze = 0;
    private int hiphop = 0;
    private int disco = 0;

    private int date;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException, NullPointerException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain; charset=utf-8");
        String text = request.getParameter("feedback");
        if (request.getParameter("theWorstPerformer").equals("Immortal")) {
            immortalCount++;
        } else if (request.getParameter("theWorstPerformer").equals("Led Zeppelin")) {
            ledZeppelinCount++;
        } else if (request.getParameter("theWorstPerformer").equals("Metallica")) {
            metallicaCount++;
        } else if (request.getParameter("theWorstPerformer").equals("Dima Bilan")) {
            dimaBilanCount++;
        }

        Map<String, Integer> unsortedMap = new HashMap<>();
        unsortedMap.put("Immortal", immortalCount);
        unsortedMap.put("Led Zeppelin", ledZeppelinCount);
        unsortedMap.put("Metallica", metallicaCount);
        unsortedMap.put("Dima Bilan", dimaBilanCount);

        Map<String, Integer> sortedMap = unsortedMap.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getValue))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new
                ));

        if (Objects.equals(request.getParameter("inp1"), "Pop")) {
            pop++;
        }
        if (Objects.equals(request.getParameter("inp2"), "Jazz")) {
            jazz++;
        }
        if (Objects.equals(request.getParameter("inp3"), "Rock")) {
            rock++;
        }
        if (Objects.equals(request.getParameter("inp4"), "Rap")) {
            rap++;
        }
        if (Objects.equals(request.getParameter("inp5"), "Metal")) {
            metal++;
        }
        if (Objects.equals(request.getParameter("inp6"), "Country")) {
            country++;
        }
        if (Objects.equals(request.getParameter("inp7"), "HardCore")) {
            hardcore++;
        }
        if (Objects.equals(request.getParameter("inp8"), "Bluze")) {
            bluze++;
        }
        if (Objects.equals(request.getParameter("inp9"), "Hip-Hop")) {
            hiphop++;
        }
        if (Objects.equals(request.getParameter("inp10"), "Disco")) {
            disco++;
        }

        Map<String, Integer> unsortedMapGenre = new HashMap<>();
        unsortedMapGenre.put("Pop", pop);
        unsortedMapGenre.put("Jazz", jazz);
        unsortedMapGenre.put("Rock", rock);
        unsortedMapGenre.put("Rap", rap);
        unsortedMapGenre.put("Metal", metal);
        unsortedMapGenre.put("Country", country);
        unsortedMapGenre.put("HardCore", hardcore);
        unsortedMapGenre.put("Bluze", bluze);
        unsortedMapGenre.put("Hip-Hop", hiphop);
        unsortedMapGenre.put("Disco", disco);

        Map<String, Integer> sortedMapGenre = unsortedMapGenre.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getValue))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new
                ));



        List<Feedback> textsTime = new ArrayList<>();
        textsTime.add(new Feedback(text));

        PrintWriter writer = response.getWriter();

        writer.println("Лучший исполнитель: " + sortedMap);
        writer.println(" ");
        writer.println("Лучший жанр: " + sortedMapGenre);
        writer.println(" ");
        writer.println(textsTime.toString());
    }
}

