package com.example.aimagency.controller;

import com.example.aimagency.model.AltServis;
import com.example.aimagency.service.AltServisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alt-servisler")
@CrossOrigin(origins = "*")
public class AltServisController {

    @Autowired
    private AltServisService altServisService;  // ✅ Repository yerine Service enjekte ettik

    @GetMapping
    public List<AltServis> getAll() {
        return altServisService.getAll();  // ✅ Artık service üzerinden erişiyoruz
    }

    @PostMapping
    public AltServis addAltServis(@RequestBody AltServis altServis) {
        return altServisService.save(altServis);  // ✅ İş mantığı service içinde
    }

    @PutMapping("/{id}")
    public ResponseEntity<AltServis> updateAltServis(@PathVariable Long id, @RequestBody AltServis altServis) {
        AltServis updated = altServisService.update(id, altServis);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAltServis(@PathVariable Long id) {
        altServisService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
