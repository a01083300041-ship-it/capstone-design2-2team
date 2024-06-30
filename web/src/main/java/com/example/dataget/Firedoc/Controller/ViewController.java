package com.example.dataget.Firedoc.Controller;

import com.example.dataget.Firedoc.Service.BridgeService;
import com.example.dataget.Firedoc.Service.RainService;

import com.example.dataget.Firedoc.Structure.Bridge;
import com.example.dataget.Firedoc.Structure.Rain;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ViewController {
    private final RainService rainService;
    private final BridgeService bridgeService;

    @GetMapping("/rain")
    public String getRainData(@RequestParam(name = "searchQuery", required = false) String searchQuery, Model model) throws ExecutionException, InterruptedException {
        List<Rain> list = null;
        if (searchQuery != null && !searchQuery.isEmpty()) {
            list = rainService.getRains(searchQuery);
        } else {
            list = rainService.getRains();
        }
        model.addAttribute("rain", list);
        return "rain";
    }

    @GetMapping("/bridge")
    public String getBridgeData(@RequestParam(name = "searchQuery", required = false) String searchQuery,Model model) throws ExecutionException, InterruptedException {
        List<Bridge> list = null;
        if (searchQuery != null && !searchQuery.isEmpty()) {
            list = bridgeService.getBridges(searchQuery);
        } else {
            list = bridgeService.getBridges();
        }
        model.addAttribute("bridge", list);
        return "bridge";
    }

    @GetMapping("/main")
    public String getMain() {
        return "main";
    }


}
