//package kg.project.courseworkjava.mapper;
//
//
//import kg.project.courseworkjava.entity.Role;
//import kg.project.courseworkjava.entity.University;
//import kg.project.courseworkjava.model.RoleRequest;
//import kg.project.courseworkjava.model.RoleResponse;
//import kg.project.courseworkjava.model.UniversityRequest;
//import kg.project.courseworkjava.model.UniversityResponse;
//import org.mapstruct.Mapper;
//import org.mapstruct.MappingTarget;
//import org.mapstruct.NullValuePropertyMappingStrategy;
//
//@Mapper(
//        componentModel = "spring",
//        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
//        uses = {
//
//        }
//)
//public interface UniversityMapper {
//    UniversityResponse entityToResponse(University user);
//
//    University requestToEntity(UniversityRequest request);
//
//    void update(@MappingTarget University entity, UniversityRequest request);
//}
