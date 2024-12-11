//package kg.project.courseworkjava.service.impl;
//
//import kg.project.courseworkjava.entity.Role;
//import kg.project.courseworkjava.exception.RecordNotFoundException;
//import kg.project.courseworkjava.mapper.RoleMapper;
//import kg.project.courseworkjava.model.RoleRequest;
//import kg.project.courseworkjava.model.RoleResponse;
//import kg.project.courseworkjava.repos.RoleRepos;
//import kg.project.courseworkjava.service.RoleService;
//import lombok.AccessLevel;
//import lombok.experimental.FieldDefaults;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
//public class RoleServiceImpl implements RoleService {
//    RoleRepos roleRepository;
//    RoleMapper roleMapper;
//
//    @Autowired
//    public RoleServiceImpl(RoleRepos roleRepository,
//                           RoleMapper roleMapper) {
//        this.roleRepository = roleRepository;
//        this.roleMapper = roleMapper;
//    }
//
//    @Override
//    public RoleResponse create(RoleRequest roleRequest) {
//        if (roleRepository.getByName(roleRequest.getName()) != null) {
//            throw new RecordNotFoundException("Роль с таким именем существует!");
//        }
//
//        Role role = roleMapper.requestToEntity(roleRequest);
//        Role savedRole = roleRepository.save(role);
//        return roleMapper.entityToResponse(savedRole);
//    }
//
//    @Override
//    public RoleResponse findById(Long id) {
//        Role role = roleRepository.findById(id)
//                .orElseThrow(() -> new RecordNotFoundException("Роль с таким id не существует!"));
//        return roleMapper.entityToResponse(role);
//    }
//
//    @Override
//    public RoleResponse update(RoleRequest roleRequest, Long roleId) {
//        Role role = roleRepository.findById(roleId)
//                .orElseThrow(() -> new RecordNotFoundException("Роль с таким id не существует"));
//        roleMapper.update(role, roleRequest);
//        Role updatedRole = roleRepository.save(role);
//        return roleMapper.entityToResponse(updatedRole);
//    }
//
//    @Override
//    public List<RoleResponse> findAll() {
//        List<Role> roles = roleRepository.findAll();
//        return roles.stream().map(roleMapper::entityToResponse).collect(Collectors.toList());
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        Role role = this.roleRepository.getById(id);
//        roleRepository.deleteById(id);
//    }
//
//}
