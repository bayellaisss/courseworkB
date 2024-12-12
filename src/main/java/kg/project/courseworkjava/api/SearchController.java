package kg.project.courseworkjava.api;

import kg.project.courseworkjava.entity.Faculty;
import kg.project.courseworkjava.entity.UniversityLink;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
public class SearchController {

    private List<Faculty> faculties = new ArrayList<>();

    public SearchController() {
        List<UniversityLink> infUni = List.of(
                new UniversityLink("Кыргызский национальный университет", "https://www.google.com/search?q=Кыргызский+национальный+университет"),
                new UniversityLink("Кыргызско-Российский славянский университет", "https://www.google.com/search?q=Кыргызско-Российский+славянский+университет")
        );
        faculties.add(new Faculty("Факультет Информатики", "Обучение программированию, искусственному интеллекту и анализу данных.", infUni));

        List<UniversityLink> econUni = List.of(
                new UniversityLink("Американский университет в Кыргызстане", "https://www.google.com/search?q=Американский+университет+в+Кыргызстане"),
                new UniversityLink("Кыргызский экономический университет", "https://www.google.com/search?q=Кыргызский+экономический+университет")
        );
        faculties.add(new Faculty("Факультет Экономики", "Подготовка специалистов в области финансов и бухгалтерского учёта.", econUni));

        List<UniversityLink> lawUni = List.of(
                new UniversityLink("Кыргызский национальный университет", "https://www.google.com/search?q=Кыргызский+национальный+университет"),
                new UniversityLink("Юридический факультет КРСУ", "https://www.google.com/search?q=Юридический+факультет+КРСУ")
        );
        faculties.add(new Faculty("Юридический факультет", "Готовит профессионалов в области права и правосудия.", lawUni));

        List<UniversityLink> medUni = List.of(
                new UniversityLink("Киргизский государственный медицинский университет", "https://www.google.com/search?q=Киргизский+государственный+медицинский+университет"),
                new UniversityLink("Кыргызский медицинский университет", "https://www.google.com/search?q=Кыргызский+медицинский+университет")
        );
        faculties.add(new Faculty("Медицинский факультет", "Программы обучения для будущих врачей и фармацевтов.", medUni));
    }

    @GetMapping("/search")
    public String searchFaculties(@RequestParam("query") String query, Model model) {
        String lowerQ = query.toLowerCase();
        List<Faculty> result = faculties.stream()
                .filter(f -> f.getName().toLowerCase().contains(lowerQ))
                .toList();
        model.addAttribute("faculties", result);
        model.addAttribute("query", query);
        return "faculties";
    }
}
