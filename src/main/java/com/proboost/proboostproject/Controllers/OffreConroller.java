package com.proboost.proboostproject.Controllers;


import com.proboost.proboostproject.Modules.Offre_Emploi;
import com.proboost.proboostproject.Modules.cvFile;
import com.proboost.proboostproject.Services.OffreService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/offre")
public class OffreConroller {

    private OffreService offreService;

    @PostMapping("/add/{id}")
    public Offre_Emploi add(@RequestBody Offre_Emploi offreEmploi , @PathVariable("id") int id)
    {
       return   offreService.add(offreEmploi,id);
    }

    @GetMapping("/all")
    public ResponseEntity< List<Offre_Emploi>> getall()
    {
        System.out.println("it works offre");
        return  new ResponseEntity<List<Offre_Emploi>>(offreService.getall(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public Offre_Emploi get(@PathVariable("id") int id){
        return offreService.getOffre(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id)
    {
        return offreService.delete(id);
    }

    //    public Offre_Emploi update(@RequestBody Offre_Emploi offreEmploi){return offreService.update(offreEmploi);}
    @PutMapping("/{userid}")
    public Offre_Emploi update(@RequestBody Offre_Emploi offreEmploi , @PathVariable("userid") int userid)
    {
        return offreService.update(offreEmploi, userid);
    }


    @GetMapping("/{id}/CVs")
    public List<cvFile> getOfferCVs(@PathVariable("id") int id){
        return offreService.getOfferCVs(id);
    }


    @GetMapping("/salary/{min}/{max}")
    public List<Offre_Emploi>  SalarySearch(@PathVariable("min") int min , @PathVariable("max") int max ){
        System.out.println("cc");
        return offreService.offreSalaryRange(min, max);

    }

    @GetMapping("maxSalary")
    public int maxSalary(){ return offreService.maxSalary();}

    @GetMapping("minSalary")
    public int minSalary(){ return offreService.minSalary();}


}