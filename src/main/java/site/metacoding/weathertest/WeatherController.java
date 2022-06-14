package site.metacoding.weathertest;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class WeatherController {

    private final WeatherRepository weatherRepository;

    @GetMapping("/weather")
    public String main(Model model) {
        List<Weather> weather = weatherRepository.findAll();

        model.addAttribute("weather", weather);

        return "/weather";

    }
}