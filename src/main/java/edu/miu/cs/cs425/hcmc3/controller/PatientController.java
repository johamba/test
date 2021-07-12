package edu.miu.cs.cs425.hcmc3.controller;

import edu.miu.cs.cs425.hcmc3.model.Patient;
import edu.miu.cs.cs425.hcmc3.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PatientController {
    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
    @GetMapping("/patient/list")
    public ModelAndView listPatients(){
        var modelAndView=new ModelAndView();
        List<Patient> patients=patientService.getPatients();
        modelAndView.addObject("patients",patients);
        modelAndView.setViewName("patient/list");
        return modelAndView;
    }
    @GetMapping("/patient/elderly")
    public ModelAndView listElderlyPatients(){
        var modelAndView=new ModelAndView();
        List<Patient> patients=patientService.getElderlyPatients();
        modelAndView.addObject("patients",patients);
        modelAndView.setViewName("patient/elderly");
        return modelAndView;
    }

    @GetMapping(value = {"/patient/new"})
    public String displayNewPatientForm(Model model){
        model.addAttribute("patient",new Patient());
        return "patient/new";

    }
    @PostMapping(value = {"/patient/add"})
    public String addNewPatient(@Valid
                             @ModelAttribute("patient")
                                     Patient patient, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors",bindingResult.getAllErrors());
            return "patient/new";
        }
        patientService.savePatient(patient);
        return "redirect:/patient/list";
    }
    @GetMapping(value = {"/patient/edit/{patientId}"})
    public String editPatient(@PathVariable Long patientId, Model model){
        Patient patient=patientService.getPatientById(patientId);
        if(patient!=null){
            model.addAttribute("patient",patient);
            return "patient/edit";
        }
        else {

        }
        return "patient/list";

    }
    @PostMapping(value = {"/patient/edit"})
    public String updatePatient(@Valid @ModelAttribute("patient") Patient patient,
                             BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors",bindingResult.getAllErrors());
            return "patient/edit";
        }
        patient=patientService.savePatient(patient);
        return "redirect:/patient/list";

    }
    @GetMapping(value = {"/patient/delete/{patientId}"})
    public String deletePatient(@PathVariable Long patientId,Model model){
        patientService.deletePatientById(patientId);
        return "redirect:/patient/list";
    }

}