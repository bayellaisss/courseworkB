//package kg.project.courseworkjava.api;
//
//import kg.project.courseworkjava.model.RoleRequest;
//import kg.project.courseworkjava.model.RoleResponse;
//import kg.project.courseworkjava.service.RoleService;
//import lombok.AccessLevel;
//import lombok.experimental.FieldDefaults;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//
//
//@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
//@RestController
//@RequestMapping("/api/v1/roles")
//public class RoleController {
//    RoleService roleService;
//
//    @Autowired
//    public RoleController(RoleService roleService) {
//        this.roleService = roleService;
//    }
//
//    @PostMapping("/save")
//    public ResponseEntity<RoleResponse> saveRole(@Valid @RequestBody RoleRequest roleResponse){
//        RoleResponse saveRole = roleService.create(roleResponse);
//        return new ResponseEntity<>(saveRole, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/list")
//    public List<RoleResponse> findAllRoles() {
//        return roleService.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<RoleResponse> getRoleById(@PathVariable Long id) {
//        RoleResponse getRoleById = roleService.findById(id);
//        return new ResponseEntity<>(getRoleById, HttpStatus.OK);
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<RoleResponse> updateRole(@Valid @RequestBody RoleRequest roleResponse, @PathVariable Long id) {
//        RoleResponse updated = roleService.update(roleResponse, id);
//        return new ResponseEntity<>(updated, HttpStatus.CREATED);
//    }
//
//    @DeleteMapping("/deleted/{id}")
//    public void deletedRole(@PathVariable Long id) {
//        roleService.deleteById(id);
//    }
//
//
//}
