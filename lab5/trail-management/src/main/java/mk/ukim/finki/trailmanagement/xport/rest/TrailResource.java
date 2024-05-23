package mk.ukim.finki.trailmanagement.xport.rest;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.trailmanagement.domain.models.trail.Trail;
import mk.ukim.finki.trailmanagement.services.TrailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/trail")
@RequiredArgsConstructor
public class TrailResource {

    private final TrailService trailService;

    @GetMapping
    public List<Trail> getAllTrails() {
        return trailService.findAll();
    }
}
