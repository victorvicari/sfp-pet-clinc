package de.qmsq.sfgpetclinic.services.map;

import de.qmsq.sfgpetclinic.model.Specialty;
import de.qmsq.sfgpetclinic.model.Vet;
import de.qmsq.sfgpetclinic.services.SpecialtyService;
import de.qmsq.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet vet) {

        if (vet.getSpecialties().size() > 0) {
            vet.getSpecialties().forEach(specialty ->  {
                if (specialty.getId() == null) {
                    Specialty saveSpecality = specialtyService.save(specialty);
                    specialty.setId(saveSpecality.getId());
                }
            });
        }

        return super.save(vet);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
