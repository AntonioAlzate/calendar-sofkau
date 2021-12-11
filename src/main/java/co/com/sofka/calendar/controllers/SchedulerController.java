package co.com.sofka.calendar.controllers;

import co.com.sofka.calendar.model.ProgramDate;
import co.com.sofka.calendar.services.ProgramDateService;
import co.com.sofka.calendar.services.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("api/v1/calendar")
public class SchedulerController {

    @Autowired
    SchedulerService service;

    @Autowired
    ProgramDateService programDateService;

    @GetMapping("/generate/{id}/{date}")
    public Flux<ProgramDate> generateCalendar(@PathVariable("id") String id, @PathVariable("date") String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        var startDate = LocalDate.parse(date, formatter);

        var calendar = service.generateCalendar(id, startDate);

        programDateService.saveCalendar(calendar).subscribe(System.out::println);

        return calendar;
    }

    @GetMapping("/get")
    public Flux<ProgramDate> getCalendar() {
        return programDateService.getCalendar();
    }
}
