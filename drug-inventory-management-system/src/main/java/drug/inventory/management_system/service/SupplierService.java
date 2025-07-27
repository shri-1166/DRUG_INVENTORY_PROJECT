package drug.inventory.management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import drug.inventory.management_system.Entity.Supplier;
import drug.inventory.management_system.repository.SupplierRepository;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    public Supplier addSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Supplier updateSupplier(Long id, Supplier updatedSupplier) throws Exception {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new Exception("Supplier not found with id: " + id));
        supplier.setName(updatedSupplier.getName());
        supplier.setContactInfo(updatedSupplier.getContactInfo());
        return supplierRepository.save(supplier);
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }
}