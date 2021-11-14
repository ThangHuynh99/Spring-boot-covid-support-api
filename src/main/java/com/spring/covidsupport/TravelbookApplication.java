package com.spring.covidsupport;

import com.spring.covidsupport.repository.CityRepository;
import com.spring.covidsupport.repository.DistrictRepository;
import com.spring.covidsupport.repository.WardRepository;
import com.spring.covidsupport.service.RoleService;
import com.spring.covidsupport.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@RequiredArgsConstructor
public class TravelbookApplication implements CommandLineRunner {
    private final UserService userService;
    private final RoleService roleService;
    private final DistrictRepository districtRepository;
    private final CityRepository cityRepository;
    private final WardRepository wardRepository;

    List<String> district = Arrays.asList("Quận Hải Châu",
            "Quận Cẩm Lệ",
            "Quận Thanh Khê",
            "Quận Liên Chiểu",
            "Quận Ngũ Hành Sơn",
            "Quận Sơn Trà",
            "Huyện Hòa Vang");

    private static List<List<String>> ward = new ArrayList<>();

    static {
        ward.add(Arrays.asList("Bình Hiên",
                "Bình Thuận",
                "Hải Châu",
                "Hải Châu I",
                "Hải Châu II",
                "Hòa Cường Bắc",
                "Hòa Cường Nam",
                "Hòa Thuận Đông",
                "Hòa Thuận Tây",
                "Nam Dương",
                "Phước Ninh",
                "Thạch Thang",
                "Thanh Bình",
                "Hải Châu",
                "Thuận Phước")
        );
        ward.add(Arrays.asList("Hòa An",
                "Hòa Phát",
                "Hòa Thọ Đông",
                "Hòa Thọ Tây",
                "Hòa Xuân",
                "Khuê Trung")
        );
        ward.add(Arrays.asList("An Khê",
                "Chính Gián",
                "Hòa Khê",
                "Tam Thuận",
                "Tân Chính",
                "Thạc Gián",
                "Thanh Khê Đông",
                "Thanh Khê Tây",
                "Vĩnh Trung",
                "Xuân Hà")
        );

        ward.add(Arrays.asList("Hòa Hiệp Bắc",
                "Hòa Hiệp Nam",
                "Hòa Khánh Bắc",
                "Hòa Khánh Nam",
                "Hòa Minh")
        );

        ward.add(Arrays.asList("Hòa Hải",
                "Hòa Quý",
                "Khuê Mỹ",
                "Mỹ An")
        );

        ward.add(Arrays.asList("An Hải Bắc",
                "An Hải Đông",
                "An Hải Tây",
                "Mân Thái",
                "Nại Hiên Đông",
                "Phước Mỹ",
                "Thọ Quang")
        );

        ward.add(Arrays.asList("Hòa Châu",
                "Hòa Khương",
                "Hòa Liên",
                "Hòa Nhơn",
                "Hòa Ninh",
                "Hòa Phong",
                "Hòa Phú",
                "Hòa Phước",
                "Hòa Sơn",
                "Hòa Tiến")
        );
    }
    public static void main(String[] args) {
        SpringApplication.run(TravelbookApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        UserEntity userEntity = new UserEntity("Huynh Ba Thang", "admin", "123456", "22", "male", "32 hoang the thien", "0905548920", "thang.huynh304@gmail.com", new SimpleDateFormat("dd/MM/yyyy").parse("30/04/1999"), new ArrayList<>());
//        UserEntity userEntity1 = new UserEntity("Pham Thi Minh Thuy", "manager", "123456", "25", "female", "54/3 ong ich khiem", "0935217297", "vetsieuquay@gmail.com", new SimpleDateFormat("dd/MM/yyyy").parse("17/02/1996"), new ArrayList<>());
//        userService.save(userEntity);
//        userService.save(userEntity1);
//
//        RoleEntity roleEntity = new RoleEntity(RoleName.ROLE_ADMIN, new ArrayList<>());
//        RoleEntity roleEntity1 = new RoleEntity(RoleName.ROLE_USER, new ArrayList<>());
//        RoleEntity roleEntity2 = new RoleEntity(RoleName.OWNER, new ArrayList<>());
//        RoleEntity roleEntity3 = new RoleEntity(RoleName.ROLE_MANAGER, new ArrayList<>());
//        roleService.save(roleEntity);
//        roleService.save(roleEntity1);
//        roleService.save(roleEntity2);
//        roleService.save(roleEntity3);
//
//        userService.saveRoleToUser("admin", RoleName.ROLE_ADMIN);
//        userService.saveRoleToUser("admin", RoleName.ROLE_USER);
//        userService.saveRoleToUser("admin", RoleName.ROLE_MANAGER);
//        userService.saveRoleToUser("manager", RoleName.ROLE_USER);
//        userService.saveRoleToUser("manager", RoleName.ROLE_MANAGER);
//        List<String> district = Arrays.asList("Quận Hải Châu",
//                "Quận Cẩm Lệ",
//                "Quận Thanh Khê",
//                "Quận Liên Chiểu",
//                "Quận Ngũ Hành Sơn",
//                "Quận Sơn Trà",
//                "Huyện Hòa Vang");
//        long id = 1;
//        City city = cityRepository.getById(id);
//
//        for (int i = 0; i < district.size(); i++) {
//            long index = i + 1;
//            District district1 = districtRepository.getById(index);
//            district1.setName(district.get(i));
//            district1.setCity(city);
//            district1.setWards(getListWards(i));
//            districtRepository.save(district1);
//            getListWards(i, district1);
//        }
    }

//    private void getListWards(int index, District entity) {
//        getWards(index, entity);
//    }
//
//    private void getWards(int index, District entity) {
//        List<Ward> wards = new ArrayList<>();
//        for (int i = 0; i < ward.get(index).size(); i++) {
//            Ward wardEntity = new Ward();
//            wardEntity.setName(ward.get(index).get(i));
//            wardEntity.setDistrict(entity);
//            wardRepository.save(wardEntity);
//        }
//    }
}
