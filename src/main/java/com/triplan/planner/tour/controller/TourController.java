package com.triplan.planner.tour.controller;

import com.triplan.planner.tour.dto.Attraction;
import com.triplan.planner.tour.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Controller
@RequiredArgsConstructor
public class TourController {

    private final TourService tourService;
    // api 데이터베이스에 저장 요청
    @GetMapping("/tour/saveAll")
    public ResponseEntity<String> saveAllTours() {
        try {
            int startContentId = 128701;
            int endContentId = 129700;

            for (int contentId = startContentId; contentId <= endContentId; contentId++) {
                tourService.saveTour(String.valueOf(contentId));
            }

            return ResponseEntity.ok("All tourist attractions saved successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error occurred: " + e.getMessage());
        }
    }

    //하나씩 값을 넣을 때
    /*@GetMapping("/tour/save")
    public ResponseEntity<String> saveTour(@RequestParam String contentId){

        try {
            tourService.saveTour(contentId);
            return ResponseEntity.ok("Tourist attraction saved successfully!");
        } catch (URISyntaxException | JsonProcessingException e) {
            return ResponseEntity.status(500).body("Error occurred: " + e.getMessage());
        }

    }*/

    // 여행 정보 리스트 요청
    @GetMapping("/tour/list")
    public String tourList(@ModelAttribute("local") String local,
                           Model model){
        //local 파라미터 없이 접근 시 기본값 S(서울)
        if(local.isEmpty())
            local = "S";
        Map<String, List<String>> area =  new HashMap<String, List<String>>();
        String[] s = {"1"};
        String[] gg = {"31","2"};
        String[] gw = {"32"};
        String[] cb = {"33"};
        String[] cn = {"34","8","3"};
        String[] gb = {"35","4"};
        String[] gn = {"36","7","6"};
        String[] jn = {"38","5"};
        String[] jb = {"37"};
        String[] jj = {"39"};
        area.put("S", Arrays.asList(s));
        area.put("GG", Arrays.asList(gg));
        area.put("GW", Arrays.asList(gw));
        area.put("CB", Arrays.asList(cb));
        area.put("CN", Arrays.asList(cn));
        area.put("GB", Arrays.asList(gb));
        area.put("GN", Arrays.asList(gn));
        area.put("JN", Arrays.asList(jn));
        area.put("JB", Arrays.asList(jb));
        area.put("JJ", Arrays.asList(jj));
        List<String> areaCode = area.get(local);

        List<Attraction> attractions = tourService.tourList(areaCode);
        model.addAttribute("attraction", attractions);
        return "/tour/list";
    }
}
